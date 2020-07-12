public class ZipCodeUtil {
    /**
     * Calculates the check digit of a given zip code.
     *
     * @param zipCode
     * @return check digit
     */
    public static int calculateCheckDigit(int zipCode) {
        final int BASE = 10;
        int sum = 0;

        String zipCodeStr = String.format("%05d", zipCode); // Pad so it's always five digits long.
        // Get the individual digits, starting from the leftmost one and sum them up.
        for (int i = 0; i < zipCodeStr.length(); i++) {
            String digitStr = String.valueOf(zipCodeStr.charAt(i));
            sum += Integer.valueOf(digitStr);
        }

        // Get the remainder of the sum when divided by 10, then subtract it from 10 to get the
        // check digit.
        int checkDigit = BASE - (sum % BASE);
        return checkDigit;
    }

    /**
     * Gets the bar code segment of a given digit.
     *
     * @param digit
     * @return encoded version of digit
     */
    public static String encodeDigit(int digit) {
        switch (digit) {
            case 1:
                return ":::||"; // 00011
            case 2:
                return "::|:|"; // 00101
            case 3:
                return "::||:"; // 00110
            case 4:
                return ":|::|"; // 01001
            case 5:
                return ":|:|:"; // 01010
            case 6:
                return ":||::"; // 01100
            case 7:
                return "|:::|"; // 10001
            case 8:
                return "|::|:"; // 10010
            case 9:
                return "|:|::"; // 10100
            case 0:
                return "||:::"; // 11000
            default:
                return "???";
        }
    }

    /**
     * Converts a zip code to its bar code equivalent.
     *
     * @param zipCode
     * @return zip code in bar code form
     */
    public static String encodeZipCode(int zipCode) {
        String zipCodeStr = String.format("%05d", zipCode); // Pad so it's always five digits long.

        // Append the encoded version of the digits to the bar code
        String barCode = "";
        for (int i = 0; i < zipCodeStr.length(); i++) {
            String digitStr = Character.toString(zipCodeStr.charAt(i));
            int digit = Integer.valueOf(digitStr);

            barCode += ZipCodeUtil.encodeDigit(digit);
        }

        // Add the check digit segment
        int checkDigit = ZipCodeUtil.calculateCheckDigit(zipCode);
        barCode += ZipCodeUtil.encodeDigit(checkDigit);

        // Add the frame bars
        barCode = "|" + barCode + "|";

        return barCode;
    }

    /**
     * Decodes a single encoded representation of a digit.
     *
     * @param segment to decode
     * @return digit between 0–9 if it's valid. Otherwise, -1 is returned.
     */
    public static int decodeSegment(String segment) {
        switch (segment) {
            case ":::||":
                return 1;
            case "::|:|":
                return 2;
            case "::||:":
                return 3;
            case ":|::|":
                return 4;
            case ":|:|:":
                return 5;
            case ":||::":
                return 6;
            case "|:::|":
                return 7;
            case "|::|:":
                return 8;
            case "|:|::":
                return 9;
            case "||:::":
                return 0;
            default:
                return -1;
        }
    }

    /**
     * Decodes a valid bar code to zip code form.
     *
     * @param barCode
     * @return decoded zip code
     */
    public static int decodeBarCode(String barCode) {
        int digit1 = ZipCodeUtil.decodeSegment(barCode.substring(1, 6));
        int digit2 = ZipCodeUtil.decodeSegment(barCode.substring(6, 11));
        int digit3 = ZipCodeUtil.decodeSegment(barCode.substring(11, 16));
        int digit4 = ZipCodeUtil.decodeSegment(barCode.substring(16, 21));
        int digit5 = ZipCodeUtil.decodeSegment(barCode.substring(21, 26));

        int zipCode = (digit1 * 10000) + (digit2 * 1000) + (digit3 * 100) + (digit4 * 10) + digit5;
        return zipCode;
    }

    /**
     * Checks if the given zip code is within 00000–99999.
     *
     * @param zipCode
     * @return if the zip code is valid
     */
    public static boolean isValidZipCode(int zipCode) {
        return zipCode >= 0 && zipCode <= 99999;
    }

    /**
     * Checks if the bar code is valid (is 32 characters long, frame bars, and is only composed of
     * half bars and full bars).
     *
     * @param barCode
     * @return if the bar code is valid
     */
    public static boolean isValidBarCode(String barCode) {
        // Needs to be exactly 32 characters long
        if (barCode.length() != 32) {
            return false;
        }

        // Checks if frame bars are present
        if (!barCode.startsWith("|") || !barCode.endsWith("|")) {
            return false;
        }

        // Must only contain full bars and half bars
        for (int i = 0; i < barCode.length(); i++) {
            char bar = barCode.charAt(i);
            if (bar != '|' && bar != ':') {
                return false;
            }
        }

        return true;
    }
}
