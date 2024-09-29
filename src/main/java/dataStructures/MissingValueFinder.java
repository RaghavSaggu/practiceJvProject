package dataStructures;

public class MissingValueFinder {
    // GlobalLogic 2nd round of interview
    public static void main(String[] args) {
        findMissingValue();
    }

    public static void useSomeBitwiseOrShiftOperators(int arg) {
        // write a java program to return 9 if the argument passed is 3 and 9 if the argument passed is 3; (not achieved yet 1001 to 0011)
        System.out.println("The returnable number is: " + (0b1000 << 2));
    }

    public static void findMissingValue() {
        int[] arr = {7, 5, 6, 1, 4, 2};
        int n = arr.length + 1; // n is the total number of elements including the missing one
        int expectedSum = n * (n + 1) / 2; // Sum of first n natural numbers
        int actualSum = 0;

        for (int num : arr) {
            actualSum += num; // Calculate the sum of the elements in the array
        }

        System.out.println("The missing value is: " + (expectedSum - actualSum));  // The missing number
    }
}
