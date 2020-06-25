/*
 * Assignment 1: P2.7 by Victor Truong
 *
 * This program outputs a combination of six random numbers for a lottery.
 */

import java.util.Random;

public class LotteryPrinter {
    public static void main(String[] args) {
        System.out.println("Play this combination—it’ll make you rich!");

        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int num = random.nextInt(49) + 1; // Choose random number between 1–49 inclusivelys
            System.out.print(num + " ");
        }

        System.out.println("");
    }
}
