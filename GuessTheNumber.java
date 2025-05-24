import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1;
        int guess;

        System.out.println("Guess a number between 1 and 100:");

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Correct! You guessed the number.");
            }
        } while (guess != numberToGuess);

        scanner.close();
    }
}