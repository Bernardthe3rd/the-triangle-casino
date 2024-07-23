package novi.higherlower;

import java.util.Scanner;

public class HigherLowerGame {
    private Scanner inputScanner;
    private boolean gameIsRunning;
    int guessedNumber = 0;

    public HigherLowerGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    public void playGame() {
        gameIsRunning = true;

        // Here you should generate the number to guess
        long numberToGuess = Math.round(Math.random() * 100);
//        System.out.println(numberToGuess);

        while (gameIsRunning) {
            System.out.println("Make a guess");

            var input = inputScanner.nextLong();
            System.out.printf("You typed: %s\n", input);
            guessedNumber++;

            if (input > numberToGuess) {
                System.out.println("That number is to high!");
            } else if (input < numberToGuess) {
                System.out.println("That number is to low!");
            }

            // Check if the guess is correct, if so end the game
            if (input == numberToGuess) {
                gameIsRunning = false;
            }
        }

        System.out.println("Correct! You guessed the number in " + guessedNumber + " turns");
    }
}
