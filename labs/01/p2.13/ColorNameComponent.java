import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class ColorNameComponent extends JComponent {
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        final int SPACING = 20;

        // Draw color strings
        g2.setColor(Color.BLACK);
        g2.drawString("black", 0, 0);
        g2.setColor(Color.BLUE);
        g2.drawString("blue", 0, SPACING);
        g2.setColor(Color.CYAN);
        g2.drawString("cyan", 0, SPACING * 2);
        g2.setColor(Color.GRAY);
        g2.drawString("gray", 0, SPACING * 3);
        g2.setColor(Color.DARK_GRAY);
        g2.drawString("dark gray", 0, SPACING * 4);
        g2.setColor(Color.LIGHT_GRAY);
        g2.drawString("light gray", 0, SPACING * 5);
        g2.setColor(Color.GREEN);
        g2.drawString("green", 0, SPACING * 6);
        g2.setColor(Color.MAGENTA);
        g2.drawString("magenta", 0, SPACING * 7);
        g2.setColor(Color.ORANGE);
        g2.drawString("orange", 0, SPACING * 8);
        g2.setColor(Color.PINK);
        g2.drawString("pink", 0, SPACING * 9);
        g2.setColor(Color.RED);
        g2.drawString("red", 0, SPACING * 10);
        g2.setColor(Color.YELLOW);
        g2.drawString("yellow", 0, SPACING * 11);
    }
}
