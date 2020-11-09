import java.util.Arrays;

/**
 * This program evaluates the linear and binary searching, along
 * with comparing performance difference between the selection sort
 * and the built-in java.util.Arrays.sort.
 * Assignment 4 - Performance Evaluation
 * Course - CS-1410-LO1 XL
 * @author Val Jensen
 */
public class EvaluationDriver {
    static final int MAX_VALUE = 1_000_000;
    static final int MAX_ARRAY_SIZE = 100_000;
    static final int ARRAY_INCREMENT = 20_000;
    static final int NUMBER_SEARCHES = 50_000;

    public static void main(String[] args) {
        demoLinearSearchUnsorted();
        demoLinearSearchSorted();
        demoBinarySearchSelectionSort();
        demoBinarySearchFastSort();
    }

    // Method to create and return a random array of integers
    public static int[] generateNumbers(int howMany, int maxValue) {
        if (howMany <= 0) { return null; }
        int[] numbers = new int[howMany];
        for (int i = 0; i < howMany; i++) {
            int randomNumber = (int) (Math.random() * maxValue);
            numbers[i] = randomNumber;
        }
        return numbers;
    }

    // Method to do a linear search on an array of data
    public static boolean linearSearch(int[] data, int search) {
        for (int item : data) {
            if (item == search) {
                return true;
            }
        }
        return false;
    }

    // Method to do a binary search on an array of data
    public static boolean binarySearch(int[] data, int search) {
        int lower = 0;
        int upper = data.length - 1;

        boolean found = false;
        while (!found && lower <= upper) {
            int middle = (lower + upper) / 2;
            if (data[middle] == search) {
                found = true;
            } if (data[middle] < search) {
                lower = middle + 1;
            } else {
                upper = middle - 1;
            }
        }
        return found;
    }

    // Method to selection sort an array of data
    public static void selectionSort(int[] data) {
        for (int start = 0; start < data.length - 1; start++) {
            int minPos = start;
            for (int scan = start + 1; scan < data.length; scan++) {
                if (data[scan] < data[minPos]) {
                    minPos = scan;
                }
            }
            int temp = data[start];
            data[start] = data[minPos];
            data[minPos] = temp;
        }
    }

    /*
     * Demo methods will do the following based on the below info:
     * x:                           y:
     * 0 - No sort                  1 - Linear Search
     * 1 - Selection Sort           2 - Binary Search
     * 2 - Arrays.sort()
     * The methods were created this way to reduce the size of the code and remove repeat data
     */
    public static void demoLinearSearchUnsorted() {
        System.out.println("--- Linear Search Timing (unsorted) ---");
        createAndSort(0, 1);
    }

    public static void demoLinearSearchSorted() {
        System.out.println("--- Linear Search Timing (Selection Sort) ---");
        createAndSort(1, 1);
    }

    public static void demoBinarySearchSelectionSort() {
        System.out.println("--- Binary Search Timing (Selection Sort) ---");
        createAndSort(1, 2);
    }

    public static void demoBinarySearchFastSort() {
        System.out.println("--- Linear Search Timing (Arrays.sort) ---");
        createAndSort(2, 2);
    }

    public static void createAndSort(int x, int y) {
        for (int i = ARRAY_INCREMENT; i <= MAX_ARRAY_SIZE; i += ARRAY_INCREMENT) {
            int[] randomArray = generateNumbers(i, MAX_VALUE);
            int foundNumbers = 0;
            long timeStart = System.currentTimeMillis();
            if (randomArray != null) {
                if (x == 1) {
                    selectionSort(randomArray);
                } else if (x == 2) {
                    Arrays.sort(randomArray);
                }
            }
            for (int j = 0; j <= NUMBER_SEARCHES; j++) {
                int randomNumber = (int) (Math.random() * MAX_VALUE);
                boolean results = false;
                if (randomArray != null) {
                    if (y == 1) {
                        results = linearSearch(randomArray, randomNumber);
                    } else if (y == 2) {
                        results = binarySearch(randomArray, randomNumber);
                    }

                    if (results) {
                        foundNumbers++;
                    }
                }
            }
            long timeEnd = System.currentTimeMillis();
            dataOutput(i, foundNumbers, timeEnd, timeStart);
        }
    }

    // Method to output the results of the searches
    public static void dataOutput(int i, int foundNumbers, long timeEnd, long timeStart) {
        System.out.printf("Number of items       : %d\n", i);
        System.out.printf("Times value was found : %d\n", foundNumbers);
        System.out.printf("Total search time     : %d ms\n\n", timeEnd - timeStart);
    }
}
