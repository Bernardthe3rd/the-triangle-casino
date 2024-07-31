package novi.slotmachines;

import java.util.ArrayList;

public abstract class SlotMachine {
    private final String name;
    private final int numberOfReels;
    protected ReelDeck reelDeck;

    public SlotMachine(String name, int numberOfReels) {
        this.name = name;
        this.numberOfReels = numberOfReels;
        ArrayList<Reel> reelList = new ArrayList<>();
        for (int i = 0; i < numberOfReels; i++) {
            reelList.add(new Reel());
        }
        reelDeck = new ReelDeck(reelList);
    }

    public void renderIntro() {
        System.out.println("Welcome to the fruitmachine game!");

    }

    public int roll() {
        reelDeck.roll();
        return calculatePayout();
    }

    public String render() {
        return reelDeck.render();
    }

    public abstract int getRollPrice();

    protected abstract int calculatePayout();

    protected abstract String renderWinningConditions();
}
