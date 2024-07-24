package novi.blackjack;

public class Dealer {
    private Hand hand;
    private boolean staying;
    private boolean bust;

    public Dealer() {
        hand = new Hand();
        staying = false;
        bust = false;
    }

    public void performMove(Deck deck) {
        if (getHandValue() < 17) {
            Card[] oneCardDealer = {deck.getNextCard()};
            addCardsToHand(oneCardDealer);
        } else {
            staying = true;
        }
        if (isBust()) {
            System.out.println("Player has won!");
        }
    }

    public boolean isStaying() {
        return staying;
    }

    public boolean isBust() {
        return getHandValue() > 21;
    }

    public void addCardsToHand(Card[] cards) {
        for (Card card : cards) {
            hand.addCard(card);
        }
    }

    public int getHandValue() {
        return hand.getTotalValue();
    }

    public String renderHand() {
        return hand.render();
    }

}
