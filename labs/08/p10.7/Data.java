public class Data {
    /**
     * Calculates the average of the measures of an array of objects that match a filter.
     *
     * @param objects  objects to calculate the average for
     * @param measurer the object measurer
     * @param filter   filter for the object
     * @return the average measure value of the filtered objects
     */
    public static double average(Object[] objects, Measurer measurer, Filter filter) {
        double sum = 0;
        int acceptedCount = 0;
        for (Object obj : objects) {
            // Only include accepted objects
            if (filter.accept(obj)) {
                sum += measurer.measure(obj);
                acceptedCount++;
            }
        }

        // Prevent divide by zero errors
        if (acceptedCount == 0) {
            return 0;
        }

        return sum / acceptedCount;
    }
}
