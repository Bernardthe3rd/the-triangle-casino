package novi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Casino {
    private Scanner inputscanner;
    private List<String> listOfGames = new ArrayList<>();

    public Casino(Scanner inputscanner) {
        this.inputscanner = inputscanner;
    }

    public void start() {
        System.out.println("Welcome to the Casino!");
        System.out.println("You get a 1000 coins to start playing");
        System.out.println("Please enter a p to play a game or q to quit");
        char input = inputscanner.next().charAt(0);
        if (input == 'p') {
            System.out.println("Welk spel wil je spelen?");
        } else if (input == 'q') {
            System.exit(0);
        }

    }
}
