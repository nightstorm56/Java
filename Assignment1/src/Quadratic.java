import java.util.Scanner;

/**
 * Gives the quadratic roots based on a user's input of three coefficients (a, b, and c).
 * Output displays custom strings based on the results
 * Part 1 - Quadratic Roots
 * Assignment 1
 * Course - CS-1410-LO1 XL
 * @author  Val Jensen
 */

public class Quadratic {
    public static void main(String[] args) {
        // Create the Scanner (input)
        Scanner input = new Scanner(System.in);

        // Capture three numbers (integers or floats) from the user
        System.out.print("Enter a, b, c: ");
        double varA = input.nextDouble();
        double varB = input.nextDouble();
        double varC = input.nextDouble();

        // Calculate the discriminant and square root of the discriminant
        double discriminant = (varB * varB) - (4 * varA * varC);
        double squareRoot = Math.sqrt(discriminant);

        // Create the needed variables to output later
        double r1;
        double r2;

        // These variables help build the output sentence based on the results and are captured in the if-else
        String isOrAre;
        String theRoots = "";

        // If the square root of the discriminant is larger than 0, then there are two roots
        if (squareRoot > 0) {
            r1 = (-varB + squareRoot) / (2 * varA);
            r2 = (-varB - squareRoot) / (2 * varA);
            isOrAre = "are two roots";
            theRoots = "\nr1 = " + r1 + "\nr2 = " + r2;
        }
        // If the square root of the discriminant is equal to 0, then there is one root
        else if (squareRoot == 0) {
            r1 = (-varB + squareRoot) / (2 * varA);
            isOrAre = "is one root";
            theRoots = "\nr1 = " + r1;
        }
        // If the square root of the discriminant is less than 0, then there are no real roots
        else {
            isOrAre = "are no roots";
        }

        // Output the results
        System.out.printf("There %s for the quadratic equation with these coefficients.%s", isOrAre, theRoots);
    }
}
