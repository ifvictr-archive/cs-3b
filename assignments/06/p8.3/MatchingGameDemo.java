/*
 * Assignment 6: P8.3 by Victor Truong
 *
 * This program is a matching game—it takes in tile selections from the player and outputs them as
 * they get it correct/wrong. The game ends when all the tiles have been matched. Then the player
 * will be asked if they want to play again.
 */

import java.util.Scanner;

/**
 * Entry point to the matching game.
 */
public class MatchingGameDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            // Start game
            MatchingGame game = new MatchingGame();
            game.start();

            // Ask if they want to play again after it ends
            System.out.print("Want to play again? (y/n) ");
            input = scanner.nextLine();
        } while (input.equalsIgnoreCase("Y"));

        System.out.println("See ya!");
    }
}
