/**
 * Store a set of numbers to get the average and standard deviation of.
 */
public class DataSet {
    private double sum = 0;
    private double squaresSum = 0;
    private int count = 0;

    /**
     * Adds a number to the set.
     *
     * @param value the number to add
     */
    public void add(double value) {
        this.sum += value;
        this.squaresSum += Math.pow(value, 2);
        this.count++;
    }

    /**
     * Gets the average of the numbers added.
     *
     * @return the average
     */
    public double getAverage() {
        return this.sum / this.count;
    }

    /**
     * Gets the total amount of numbers added.
     *
     * @return the count
     */
    public int getCount() {
        return this.count;
    }

    /**
     * Gets the standard deviation of the sum.
     *
     * @return the standard deviation
     */
    public double getStandardDeviation() {
        double numerator = this.squaresSum - (1 / this.count) * Math.pow(this.sum, 2);
        double denominator = this.count - 1;

        return Math.sqrt(numerator / denominator);
    }
}
