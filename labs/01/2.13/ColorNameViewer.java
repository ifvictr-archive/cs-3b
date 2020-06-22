/*
 * Lab 1: P2.13 by Victor Truong
 *
 * This program prints the twelve standard colors in java.awt.Color (excluding white) in a frame in
 * their own color.
 */

import javax.swing.JFrame;

public class ColorNameViewer {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create color name component
        ColorNameComponent colorNameComponent = new ColorNameComponent();
        frame.add(colorNameComponent);

        frame.setVisible(true);
    }
}
