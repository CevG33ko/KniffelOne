package edu.hm.kniffel.functionalityFirstImplementation;

import java.util.stream.Stream;

/**
 * Diese Klasse repraesentiert fuenf Wuerfelwerte. Die Klasse soll immutable ausgefuehrt sein.
 * Es sollen alle Attribute
 * final
 * sein und es sollen auch intern verwendete Datenstruk-
 * ture(en) zum Speichern der Werte nach der Initialisierung in einem Konstruktor nicht
 * mehr geaendert werden koennen.
 * Hinweis:
 * Sehen Sie sich die Javadocs zu den Methoden
 * Collections.unmodifiable...
 * an (Sie duerfen aber auch andere eigene Ideen umsetzen
 */
public class DiceList {
    //TODO modifier fuer konstanten festlegen
    static final int NUMBER_OF_DICE = 3;
    static final int MAX_DICE_VALUE = 6;

    /**
     * Konstruktor initialisiert die Liste mit fuenf zufaelligen Werten.
     */
    public DiceList() {

    }

    /**
     * Dient hauptsaechlich zum Testen und
     * initialisiert die gespeicherten Wuerfelwerte aus einem ?bergebenen Array. Hier sind alle
     * Voraussetzungen durch Pruefung und ggfs. Werfen von Exception(s) abgesichert.
     * @param dices Array mit festgelegten Wuerfelwerten
     */
    public DiceList(int[] dices) {
        // TODO Werte in dem Array pruefen und Methode durch Entsprechende Exceptions absichern
    }

    /**
     * Diese Methode f?hrt auf diesem Objekt einen Wurf mit W?rfeln aus, wobei nur diejenigen
     * W?rfel neu geworfen werden, bei denen entsprechende Eintrag im Array
     * toRoll den Wert true hat. Gibt ein neues DiceList-Objekt zur?ck, das entsprechend ?alte? und
     * neue W?rfelwerte enth?lt.
     * @param toRoll true? soll neu gewuerfelt werden:soll nicht neu gewuerfelt werden
     * @return  List mit neuen Wuerfelwerten
     */
    DiceList roll(Boolean[] toRoll) {
        return new DiceList();
    }

    /**
     * Liefert einen Stream der Wuerfelwerte.
     * @return Stream der Wuerfelwerte
     */
    Stream<Integer> stream() {
        //TODO Durch Dices ersetzen
        //TODO DiceList als Attribut
        return Stream.of(1, 2, 3);
    }
}
