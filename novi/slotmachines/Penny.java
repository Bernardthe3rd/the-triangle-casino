package novi.slotmachines;

public class Penny extends SlotMachine {
    private final String name = "Penny";
    private final int numberOfReels = 3;
    private final int rollPrice = 1;

    public Penny(String name, int numberOfReels) {
        super(name, numberOfReels);
    }

    public int getRollPrice() {
        return rollPrice;
    }

    protected int calculatePayout() {
        return rollPrice * numberOfReels;
    }

    protected String renderWinningConditions() {
        return "You won: " + calculatePayout() + " at the penny machine!";
    }

    public String getName() {
        return name;
    }
}
