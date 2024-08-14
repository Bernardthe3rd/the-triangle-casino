package novi.slotmachines;

import novi.Game;

import java.util.Scanner;

public class SlotMachineGame implements Game {
    private Scanner inputScanner;
    private boolean gameIsRunning;
    private int startCoins;
    private int currentCoins;
    private SlotMachine slotMachine;

    public SlotMachineGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
        startCoins = 100;
        currentCoins = startCoins;
    }

    @Override
    public void playGame(int coins) {
        gameIsRunning = true;

        slotMachine = pickMachine(currentCoins);
        slotMachine.renderIntro();
        while (gameIsRunning) {
            gameLoop();
        }

        System.out.println("Are you sure you want to exit? Press s to stop completely and p to continue with another game");
        var finalInput = inputScanner.nextLine();
        if (finalInput.equalsIgnoreCase("s")) {
            gameIsRunning = false;
        } else {
            playGame(coins);
        }
    }

    private void gameLoop() {
        if (currentCoins < slotMachine.getRollPrice()) {
            System.out.println("You don't have enough coins to roll");
            gameIsRunning = false;
            return;
        }

        String move = nextMove();
        if (move.equals("s")) {
            System.out.println("Thank you for playing! You have " + currentCoins + " coins left");
            gameIsRunning = false;
        } else {
            this.currentCoins = currentCoins - slotMachine.getRollPrice();
            int winCoins = slotMachine.roll();
            this.currentCoins = currentCoins + winCoins;
            System.out.println(slotMachine.render());
            System.out.println("You won " + winCoins + " coins");
            System.out.println("Now you have " + currentCoins + " coins left");
        }

    }

    private String nextMove() {
        while (true) {
            System.out.println("Enter r to roll or s to stop");

            if (inputScanner.hasNext()) {
                String move = inputScanner.nextLine();
                if (move.equalsIgnoreCase("r") || move.equalsIgnoreCase("s")) {
                    return move;
                }
            }
        }
    }

    private SlotMachine pickMachine(int coins) {
        while (true) {
            System.out.println("Which game do you want to play?");
            System.out.println("kies 1 voor Penny - kies 2 voor FiveReeler - kies 3 voor Highroller - kies 4 voor close game");
            try {
                var input = Integer.parseInt(inputScanner.nextLine());
                System.out.printf("You typed: %s\n", input);
                switch (input) {
                    case 1:
                        slotMachine = new Penny("Penny", 3);
                        break;
                    case 2:
                        slotMachine = new FiveReeler("FiveReeler", 5);
                        break;
                    case 3:
                        slotMachine = new HighRoller("Highroller", 3);
                        break;
                    default:
                        System.out.println("Choose a machine");
                }
            } catch (NumberFormatException e) {
                System.out.println("You entered an invalid number!");
            }
            if (slotMachine.getRollPrice() >= coins) {
                System.out.println("You don't have enough coins to roll");
            } else {
                return slotMachine;
            }
        }
    }

    @Override
    public String getName() {
        return "Slotmachine Game";
    }

    @Override
    public int getMinimalRequiredCoins() {
        return 100;
    }

    @Override
    public int getWinnings() {
        return currentCoins - startCoins - getMinimalRequiredCoins();
    }
}
