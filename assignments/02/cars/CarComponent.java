import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * This component draws the four cars.
 */
public class CarComponent extends JComponent {
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        final int SPACING = 75;

        Car car1 = new Car(0, 0, Color.YELLOW);
        Car car2 = new Car(SPACING, 0, Color.RED);
        Car car3 = new Car(SPACING * 2, 0, Color.WHITE);
        Car car4 = new Car(45, 50, Color.PINK, 2);

        car1.draw(g2);
        car2.draw(g2);
        car3.draw(g2);
        car4.draw(g2);
    }
}
