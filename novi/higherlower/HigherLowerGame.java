package novi.higherlower;

import novi.Game;

import java.util.Random;
import java.util.Scanner;

public class HigherLowerGame implements Game {
    private Scanner inputScanner;
    private boolean gameIsRunning;
    int guessedNumber = 0;

    public HigherLowerGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }


    @Override
    public void playGame(int coins) {
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

    @Override
    public String getName() {
        return "Higher Lower Game";
    }

    @Override
    public int getMinimalRequiredCoins() {
        return 1;
    }

    @Override
    public int getWinnings() {
        return 10;
    }


}

// solution one :
//public class HigherLowerGame {
//    private Scanner inputScanner;
//
//    private boolean gameIsRunning;
//
//    private int numberToGuess;
//    private int numberOfTurns;
//
//    public HigherLowerGame(Scanner inputScanner) {
//        this.inputScanner = inputScanner;
//    }
//
//    public void playGame() {
//        gameIsRunning = true;
//        numberToGuess = new Random().nextInt(100);
//        numberOfTurns = 0;
//
//        while (gameIsRunning) {
//            System.out.println("Make a guess");
//
//            var val = inputScanner.nextInt();
//            performGuess(val);
//        }
//    }
//
//    private void performGuess(int guess) {
//        numberOfTurns++;
//
//        if (guess == numberToGuess) {
//            gameIsRunning = false;
//            System.out.printf("Correct! you guessed the number in %d turns\n", numberOfTurns);
//        } else if (guess > numberToGuess) {
//            System.out.println("That number is too high");
//        } else {
//            System.out.println("That number is too low");
//        }
//    }
//}