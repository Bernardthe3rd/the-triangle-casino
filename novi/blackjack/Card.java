package novi.blackjack;

public class Card {
    private final CardSuit suit;
    private final CardValue value;

    public Card(CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public String render() {
        return String.format(" %s %s ", suit.getSymbol(), value.getName());
    }

    public int getValue() {
        return value.getValue();
    }
}
