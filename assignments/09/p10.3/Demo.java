/*
 * Assignment 9: P10.3 by Victor Truong
 *
 * This program prints the first 20 prime numbers using the PrimeSequence class.
 */

/**
 * Demos the PrimeSequence class.
 */
public class Demo {
    public static void main(String[] args) {
        final int PRIME_COUNT = 20;

        Sequence prime = new PrimeSequence();
        for (int i = 1; i <= PRIME_COUNT; i++) {
            System.out.println(String.format("%d. %d", i, prime.next()));
        }
    }
}
