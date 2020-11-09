/**
 * This program determines if points are contained within circles or rectangles.
 * Completed based off of provided skeleton project (Inside class and lines 13-22)
 * Assignment 3 - Inside
 * Course - CS-1410-LO1 XL
 * @author  Val Jensen
 */
public class Inside {
    /**
     * This is the primary driver code to test the "inside" capabilities of the
     * various functions.
     */
    public static void main(String[] args) {
        double[] ptX = { 1, 2, 3, 4 };
        double[] ptY = { 1, 2, 3, 4 };
        double[] circleX = { 0, 5 };
        double[] circleY = { 0, 5 };
        double[] circleRadius = { 3, 3 };
        double[] rectLeft = { -2.5, -2.5 };
        double[] rectTop = { 2.5, 5.0 };
        double[] rectWidth = { 6.0, 5.0 };
        double[] rectHeight = { 5.0, 2.5 };

        /*
         Logic switch to output based on if we want Circle data or Rectangle data, used to reduce repeating code
         0 is Circle output, 1 is Rectangle output
         */
        for (int circleRectangle = 0 ; circleRectangle < 2; circleRectangle++) {
            if (circleRectangle == 0) {
                System.out.println("--- Report of Points and Circles ---\n");
            } else {
                System.out.println("\n--- Report of Points and Rectangles ---\n");
            }
            // Loop through each piece of the circle or rectangle
            for (int i = 0; i < 2; i++) {
                // Loop through each given point
                for (int j = 0; j < ptX.length; j++) {
                    reportPoint(ptX[j], ptY[j]);
                    if (circleRectangle == 0) {
                        // Loop through each circle and check the point against the circle data
                        if (isPointInsideCircle(ptX[j], ptY[j], circleX[i], circleY[i], circleRadius[i])) {
                            System.out.print("is inside ");
                        } else {
                            System.out.print("is outside ");
                        }
                        reportCircle(circleX[i], circleY[i], circleRadius[i]);
                    } else {
                        // Loop through each rectangle and check the point against the rectangle data
                        if (isPointInsideRectangle(
                                ptX[j], ptY[j], rectLeft[i], rectTop[i], rectWidth[i], rectHeight[i])) {
                            System.out.print("is inside ");
                        } else {
                            System.out.print("is outside ");
                        }
                        reportRectangle(rectLeft[i], rectTop[i], rectWidth[i], rectHeight[i]);
                    }
                    System.out.println();
                }
            }
        }
    }

    // Method to report back the point data
    static void reportPoint(double x, double y) {
        System.out.printf("Point(%.1f, %.1f) ", x, y);
    }

    // Method to report back the circle data
    static void reportCircle(double x, double y, double r) {
        System.out.printf("Circle(%.1f, %.1f) Radius: %.1f ", x, y, r);
    }

    // Method to report back the rectangle data, changes the width and height to their actual points
    static void reportRectangle(double left, double top, double width, double height) {
        System.out.printf("Rectangle(%.1f, %.1f, %.1f, %.1f) ", left, top, left+width, top-height);
    }

    // Method to test if the given point is inside the circle
    static boolean isPointInsideCircle(double ptX, double ptY, double circleX, double circleY, double circleRadius) {
        return Math.pow((ptX - circleX), 2) + Math.pow((ptY - circleY), 2) <= Math.pow(circleRadius, 2);
    }

    // Method to test if the given point is inside the rectangle
    static boolean isPointInsideRectangle(
            double ptX, double ptY, double rLeft, double rTop, double rWidth, double rHeight) {
        return ptX >= rLeft && ptX <= rLeft + rWidth && ptY <= rTop && ptY >= rTop - rHeight;
    }
}
