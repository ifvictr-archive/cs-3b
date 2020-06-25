import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * A car shape that can be positioned anywhere on the screen.
 */
public class Car {
    private int xLeft;
    private int yTop;
    private Color bodyColor;
    private int size;

    /**
     * Constructs a car with a given top left corner, color, and size.
     *
     * @param x     the x-coordinate of the top-left corner
     * @param y     the y-coordinate of the top-left corner
     * @param color the color of the body
     * @param size  the size of the car
     */
    public Car(int x, int y, Color color, int size) {
        this.xLeft = x;
        this.yTop = y;
        this.bodyColor = color;
        this.size = size;
    }

    public Car(int x, int y, Color color) {
        this(x, y, color, 1);
    }

    public Car(int x, int y) {
        this(x, y, Color.WHITE);
    }

    /**
     * Draws the car.
     *
     * @param g2 the graphics context
     */
    public void draw(Graphics2D g2) {
        Rectangle body = new Rectangle(this.xLeft, this.yTop + 10 * this.size, 60 * this.size,
                10 * this.size);
        Ellipse2D.Double frontTire = new Ellipse2D.Double(this.xLeft + 10 * this.size,
                this.yTop + 20 * this.size, 10 * this.size, 10 * this.size);
        Ellipse2D.Double rearTire = new Ellipse2D.Double(this.xLeft + 40 * this.size,
                this.yTop + 20 * this.size, 10 * this.size, 10 * this.size);

        // The bottom of the front windshield
        Point2D.Double r1 =
                new Point2D.Double(this.xLeft + 10 * this.size, this.yTop + 10 * this.size);
        // The front of the roof
        Point2D.Double r2 = new Point2D.Double(this.xLeft + 20 * this.size, this.yTop);
        // The rear of the roof
        Point2D.Double r3 = new Point2D.Double(this.xLeft + 40 * this.size, this.yTop);
        // The bottom of the rear windshield
        Point2D.Double r4 =
                new Point2D.Double(this.xLeft + 50 * this.size, this.yTop + 10 * this.size);

        Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
        Line2D.Double roofTop = new Line2D.Double(r2, r3);
        Line2D.Double rearWindshield = new Line2D.Double(r3, r4);

        // Draw body
        g2.setColor(this.bodyColor);
        g2.fill(body);

        // Draw tires
        g2.setColor(Color.BLACK);
        g2.fill(frontTire);
        g2.fill(rearTire);

        // Draw windshield
        g2.setColor(Color.BLACK);
        g2.draw(frontWindshield);
        g2.draw(roofTop);
        g2.draw(rearWindshield);
    }
}
