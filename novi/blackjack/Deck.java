package novi.blackjack;

import java.util.*;
//import java.util.Collections;


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
                new CardValue("koning", 10),
        };

        cards = new ArrayList<>();
        for (CardSuit suite : suit) {
            for (CardValue value : values) {
                cards.add(new Card(suite, value));
            }
        }

    }

    public void shuffle() {
//        Collections.shuffle(cards); easy way?
        Random indexnummer = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int randomIndex = indexnummer.nextInt(i + 1);
            Card temp = cards.get(i);
            cards.set(i, cards.get(randomIndex));
            cards.set(randomIndex, temp);
        }
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public Card getNextCard() {
        Card givingCard = cards.getLast();
        cards.remove(givingCard);
        return givingCard;
    }

    //als je deze methode in main aanroept kan je de huidige volgorde van je deck zien.
    public List<Card> getCards() {
        return cards;
    }
}
