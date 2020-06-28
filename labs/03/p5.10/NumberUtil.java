/**
 * Small functions for working with numbers.
 */
public class NumberUtil {
    public static class Roman {
        public static int I = 1;
        public static int IV = 4;
        public static int V = 5;
        public static int IX = 9;

        public static int X = 10;
        public static int XL = 40;
        public static int L = 50;
        public static int XC = 90;

        public static int C = 100;
        public static int CD = 400;
        public static int D = 500;
        public static int CM = 900;

        public static int M = 1000;
    }

    /**
     * Converts a given number to Roman numerals.
     *
     * @param num the number to convert
     * @return the number in Roman numerals
     */
    public static String toRoman(int num) {
        String result = "";

        // Needs to be within 1–3999, inclusively
        if (num < 1 || num > 3999) {
            return result;
        }

        // 1000
        int mCount = (int) Math.floor(num / Roman.M);
        num %= Roman.M;
        result += "M".repeat(mCount);

        // 900
        int cmCount = (int) Math.floor(num / Roman.CM);
        num %= Roman.CM;
        result += "CM".repeat(cmCount);

        // 500
        int dCount = (int) Math.floor(num / Roman.D);
        num %= Roman.D;
        result += "D".repeat(dCount);

        // 400
        int cdCount = (int) Math.floor(num / Roman.CD);
        num %= Roman.CD;
        result += "CD".repeat(cdCount);

        // 100
        int cCount = (int) Math.floor(num / Roman.C);
        num %= Roman.C;
        result += "C".repeat(cCount);

        // 90
        int xcCount = (int) Math.floor(num / Roman.XC);
        num %= Roman.XC;
        result += "XC".repeat(xcCount);

        // 50
        int lCount = (int) Math.floor(num / Roman.L);
        num %= Roman.L;
        result += "L".repeat(lCount);

        // 40
        int xlCount = (int) Math.floor(num / Roman.XL);
        num %= Roman.XL;
        result += "XL".repeat(xlCount);

        // 10
        int xCount = (int) Math.floor(num / Roman.X);
        num %= Roman.X;
        result += "X".repeat(xCount);

        // 9
        int ixCount = (int) Math.floor(num / Roman.IX);
        num %= Roman.IX;
        result += "IX".repeat(ixCount);

        // 5
        int vCount = (int) Math.floor(num / Roman.V);
        num %= Roman.V;
        result += "V".repeat(vCount);

        // 4
        int ivCount = (int) Math.floor(num / Roman.IV);
        num %= Roman.IV;
        result += "IV".repeat(ivCount);

        // 1
        int iCount = num;
        result += "I".repeat(iCount);

        return result;
    }
}
