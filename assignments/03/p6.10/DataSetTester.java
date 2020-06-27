/**
 * Tests our DataSet class.
 */
public class DataSetTester {
    public static void main(String[] args) {
        DataSet data = new DataSet();

        data.add(1);
        System.out.println("Added 1");
        DataSetTester.printValues(data);

        data.add(2);
        System.out.println("Added 2");
        DataSetTester.printValues(data);

        data.add(3);
        System.out.println("Added 3");
        DataSetTester.printValues(data);

        data.add(4);
        System.out.println("Added 4");
        DataSetTester.printValues(data);

        data.add(5);
        System.out.println("Added 5");
        DataSetTester.printValues(data);
    }

    public static void printValues(DataSet data) {
        System.out.println(String.format("  Numbers entered: %d", data.getCount()));
        System.out.println(String.format("  Average: %.2f", data.getAverage()));
        System.out
                .println(String.format("  Standard deviation: %.2f", data.getStandardDeviation()));
    }
}
