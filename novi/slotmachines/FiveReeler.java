package novi.slotmachines;

public class FiveReeler extends SlotMachine {
    private final String name = "Five Reeler";
    private final int numberOfReels = 5;
    private final int rollPrice = 5;

    public FiveReeler(String name, int numberOfReels) {
        super(name, numberOfReels);
    }

    public int getRollPrice() {
        return rollPrice;
    }

    protected int calculatePayout() {
        return rollPrice * numberOfReels;
    }

    protected String renderWinningConditions() {
        return "You won: " + calculatePayout() + " at the Five Reeler machine!";
    }

    public String getName() {
        return name;
    }
}
