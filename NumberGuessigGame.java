import java.util.Scanner;
import java.util.Random;

public class NumberGuessigGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            // Step 1: Generate a random number
            int lowerBound = 1;
            int upperBound = 100;
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

            // Game settings
            int maxAttempts = 5;
            int attempts = 0;
            boolean isCorrect = false;

            System.out.println("\nI'm thinking of a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it!");

            // Step 2: Start the guessing loop
            while (attempts < maxAttempts && !isCorrect) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                // Step 3: Compare guess
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalScore += (maxAttempts - attempts + 1); // Score based on remaining attempts
                    isCorrect = true;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!isCorrect) {
                System.out.println("Sorry, you've used all your attempts! The number was " + randomNumber + ".");
            }

            // Step 7: Display score
            System.out.println("Your current score: " + totalScore);

            // Step 6: Play again
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score: " + totalScore);
        scanner.close();
    }
}
