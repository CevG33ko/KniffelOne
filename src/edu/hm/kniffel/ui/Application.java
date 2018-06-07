package edu.hm.kniffel.ui;

import edu.hm.kniffel.Scorecard;

import javax.swing.*;
import java.awt.*;

/**
 * GUI-Klasse for the Kniffel/Yahtzee-exercise.
 * 
 * @author <a href="mailto:ab@cs.hm.edu>Axel Boettcher</a>
 * 
 */
@SuppressWarnings("serial")
public class Application extends JFrame {

    public static final int WINDOW_WIDTH = 450;
    public static final int WINDOW_HEIGHT = 600;

    /**
     * Initialisiert das GUI mit dem Panel zum Darstellen der Wuerfel.
     * @param scoreCardPanel Main panel to be displayed in Application's frame.
     */
    public Application(ScoreCardPanel scoreCardPanel) {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(scoreCardPanel);
        this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setVisible(true);
        this.setTitle("Kniffel");
        this.pack();
    }

    /**
     *
     * @param args Unused.
     */
    public static void main(String... args) {
        Scorecard scorecard = new Scorecard();
        PlayerController playerController = new PlayerController(scorecard);
        ScorePanel scorePanel = new ScorePanel();
        playerController.addScoreObserver(scorePanel);
        ScoreCardPanel scoreCardPanel = new ScoreCardPanel(new RollDicePanel(playerController), scorePanel);
        playerController.addDiceObserver(scoreCardPanel);
        new Application(scoreCardPanel);
        playerController.nextRound();
    }

}
