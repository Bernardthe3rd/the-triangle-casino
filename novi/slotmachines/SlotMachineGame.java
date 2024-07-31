package novi.slotmachines;

import java.util.Scanner;

public class SlotMachineGame {
    private Scanner inputScanner;
    private boolean gameIsRunning;
    private int playerCoins;
    private SlotMachine slotMachine;

    public SlotMachineGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
        playerCoins = 100;
    }

    public void playGame() {
        gameIsRunning = true;

        while (gameIsRunning) {
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
                    case 4:
                        return;
                    default:
                        System.out.println("Choose a right number");
                }
            } catch (NumberFormatException e) {
                System.out.println("You entered an invalid number!");
            }

            if (playerCoins > slotMachine.getRollPrice()) {
                slotMachine.renderIntro();
                slotMachine.roll();
                slotMachine.renderWinningConditions();
            } else {
                continue;
            }

            System.out.println("Ga verder met de while loop");


            // Check if the guess is correct, if so end the game
        }
    }
}
