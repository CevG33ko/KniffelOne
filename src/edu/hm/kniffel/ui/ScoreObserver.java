package edu.hm.kniffel.ui;

//TODO Scorboard?
import edu.hm.kniffel.functionalityFirstImplementation.Scorecard;

/**
 * Observer interface for notification of components interested in score changes.
 */
public interface ScoreObserver {

    /**
     * to be calle dwhen score changed.
     * @param scoreCard Score card containing scoring-relevant information.
     */
    void scoreChanged(Scorecard scoreCard);

}
