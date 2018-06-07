package edu.hm.kniffel.ui;

import edu.hm.kniffel.DiceList;

/**
 * Observer interface for dice rolled by user.
 * @author <a mailto:ab@cs.hm.edu>Axel B&ouml;ttcher</a>
 */
public interface DiceObserver {
    
    /**
     * Informs an observer of the lately rolled dice values.
     * @param dice Dice values as rolled.
     */
    void currentValues(DiceList dice);
    
    /**
     * Informs an observer of the currently active try.
     * @param currentTry Number of try (1...3).
     */
    void triesLeft(int currentTry);
    
}
