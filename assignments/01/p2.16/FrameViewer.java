/*
 * Assignment 1: P2.16 by Victor Truong
 *
 * This program takes your name and an image, and then prints them out in a window with a greeting.
 */

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameViewer {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame();
        frame.setSize(400, 400);

        // Create image icon and label
        ImageIcon icon = new ImageIcon("image.jpeg");
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setOpaque(true);
        imageLabel.setBounds(0, 0, 100, 100);
        frame.add(imageLabel);

        // Create greeting label
        JLabel greetingLabel = new JLabel("Hello, Victor!");
        greetingLabel.setOpaque(true);
        greetingLabel.setBackground(new Color(201, 253, 201));
        frame.add(greetingLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
