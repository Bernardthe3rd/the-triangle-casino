package novi;

import com.diogonunes.jcolor.AnsiFormat;
import com.diogonunes.jcolor.Attribute;
import novi.blackjack.BlackJackGame;
import novi.hangman.HangmanGame;
import novi.higherlower.HigherLowerGame;
import novi.slotmachines.SlotMachineGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Casino {
    private Scanner inputscanner;
    private List<Game> listOfGames;
    private Game currentGame;
    private int coins;

    private AnsiFormat wonFormat = new AnsiFormat(Attribute.GREEN_TEXT(), Attribute.BLACK_BACK(), Attribute.BOLD());
    private AnsiFormat loseFormat = new AnsiFormat(Attribute.RED_TEXT(), Attribute.YELLOW_BACK(), Attribute.BOLD());

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
        System.out.println(colorize("Welcome to the Casino!", Attribute.BRIGHT_CYAN_TEXT(), Attribute.BLACK_BACK(), Attribute.BOLD()));
        System.out.println(colorize("You get a 1000 coins to start playing", Attribute.YELLOW_TEXT()));
        gameLoop();
    }

    public void gameLoop() {
        boolean gameIsRunning = true;
        while (gameIsRunning) {
            System.out.println("Please enter a p to play a game or q to quit");
            char inputPlayer = inputscanner.next().charAt(0);
            if (inputPlayer == 'p') {
                timeOut();
                System.out.println("Welk spel wil je spelen?");
                int numberIncrement = 1;
                for (Game game : getPlayableGames()) {
                    System.out.println("[" + numberIncrement++ + "] " + game.getName());
                }
            } else if (inputPlayer == 'q') {
                System.out.println("Thank you for stopping by!");
//                System.exit(0);
                gameIsRunning = false;
            }

            if (gameIsRunning) {
                int input2 = inputscanner.nextInt();
                playAGame(input2);

                var coinResult = currentGame.getWinnings();
                processWinnings(coinResult);
            }
        }


        timeOut();

    }

    public void playAGame(int input) {
        switch (input) {
            case 1:
                listOfGames.get(0).playGame(coins);
                currentGame = listOfGames.get(0);
                break;
            case 2:
                listOfGames.get(1).playGame(coins);
                currentGame = listOfGames.get(1);
                break;
            case 3:
                listOfGames.get(2).playGame(coins);
                currentGame = listOfGames.get(2);
                break;
            case 4:
                listOfGames.get(3).playGame(coins);
                currentGame = listOfGames.get(3);
            default:
                System.out.println("Please enter a valid number from 1 to 4");
        }
    }

    public List<Game> getPlayableGames() {
        List<Game> playableGames = new ArrayList<>();
        for (Game game : listOfGames) {
            if (this.coins > game.getMinimalRequiredCoins()) {
                playableGames.add(game);
            }
        }
        return playableGames;
    }

    private void processWinnings(int winnigs) {
        this.coins = this.coins + winnigs;

        if (winnigs >= 0) {
            System.out.println(colorize("You won " + winnigs + " coins\n", wonFormat));
        } else {
            System.out.println(colorize("You lost " + winnigs + " coins\n", loseFormat));
        }
        System.out.printf("You have %d coins\n", coins);
    }

    private void timeOut() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
