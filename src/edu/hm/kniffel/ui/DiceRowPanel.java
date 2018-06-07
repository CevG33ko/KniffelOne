package edu.hm.kniffel.ui;

import edu.hm.kniffel.DiceList;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * represents a row of 5 dice.
 */
@SuppressWarnings("serial")
public class DiceRowPanel extends JPanel {

    public static final int NUM_COLS = 5;
    /* border to be drawn around a dice */
    private final GridLayout layout = new GridLayout(1, NUM_COLS);
    private final SingleDicePanel[] grid = new SingleDicePanel[NUM_COLS];

    /**
     * Ctor to initialize the panel.
     */
    public DiceRowPanel() {
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(NUM_COLS * SingleDicePanel.DICE_SIZE, SingleDicePanel.DICE_SIZE));
        this.setMaximumSize(new Dimension(NUM_COLS * SingleDicePanel.DICE_SIZE, SingleDicePanel.DICE_SIZE));
        for (int col = 0; col < NUM_COLS; col++) {
            grid[col] = new SingleDicePanel();
            grid[col].setBorder(BorderFactory.createLineBorder(Color.black));
            grid[col].setBackground(ScoreCardPanel.BACKGROUND_COLOR);
            this.add(grid[col]);
        }
    }

    /**
     * Setter to set dice values for the panel.
     * @param dice Values to set (must be 5values; not checked).
     */
    public void setDice(DiceList dice) {
        for (int index = 0; index < NUM_COLS; index++) {
            grid[index].setValue(dice.get(index));
        }
        this.repaint();
    }

}
