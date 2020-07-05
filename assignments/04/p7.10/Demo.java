import java.util.Scanner;
/*
 * Assignment 4: P7.10 by Victor Truong
 *
 * This program is a basic CLI implementation of the game Video Poker, where five random cards are
 * drawn for the player and they receive a certain payout depending on the rank of their hand of
 * cards. Each bet costs one token.
 */

/**
 * Demos the Video Poker game.
 */
public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        // Print intro
        System.out.println("*".repeat(30));
        System.out.println("Welcome to Video Poker!");
        System.out.println("*".repeat(30));

        // Start game loop
        boolean wantsToPlayAgain = true;
        do {
            game.start(scanner);

            // Ask if the player wants to play again
            System.out.print("Want to play again? (Y/n) ");
            wantsToPlayAgain = !scanner.nextLine().equalsIgnoreCase("N");
        } while (wantsToPlayAgain);

        // Close everything
        scanner.close();
        System.out.println("Bye!");
    }
}
