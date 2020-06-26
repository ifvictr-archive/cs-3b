import java.util.Scanner;

/**
 * Methods to calculate a number’s 1089 puzzle sum.
 */
public class Puzzle {
    /**
     * Prompts the user for a number.
     *
     * @return the number given by the user
     */
    public int promptUserForNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please input a number: ");
        int num = scanner.nextInt();

        scanner.close();

        return num;
    }

    /**
     * Reverses the given string.
     *
     * @param str the string to reverse
     * @return the reversed string
     */
    public String reverse(String str) {
        String reversedStr = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversedStr += str.charAt(i);
        }

        return reversedStr;
    }

    /**
     * Removes the signs from a string.
     *
     * @param str the string to remove signs from
     * @return a string without any signs
     */
    public String removeSign(String str) {
        return str.replace("-", "");
    }

    /**
     * Calculates the 1089 puzzle sum and returns
     *
     * @param num the number to do calculate the sum for
     * @return the 1089 sum
     */
    public int getResult(int num) {
        // Only keep the last three digits
        String numStr = String.valueOf(num);
        numStr = numStr.substring(numStr.length() - 3);

        String reversedNumStr = this.removeSign(this.reverse(numStr));
        int reversedNum = Integer.parseInt(reversedNumStr);

        int diff = Math.abs(num - reversedNum);
        String diffStr = String.valueOf(diff);
        diffStr = String.format("%03d", diff); // We need to pad it so it’s always three digits

        String reversedDiffStr = this.removeSign(this.reverse(diffStr));
        int reversedDiff = Integer.parseInt(reversedDiffStr);

        // Print results for debugging
        System.out.println("reversedNum: " + reversedNum);
        System.out.println("diff: " + diff);
        System.out.println("reversedDiff: " + reversedDiff);

        return diff + reversedDiff;
    }
}
