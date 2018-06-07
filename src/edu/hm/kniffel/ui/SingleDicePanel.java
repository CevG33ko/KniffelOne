package edu.hm.kniffel.ui;

import edu.hm.kniffel.DiceList;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Panel that represents a single dice.
 */
@SuppressWarnings("serial")
public class SingleDicePanel extends JPanel {

    public static final int DICE_SIZE = 40;

    private BufferedImage img = null;
    private boolean selected = false;
    private int value = 0;

    /**
     * default ctor.
     */
    public SingleDicePanel() {
        this.setPreferredSize(new Dimension(DICE_SIZE, DICE_SIZE));
        this.setMaximumSize(new Dimension(DICE_SIZE, DICE_SIZE));
        this.setBackground(RollDicePanel.BACKGROUND_COLOR);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            int size = Integer.min(this.getWidth(), this.getHeight());
            g.drawImage(img, 0, 0, size, size, this);
        }
    }

    /**
     * Sets the value to be displayed for the dice.
     * Note that 0 as value is legal to indicate a dice value that was
     * replaced by setting a score to 0.
     * @param value Value to display: 0...6
     */
    public void setValue(int value) {
        if (value < 0 || value > DiceList.MAX_DICE_VALUE) {
            throw new IllegalArgumentException("Diece value must be between 0 (inclusive) and 6 (inclusive)");
        }
        this.value = value;
        try {
            img = ImageIO.read(new File("resources/" + this.value + (this.selected ? "_.png" : ".png")));
            this.repaint();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Flips image of a dice. Used to mark dice for a re-roll.
     */
    public void flipSelected() {
        this.selected = !this.selected;
        this.setValue(this.value);
    }

    /**
     * Indicates if a dice is selected (for re-roll).
     * @return true iff is selected.
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * "Setter" to hard-unselect a dice.
     */
    public void setUnselected() {
        this.selected = false;
    }

    /**
     * Getter for dice value.
     * @return dice value.
     */
    public int getValue() {
        return value;
    }
    
}
