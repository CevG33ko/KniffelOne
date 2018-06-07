package edu.hm.kniffel.ui;

import java.util.ArrayList;

import edu.hm.kniffel.DiceList;
import edu.hm.kniffel.Scorecard;
import edu.hm.kniffel.ScoringCategory;

/**
 * Controller that represents a player.
 */
public class PlayerController {

    public static final int MAX_TRIES = 3;
    
    private DiceList dice = new DiceList();
    private final Scorecard scorecard;
    private java.util.List<DiceObserver> diceObservers = new ArrayList<>();
    private java.util.List<ScoreObserver> scoreObservers = new ArrayList<>();

    private int currentTry = 1;

    /**
     * Ctor.
     * @param scorecard Underlying scorecard (model)
     */
    public PlayerController(Scorecard scorecard) {
        this.scorecard = scorecard;
    }

    /**
     * Roll dice according to the selected values (representing player's choice).
     * @param selected indexes of dice to roll (again)
     */
    public void rollDice(Boolean[] selected) {
        if (currentTry > MAX_TRIES) {
            return;
        }
        dice = dice.roll(selected);
        currentTry++;
        notifyDiceObservers();
    }

    /**
     * Start next round: at startup and after insertion of dice into a category.
     */
    public void nextRound() {
        currentTry = 1;
        this.dice = new DiceList();
        notifyDiceObservers();
    }

    /**
     * Returns a copy of the currently valid dice on the table
     * in front of this player.
     * @return Dice values.
     */
    public DiceList getDice() {
        return this.dice;
    }

    /**
     * Tries to insert the currently valid dice into the scorecard at the given 
     * position in terms of category. 
     * @param category The category to put values into.
     * @return true iff value could be inserted, i.e. no value was already set 
     * into that category. 
     */
    public boolean insertDiceToCategory(ScoringCategory category) {
        if (!this.scorecard.addAsCategory(category, this.dice)) {
            return false;
        }
        scoreObservers.forEach(o -> {
            o.scoreChanged(this.scorecard);
        });
        return true;
    }

    /**
     * Getter for the score card owned by this player.
     * @return Scorecard (model class).
     */
    public Scorecard getScorecard() {
        return scorecard;
    }

    /**
     * Add a dice observer to the collection of DiceObservers.
     * @param observer Observer to add.
     */
    public void addDiceObserver(DiceObserver observer) {
        this.diceObservers.add(observer);
    }

    /**
     * Add a score observer to the collection of ScoreObservers.
     * @param observer Observer to add.
     */
    public void addScoreObserver(ScoreObserver observer) {
        this.scoreObservers.add(observer);
    }

    /**
     * Helper to notify all diceObservers.
     */
    private void notifyDiceObservers() {
        diceObservers.forEach(o -> {
            o.currentValues(dice);
            o.triesLeft(MAX_TRIES - currentTry);
        });
    }

}
