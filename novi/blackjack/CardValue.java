package novi.blackjack;

public class CardValue {
    public String name;
    public int value;

    public CardValue(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
