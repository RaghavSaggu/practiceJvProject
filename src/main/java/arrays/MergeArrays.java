package arrays;

import java.util.Arrays;

public class MergeArrays {

    public static void main(String[] args) {
        try {
            int[] arr1 = {1, 3, 5}, arr2 = {2, 4, 6};
            int[] merged = workerMethod(arr1, arr2);
            System.out.println(Arrays.toString(merged));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int[] workerMethod(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, merged, 0, arr1.length);
        System.arraycopy(arr2, 0, merged, arr1.length, arr2.length);
        Arrays.sort(merged);
        return merged;
    }

}
