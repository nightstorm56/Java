import java.util.Scanner;

/**
 * Will output a pyramid with doubling->halfing digits with the largest number being in the center
 * Sides of the pyramid will start and end with 1
 * Numbers of the pyramid will double up times the number entered by the user
 * Part 2 - Pyramid 2
 * Assignment 2
 * Course - CS-1410-LO1 XL
 * @author  Val Jensen
 */

public class Pyramid2 {
    public static void main(String[] args) {
        // Create and capture user input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of lines: ");
        int total = input.nextInt();

        // Calculate the length of the future largest number to determine the character length
        int spaceLength = 1;
        for (int i = 1; i < total; i++) {
            spaceLength = spaceLength * 2;
        }

        // Add one to the determined length for the space
        spaceLength = Integer.toString(spaceLength).length() + 1;

        // Create the pyramid
        for (int i = 1; i <= total; i++) {
            if (i < total) {
                // This line adds the required spaces to the front of the output to "center" the pyramid
                System.out.printf(spaceAdder(total, spaceLength, i), " ");
            }
            // Build the left side of the pyramid (Doubles the number times the user input)
            int doubler = 1;
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    System.out.printf(numberSpacer(spaceLength), 1);
                } else {
                    if (doubler == 1) {
                        doubler = 2;
                    } else {
                        doubler = doubler * 2;
                    }
                    System.out.printf(numberSpacer(spaceLength), doubler);
                }
            }
            // Build the right side of the pyramid (Halves the number until it reaches 1)
            int k = doubler;
            if (k > 1) {
                do {
                    k = k / 2;
                    System.out.printf(numberSpacer(spaceLength), k);
                } while (k > 1);
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