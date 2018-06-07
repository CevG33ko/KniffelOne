package edu.hm.kniffel.functionalityFirstImplementation;

/**
 * Ein Objekt dieser Klasse repraesentiert eine einzelne Regel, wie fuer eine Scoring-Kategorie
 * Punkte zu berechnen sind. Es berechnet aus den als Parameter uebergegebenen Wuerfel-
 * werten den entsprechenden Score-Wert(siehe Scoring-Category)
 */
public interface IScoreCalculator {
    int score(DiceList diceList);
}
