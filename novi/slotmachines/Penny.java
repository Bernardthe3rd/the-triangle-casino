package novi.slotmachines;

public class Penny extends SlotMachine {
    private final String name = "Penny";
    private final int numberOfReels = 3;
    private final int rollPrice = 1;

    public Penny(String name, int numberOfReels) {
        super(name, numberOfReels);
    }

    @Override
    public int getRollPrice() {
        return rollPrice;
    }

    @Override
    protected int calculatePayout() {
        if (this.reelDeck.allReelsHaveSymbol(Symbol.STAR)) {
            return 5;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.YINYANG)) {
            return 5;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.SPADE)) {
            return 5;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.HEART)) {
            return 5;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.CLUB)) {
            return 5;
        }

        return 0;
    }

    @Override
    protected String renderWinningConditions() {
        return "3x star    | 5 tokens\n" + "3x yinyang | 10 tokens\n" + "3x spade   | 15 tokens\n"
                + "3x heart   | 20 tokens\n" + "3x club    | 25 tokens\n";
    }

    public String getName() {
        return name;
    }
}
