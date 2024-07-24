package novi.blackjack;

public class CardSuit {
    private final String name;
    private final char symbol;
    private final String color;

    public CardSuit(char symbol, String name, String color) {
        this.symbol = symbol;
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getColor() {
        return color;
    }
}
