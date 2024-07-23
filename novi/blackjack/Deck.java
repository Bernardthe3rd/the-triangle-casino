package novi.blackjack;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        CardSuit[] suit = new CardSuit[]{
                new CardSuit('\u2666', "ruiten", "rood"),
                new CardSuit('\u2660', "schoppen", "zwart"),
                new CardSuit('\u2665', "harten", "rood"),
                new CardSuit('\u2663', "klaver", "zwart")
        };

        CardValue[] values = new CardValue[]{
                new CardValue("one", 1),
                new CardValue("two", 2),
                new CardValue("three", 3),
                new CardValue("four", 4),
                new CardValue("five", 5),
                new CardValue("six", 6),
                new CardValue("seven", 7),
                new CardValue("eight", 8),
                new CardValue("nine", 9),
                new CardValue("ten", 10),
                new CardValue("boer", 10),
                new CardValue("vrouw", 10),
                new CardValue("koning", 12),
        };

        cards = new ArrayList<>();
        for (CardSuit suite : suit) {
            for (CardValue value : values) {
                cards.add(new Card(suite, value));
            }
        }

    }

    public void shuffle() {

    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public Card getNextCard() {
        return cards.getLast();
    }
}
