+import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 5;   // maximum attempts allowed
        int score = 0;         // score based on rounds won
        char playAgain;

        System.out.println("Welcome to Number Guessing Game!");
        
        do {
    
            int numberToGuess = random.nextInt(100) + 1; // 1 to 100
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Congratulations! You guessed the correct number.");
                    System.out.println("Attempts used: " + attempts);
                    guessedCorrectly = true;
                    score++;
                    break;
                } 
                else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } 
                else {
                    System.out.println("Too low!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You have used all attempts.");
                System.out.println("The correct number was: " + numberToGuess);
            }

            System.out.print("\nDo you want to play again? (y/n): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("\nGame Over!");
        System.out.println("Your total score (rounds won): " + score);

        sc.close();
    }
}
