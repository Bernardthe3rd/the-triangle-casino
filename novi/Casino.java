package novi;

import novi.blackjack.BlackJackGame;
import novi.hangman.HangmanGame;
import novi.higherlower.HigherLowerGame;
import novi.slotmachines.SlotMachineGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Casino {
    private Scanner inputscanner;
    private List<Game> listOfGames;
    private int coins;

    public Casino(Scanner inputscanner) {
        this.inputscanner = inputscanner;
        this.listOfGames = new ArrayList<>();
        this.listOfGames.add(new HigherLowerGame(inputscanner));
        this.listOfGames.add(new BlackJackGame(inputscanner));
        this.listOfGames.add(new SlotMachineGame(inputscanner));
        this.listOfGames.add(new HangmanGame(inputscanner));

        this.coins = 1000;
    }

    public void start() {
        System.out.println("Welcome to the Casino!");
        System.out.println("You get a 1000 coins to start playing");
        System.out.println("Please enter a p to play a game or q to quit");
        char input = inputscanner.next().charAt(0);
        if (input == 'p') {
            System.out.println("Welk spel wil je spelen?");
            System.out.println();
        } else if (input == 'q') {
            System.out.println("Thank you for stopping by!");
            System.exit(0);
        }
    }

    public void playAGame() {

    }

    public List<Game> getPlayableGames() {
        List<Game> playableGames = new ArrayList<>();
        //someting
        return playableGames;
    }

    private void processWinnings(int winnigs) {

    }
}
