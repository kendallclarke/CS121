import java.util.Random;
import java.util.Scanner;

public class game {
    enum Options {
        ROCK,
        PAPER,
        SCISSORS
    }
// user input and generate a random choice by other player
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.print("Enter your choice (rock, paper, or scissors): ");
            String playerInput = scanner.nextLine().toUpperCase();

            if (playerInput.equals("EXIT")) {
                break;
            }

            try {
                Options playerChoice = Options.valueOf(playerInput);
                Options computerChoice = Options.values()[random.nextInt(Options.values().length)];

                System.out.println("Your choice: " + playerChoice);
                System.out.println("Computer's choice: " + computerChoice);

                determineWinner(playerChoice, computerChoice);
                // if the user does not put in the correct type of input
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
// tie, win, or loss
    private static void determineWinner(Options playerChoice, Options computerChoice) {
        if (playerChoice == computerChoice) {
            System.out.println("It's a tie!");
        } else if (
                (playerChoice == Options.ROCK && computerChoice == Options.SCISSORS) ||
                        (playerChoice == Options.PAPER && computerChoice == Options.ROCK) ||
                        (playerChoice == Options.SCISSORS && computerChoice == Options.PAPER)
        ) {
            System.out.println("You won!");
        } else {
            System.out.println("You lost!");
        }
        System.out.println();
    }
}