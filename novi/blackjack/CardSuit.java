package novi.blackjack;

public class CardSuit {
    public String name;
    public char symbol;
    public String color;

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
