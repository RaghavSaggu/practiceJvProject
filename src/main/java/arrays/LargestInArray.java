package arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LargestInArray {
    public static void main(String[] args) {
        int[] arr = {91, 3, 511, 7, 9};
        int largest = largestFromArrayUsingStream(arr);
        System.out.println("Largest in array is: " + largest);
    }

    private static int largestFromArrayUsingStream(int[] arr) {
        List<Integer> integerList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int largest = integerList.stream().max((o1, o2) -> Integer.compare(o1, o2)).orElseThrow();
        return largest;
    }

    private static int largestFromArray(int[] arr) {
        int largest = 0;
        if (arr.length > 0) {
            Arrays.sort(arr);
            largest = arr[arr.length - 1];
        }
        return largest;
    }

    private static int largestFromArrayUsingBruteForce(int[] arr) {
        int largest = 0;
        for (int num : arr)
            largest = num > largest ? num : largest;
//        for (int i = 0; i < arr.length; i++)
//            largest = arr[i] > largest ? arr[i] : largest;
        return largest;
    }
}
