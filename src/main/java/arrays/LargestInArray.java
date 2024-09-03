package arrays;

import java.util.Arrays;

public class LargestInArray {
    public static void main(String[] args) {
        int[] arr = {91, 3, 511, 7, 9};
        int largest = arr[0];
//        for (int num : arr) {
//            if (num > largest) {
//                largest = num;
//            }
//        }

//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] > largest)
//                largest = arr[i];
//        }
        Arrays.sort(arr);
        largest = arr[arr.length - 1];
        System.out.println("Largest in array is: " + largest);
    }
}
