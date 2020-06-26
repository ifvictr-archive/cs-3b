/*
 * Assignment 3: P4.3 by Victor Truong
 *
 * This program lets a user input a number, and it will calculate the 1089 puzzle sum of that
 * number.
 */

/**
 * Tests our Puzzle class.
 */
public class PuzzleTester {
    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle();
        int num = puzzle.promptUserForNumber();
        int result = puzzle.getResult(num);

        System.out.println("1089 puzzle result: " + result);
    }
}
