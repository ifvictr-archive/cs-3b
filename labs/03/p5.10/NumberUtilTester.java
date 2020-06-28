/**
 * Tests our NumberUtil methods.
 */
public class NumberUtilTester {
    public static void main(String[] args) {
        test(0, "");
        test(4, "IV");
        test(30, "XXX");
        test(56, "LVI");
        test(99, "XCIX");
        test(420, "CDXX");
        test(777, "DCCLXXVII");
        test(1001, "MI");
        test(2020, "MMXX");
        test(3900, "MMMCM");
        test(3999, "MMMCMXCIX");
        test(4000, "");
    }

    public static void test(int input, String expectedResult) {
        String result = NumberUtil.toRoman(input);
        System.out.println(
                String.format("%d should be equal “%s”, got “%s”", input, expectedResult, result));
    }
}
