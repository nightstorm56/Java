import java.util.Scanner;

/**
 * Will output a pyramid with decrementing->incrementing digits with 1 being in the center
 * Spacing of the pyramid takes in to account the character length that is input by the user
 * Part 1 - Pyramid 1
 * Assignment 2
 * Course - CS-1410-LO1 XL
 * @author  Val Jensen
 */

public class Pyramid1 {
    public static void main(String[] args) {
        // Create and capture user input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of lines: ");
        int total = input.nextInt();

        // Calculate how "long" the user's input is and add one for a space
        int spaceLength = Integer.toString(total).length() + 1;

        // Create the pyramid
        for (int i = 1; i <= total; i++) {
            // This line adds the required spaces to the front of the output to "center" the pyramid
            if (i < total) {
                System.out.printf(spaceAdder(total, spaceLength, i), " ");
            }
            // Build the left side of the pyramid (Decrement the numbers to 1)
            for (int j = i; j > 0; j--) {
                System.out.printf(numberSpacer(spaceLength), j);
            }
            // Build the right side of the pyramid (Increment the numbers)
            for (int k = 2; k <= i; k++) {
                System.out.printf(numberSpacer(spaceLength), k);
            }
            // Drop to the next pyramid layer
            System.out.println();
        }
    }

    // Method to create the spaces between the numbers, which also includes the output value in the for loop
    public static String numberSpacer(int length) {
        return String.format("%%%dd", length);
    }

    // Method to create the needed spaces before the number output, which is half length of the base of the pyramid
    public static String spaceAdder(int total, int spaceLength, int i) {
        return String.format("%%%ss", (total * spaceLength) - (spaceLength * i));
    }
}