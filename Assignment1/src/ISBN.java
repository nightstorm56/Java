import java.util.Scanner;

/**
 * Will output the ISBN-10 of a nine digit ISBN.
 * The 10th character is the checksum for the nine input numbers
 * Part 2 - ISBN Numbers
 * Assignment 1
 * Course - CS-1410-LO1 XL
 * @author  Val Jensen
 */

public class ISBN {
    public static void main(String[] args) {
        //Create the Scanner (input)
        Scanner input = new Scanner(System.in);

        // Capture the nine digit ISBN minus the check digit
        System.out.print("Enter the first 9 digits of an ISBN: ");
        int capture = input.nextInt();

        // Capture each individual number from the input, needed for calculating the checksum
        int d1 = capture / 100000000 % 10;
        int d2 = capture / 10000000 % 10;
        int d3 = capture / 1000000 % 10;
        int d4 = capture / 100000 % 10;
        int d5 = capture / 10000 % 10;
        int d6 = capture / 1000 % 10;
        int d7 = capture / 100 % 10;
        int d8 = capture / 10 % 10;
        int d9 = capture % 10;

        // Multiply each digit by its weight, most important (10) -> least important (2), left to right
        int n1 = d1 * 10;
        int n2 = d2 * 9;
        int n3 = d3 * 8;
        int n4 = d4 * 7;
        int n5 = d5 * 6;
        int n6 = d6 * 5;
        int n7 = d7 * 4;
        int n8 = d8 * 3;
        int n9 = d9 * 2;

        // Add all the weighted numbers
        int product = n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9;
        // Modulo 11 the product of the weighted numbers, then subtract 11 by the remainder to get the checksum
        int remainder = product % 11;
        int checksum = 11 - remainder;

        // Output the results
        System.out.print("The ISBN-10 number is: " + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9);
        if (checksum == 10) {
            System.out.println("X");
        }
        else {
            System.out.println(checksum);
        }
    }
}
