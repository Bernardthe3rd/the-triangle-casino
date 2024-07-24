package novi.slotmachines;

public abstract class SlotMachine {
    private String name;
    private int numberOfReels;

    public SlotMachine(String name, int numberOfReels) {
        this.name = name;
        this.numberOfReels = numberOfReels;
    }

    public void renderIntro() {

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
