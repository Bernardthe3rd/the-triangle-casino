package novi.hangman;

import java.util.Scanner;

public class HangmanGame {
    private Scanner inputScanner;
    private boolean gameIsRunning;

    public HangmanGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    public void playGame() {
        gameIsRunning = true;

        while (gameIsRunning) {
//            nieuwe game loop methode;
        }

        System.out.println("Are you sure you want to exit? Press s to stop completely and p to continue with another game");
        var finalInput = inputScanner.nextLine();
        if (finalInput.equalsIgnoreCase("s")) {
            gameIsRunning = false;
        } else {
            playGame();
        }
    }
}
