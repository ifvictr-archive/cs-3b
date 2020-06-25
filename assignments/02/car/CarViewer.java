/*
 * Assignment 2: Modified Car Drawings by Victor Truong
 *
 * This program draws four cars of colors in a window: yellow, red, white, and pink. The last car is
 * centered in its own row under the first three.
 */

import javax.swing.JFrame;

/**
 * Tests our Car and CarComponent classes.
 */
public class CarViewer {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(300, 400);
        frame.setTitle("Four Cars");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CarComponent component = new CarComponent();
        frame.add(component);

        frame.setVisible(true);
    }
}
