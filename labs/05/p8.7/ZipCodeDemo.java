/*
 * Lab 5: P8.7 by Victor Truong and Eric Lerma
 *
 * This program allows the user to encode zip codes into bar codes and decode bar codes into zip
 * codes.
 */

import java.util.Scanner;

public class ZipCodeDemo {
    public static void main(String[] args) {
        String zipCode;
        String option;

        Scanner in = new Scanner(System.in);

        System.out.println("What would you like to do? Enter the corresponding number.");
        System.out.println("1. Enter Zip Code");
        System.out.println("2. Decode Bar Code");
        System.out.print(">> ");

        option = in.next();

        if (Integer.parseInt(option) == 1) {
            System.out.print("Please enter a zip code: ");
            zipCode = in.next();

            while (!ZipCodeUtil.isValidZipCode(Integer.parseInt(zipCode))) {
                System.out.println("Invalid! The ZIP code must be 5 digits long");
                System.out.print("Please enter the correct zip code: ");

                zipCode = in.next();
            }

            System.out.println("Your bar code is:");
            System.out.println(ZipCodeUtil.encodeZipCode(Integer.parseInt(zipCode)));
        } else {
            System.out.print("Please enter bar code to decode: ");
            zipCode = in.next();

            while (!ZipCodeUtil.isValidBarCode(zipCode)) {
                System.out.println("Invalid bar code!");
                System.out.print("Please enter the correct bar code: ");

                zipCode = in.next();
            }

            System.out.println("The Zip Code is:");
            System.out.println(ZipCodeUtil.decodeBarCode(zipCode));
        }

        in.close();
    }
}
