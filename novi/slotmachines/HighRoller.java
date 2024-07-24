package novi.slotmachines;

public class HighRoller extends SlotMachine {
    private final String name = "High roller";
    private final int numberOfReels = 3;
    private final int rollPrice = 10;

    public HighRoller(String name, int numberOfReels) {
        super(name, numberOfReels);
    }

    public int getRollPrice() {
        return rollPrice;
    }

    protected int calculatePayout() {
        return rollPrice * numberOfReels;
    }

    protected String renderWinningConditions() {
        return "You won: " + calculatePayout() + " at the High roller machine!";
    }

    public String getName() {
        return name;
    }
}
