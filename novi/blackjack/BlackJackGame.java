package novi.blackjack;

import java.util.Scanner;

public class BlackJackGame {
    private Scanner inputScanner;
    private boolean gameIsRunning;
    private Deck deck;
    private Dealer dealer;
    private Player player;

    public BlackJackGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    public void playGame() {
        gameIsRunning = true;

        deck = new Deck();
        // Here you should generate the number to guess
        player = new Player();
        dealer = new Dealer();
        deck.shuffle();
        Card[] twoCards = {deck.getNextCard(), deck.getNextCard()};
        player.addCardsToHand(twoCards);
        Card[] oneCardDealer = {deck.getNextCard()};
        dealer.addCardsToHand(oneCardDealer);

        runningGame();

    }

    public void runningGame() {
        while (gameIsRunning) {
            System.out.println(player.renderHand());
            System.out.println("Hit or stay?");
            var input = inputScanner.nextLine();
            System.out.printf("You typed: %s\n", input);

            player.performMove(deck, input);
            dealer.performMove(deck);

            if (dealer.isStaying() && dealer.getHandValue() < player.getHandValue()) {
                System.out.println("You win!");
                System.out.println("dealer hands value: " + dealer.getHandValue());
                System.out.println("player hands value: " + player.getHandValue());
                gameIsRunning = false;
            }

            if (player.isStaying() && player.getHandValue() <= dealer.getHandValue()) {
                System.out.println("You lose!");
                System.out.println("dealer hands value: " + dealer.getHandValue());
                System.out.println("player hands value: " + player.getHandValue());
                gameIsRunning = false;
            }

            if (player.isBust() && !player.isStaying()) {
                System.out.println("You bust!");
                System.out.println("player hands value: " + player.getHandValue());
                gameIsRunning = false;
            }

            if (dealer.isBust() && !dealer.isStaying()) {
                System.out.println("You win!");
                System.out.println("dealer hands value: " + dealer.getHandValue());
                gameIsRunning = false;
            }

        }
    }

}
