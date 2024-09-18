package logical;

import java.util.Arrays;

// if element on odd is greater than element on odd then print shuffle of them
public class DancingElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        callWorkerMethod2(arr, arr.length);
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
    }

    private static void callWorkerMethod2(int[] arr, int length) {
        if (arr.length <= 0 || arr.length != length)
            return;
        Arrays.sort(arr);
        for (int i = 0; i < length - 1; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
    }
}
