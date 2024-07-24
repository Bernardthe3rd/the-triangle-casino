package novi.slotmachines;

public abstract class SlotMachine {
    private final String name;
    private final int numberOfReels;

    public SlotMachine(String name, int numberOfReels) {
        this.name = name;
        this.numberOfReels = numberOfReels;
    }

    public void renderIntro() {
        System.out.println("Welcome to the fruitmachine game!");
        System.out.println("Which game do you want to play?");
    }

    public int roll() {
        return 0;
    }

    public String render() {
        return "hello";
    }

    public abstract int getRollPrice();

    protected abstract int calculatePayout();

    protected abstract String renderWinningConditions();
}
