package novi.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HangmanGame {
    private Scanner inputScanner;
    private boolean gameIsRunning;

    private String[] listOfWords = {"woord", "monitor", "automonteur", "banaan", "macbook"};
    private String randomWord;
    private String guessState;
    private List<String> guessedLetters = new ArrayList<>();
    private int countWrongGuesses;

    public HangmanGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    public void playGame() {
        gameIsRunning = true;

        System.out.println("Welcome to Hangman!");
        randomWord = listOfWords[getRandomWord()];
        System.out.println(randomWord);
        System.out.println(replaceRandomWordWithAsterisks(randomWord));


        while (gameIsRunning) {
            System.out.println("Vul een letter in");
            String guess = inputScanner.nextLine();

            if (!applyGuess(guess)) {
                guessedLetters.add(guess);
                if (applyGuess(guess)) {
                    System.out.println(revealGuessedLetters(randomWord, guessState, guess));
                } else {
                    countWrongGuesses++;
                    ImageFactory.getImage(countWrongGuesses);
                }
            } else {
                guessedLetters.add(guess);
                throw new DuplicateLetterException(guess);
            }

            if (!revealGuessedLetters(randomWord, guessState, guess).contains("*")) {
                System.out.println("You won! You guessed: " + randomWord);
            } else {
                continue;
            }

            if (countWrongGuesses == 8) {
                System.out.println("You lost!)");
            } else {
                continue;
            }

//            nieuwe game loop methode;
        }

//        System.out.println("Are you sure you want to exit? Press s to stop completely and p to continue with another game");
//        var finalInput = inputScanner.nextLine();
//        if (finalInput.equalsIgnoreCase("s")) {
//            gameIsRunning = false;
//        } else {
//            playGame();
//        }
    }

    public int getRandomWord() {
        int randomNumber = (int) (Math.random() * listOfWords.length);
        System.out.println(randomNumber);
        return randomNumber;
    }

    public String replaceRandomWordWithAsterisks(String word) {
        String replacedWord = "*".repeat(word.length());
        return replacedWord;
    }

    public boolean applyGuess(String letter) {
        boolean guessed = false;
        for (String guessedLetter : guessedLetters) {
            if (guessedLetter.equals(letter)) {
                guessed = true;
            } else {
                guessed = false;
            }
        }
        return guessed;
    }

    public String revealGuessedLetters(String word, String currentGuess, String guessedLetter) {
        StringBuilder revealed = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            String letter = String.valueOf(word.charAt(i));
            if (letter.equals(guessedLetter)) {
                revealed.append(letter);
            } else if (!currentGuess.equals("*")) {
                revealed.append(currentGuess.charAt(i));
            } else {
                revealed.append("*");
            }
        }
        return revealed.toString();
    }
}
