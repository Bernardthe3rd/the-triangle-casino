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
        guessState = replaceRandomWordWithAsterisks(randomWord);


        while (gameIsRunning) {
            System.out.println("Vul een letter in");
            char guess = inputScanner.next().charAt(0);

            try {
                applyGuess(String.valueOf(guess));
            } catch (DuplicateLetterException e) {
                System.out.println(e.getMessage());
                continue;
            }

//            if (b) {
            if (applyRightGuess(guess).contains(true)) {
                System.out.println(revealGuessedLetters(randomWord, guessState, String.valueOf(guess)));
                guessState = revealGuessedLetters(randomWord, guessState, String.valueOf(guess));
            } else {
                countWrongGuesses++;
                ImageFactory.getImage(countWrongGuesses);
            }
            guessedLetters.add(String.valueOf(guess));
//            } else {
//                guessedLetters.add(guess);
//                throw new DuplicateLetterException(guess);
//            }

            if (!revealGuessedLetters(randomWord, guessState, String.valueOf(guess)).contains("*")) {
                System.out.println("You won! You guessed: " + randomWord);
                gameIsRunning = false;
            } else {
                continue;
            }

            if (countWrongGuesses == 8) {
                System.out.println("You lost!)");
                gameIsRunning = false;
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
        boolean guessed = true;
        for (String guessedLetter : guessedLetters) {
            if (guessedLetter.equals(letter)) {
                throw new DuplicateLetterException(letter);
            } else {
                guessed = true;
            }
        }
        return guessed;
    }

    public List<Boolean> applyRightGuess(char letter) {
        List<Boolean> goodOrBadList = new ArrayList<>();
        char[] randomWordLetters = new char[randomWord.length()];
        for (int i = 0; i < randomWord.length(); i++) {
            randomWordLetters[i] = randomWord.charAt(i);
        }

        for (char guessedLetter : randomWordLetters) {
            if (guessedLetter == letter) {
                goodOrBadList.add(true);
            } else {
                goodOrBadList.add(false);
            }
        }
        return goodOrBadList;
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
