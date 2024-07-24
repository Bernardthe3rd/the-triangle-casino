package novi.blackjack;

public class Player {
    private Hand hand;
    private boolean staying;

    public Player() {
        hand = new Hand();
        staying = false;
    }

    public void performMove(Deck deck, String move) {
        if (move.equalsIgnoreCase("hit")) {
            Card[] oneCardPlayer = {deck.getNextCard()};
            addCardsToHand(oneCardPlayer);
//            if (isBust()) {
//                System.out.println("You have lost!");
//
//            }
        } else {
            staying = true;
        }
    }

    public void addCardsToHand(Card[] cards) {
        for (Card card : cards) {
            hand.addCard(card);
        }
    }

    public boolean isStaying() {
        return staying;
    }

    public boolean isBust() {
        if (getHandValue() > 21) {
            return true;
        }
        return false;
    }

    public int getHandValue() {
        return hand.getTotalValue();
    }

    public String renderHand() {
        return hand.render();
    }

}
