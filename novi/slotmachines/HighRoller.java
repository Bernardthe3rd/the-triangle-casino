package novi.slotmachines;

public class HighRoller extends SlotMachine {
    private final String name = "High roller";
    private final int numberOfReels = 3;
    private final int rollPrice = 10;

    public HighRoller(String name, int numberOfReels) {
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
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.YINYANG)) {
            return 100;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.SPADE)) {
            return 150;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.HEART)) {
            return 200;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.CLUB)) {
            return 250;
        }

        return 0;
    }

    @Override
    protected String renderWinningConditions() {
        return "3x star    | 50 tokens\n" + "3x yinyang | 100 tokens\n" + "3x spade   | 150 tokens\n"
                + "3x heart   | 200 tokens\n" + "3x club    | 250 tokens\n";
    }

    public String getName() {
        return name;
    }
}
