package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4};
//        arr = removeDuplicateUsingBruteForce(arr);
//        arr = removeDuplicateUsingMap(arr);
        arr = removeDuplicateUsingStream(arr);
        System.out.println();
    }

    private static int[] removeDuplicateUsingBruteForce(int[] arr) {
        if(arr == null || arr.length <= 0) return null;
        int[] newArr = new int[arr.length];
        for(int i = 0, j = 0; i < arr.length; i++) {
            final int streamVar = i;
            if(Arrays.stream(newArr).filter(n -> n == arr[streamVar]).count() == 0) {
                newArr[j] = arr[i];
                j++;
            }
        }
        return newArr;
    }

    private static int[] removeDuplicateUsingMap(int[] arr) {
        if(arr == null || arr.length <= 0) return null;
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int[] removeDuplicateUsingStream(int[] arr) {
        if(arr == null || arr.length <= 0) return null;
        HashSet<Integer> set = new HashSet<>();
        set = (HashSet<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toSet());
        System.out.println(set);
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
