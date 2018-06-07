package edu.hm.kniffel.ui;

import edu.hm.kniffel.DiceList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.stream.Stream;

/**
 * Panel where process of rolling selecting dice is shown together
 * with number of remaining tries.
 */
@SuppressWarnings("serial")
public class RollDicePanel extends JPanel implements DiceObserver {

    public static final Color BACKGROUND_COLOR = new Color(216, 135, 52);

    private final PlayerController playerController;
    private final SingleDicePanel[] dicePanels = new SingleDicePanel[DiceList.NUMBER_OF_DICE];
    private final JButton rollDiceButton = new JButton("Roll Dice");
//    private final JLabel numberOfTryLabel = new JLabel(" ");

    /**
     * Ctor.
     * @param playerController Underlying controller.
     */
    public RollDicePanel(PlayerController playerController) {
        this.playerController = playerController;
        this.playerController.addDiceObserver(this);
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBackground(BACKGROUND_COLOR);
        rollDiceButton.addActionListener(e -> {
            if (Stream.of(dicePanels).anyMatch(SingleDicePanel::isSelected)) {
                playerController.rollDice(Stream.of(dicePanels).map(SingleDicePanel::isSelected).toArray(Boolean[]::new));
            }
        });
        this.add(rollDiceButton);
        this.add(Box.createHorizontalGlue());
        for (int index = 0; index < 5; index++) {
            final SingleDicePanel dPanel = new SingleDicePanel();
            dicePanels[index] = dPanel;
            this.add(dicePanels[index]);
            this.add(Box.createHorizontalGlue());
            dicePanels[index].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent event) {
                    dPanel.flipSelected();
                }
                @Override
                public void mousePressed(MouseEvent event) { }
                @Override
                public void mouseReleased(MouseEvent event) { }
                @Override
                public void mouseEntered(MouseEvent event) { }
                @Override
                public void mouseExited(MouseEvent event) { }
            });
        }
//        this.add(Box.createHorizontalGlue());
//        this.add(numberOfTryLabel);
    }

    @Override
    public void currentValues(DiceList dice) {
        for (int index = 0; index < DiceList.NUMBER_OF_DICE; index++) {
            dicePanels[index].setUnselected();
            dicePanels[index].setValue(dice.get(index));
        }
    }

    @Override
    public void triesLeft(int currentTry) {
        this.rollDiceButton.setText("Roll (left: " + currentTry + ")");
        this.repaint();
    }

    /**
     * Getter for the controller object.
     * @return Controller object.
     */
    public PlayerController getPlayerController() {
        return playerController;
    }
}
