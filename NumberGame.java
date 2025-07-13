package javatasks.com;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int maxAttempts = 5;
        int score = 0;
        boolean playAgain;

        System.out.println("=== Welcome to the Number Guessing Game ===");

        do {
            int targetNumber = random.nextInt(max - min + 1) + min;
            int attemptsLeft = maxAttempts;
            boolean isGuessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between " + min + " and " + max + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess;

                // Validate input
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // discard invalid input
                    continue;
                }

                userGuess = scanner.nextInt();
                attemptsLeft--;

                if (userGuess == targetNumber) {
                    System.out.println("Correct! Congratulations!! You guessed the number.");
                    score++;
                    isGuessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!isGuessedCorrectly) {
                System.out.println("Out of attempts! The number was: " + targetNumber);
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("\nThanks for playing! Your total score: " + score);
        scanner.close();
    }

}
