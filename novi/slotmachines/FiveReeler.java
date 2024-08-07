package novi.slotmachines;

public class FiveReeler extends SlotMachine {
    private final String name = "Five Reeler";
    private final int numberOfReels = 5;
    private final int rollPrice = 85;

    public FiveReeler(String name, int numberOfReels) {
        super(name, numberOfReels);
    }

    @Override
    public int getRollPrice() {
        return rollPrice;
    }

    @Override
    protected int calculatePayout() {
        if (this.reelDeck.allReelsHaveSymbol(Symbol.STAR)) {
            return 50;
        } else if (this.reelDeck.allReelsHaveSymbol(Symbol.YINYANG)) {
            return 100;
        } else if (this.reelDeck.allReelsHaveSymbol(Symbol.SPADE)) {
            return 150;
        } else if (this.reelDeck.allReelsHaveSymbol(Symbol.HEART)) {
            return 200;
        } else if (this.reelDeck.allReelsHaveSymbol(Symbol.CLUB)) {
            return 250;
        }
        return 0 * numberOfReels;
    }

    @Override
    protected String renderWinningConditions() {
        return "3x star | 50 tokens\n" + "3x yinyang | 100 tokens\n" + "3x spade | 150 tokens\n"
                + "3x heart | 200 tokens\n" + "3x club | 250 tokens\n";
    }

    public String getName() {
        return name;
    }
}
