package edu.hm.kniffel.functionalityFirstImplementation;

public class Scorecard {

    public Scorecard() {
        //TODO Kontruktor erweitern

    }
    int totalScore(){
        return 0;
    }

    boolean addAsCategory(ScoringCategory,DiceList){
        return true;
    }

    int bonus(){
      return 0;
    }

    int scoreUpper(){
        return 0;
    }

    int scoreLower(){
        return 0;
    }

    DiceList diceInCategory(ScoringCategory){
        return new DiceList();
    }

    boolean isFull(){
        return true;
    }
}
