package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 3, 4, 4, 0, -5, -6, -5, -1, 1};
        arr = removeDuplicateUsingBruteForce(arr);
//        arr = removeDuplicateUsingMap(arr);
//        arr = removeDuplicateUsingStream(arr);
        Arrays.stream(arr).sorted().forEach(elem -> System.out.print(elem + " "));
    }

    private static int[] removeDuplicateUsingBruteForce(int[] arr) {
        if(arr == null || arr.length <= 0) return null;
        int newSize = 0;
        if(Arrays.stream(arr).filter(n -> n == 0).count() > 0)
            newSize++;
        int[] arrToGetNewSize = new int[arr.length];
        for(int i = 0, j = 0; i < arr.length; i++, j++) {
            final int streamVar = arr[i];
            if(Arrays.stream(arrToGetNewSize).filter(n -> n == streamVar).count() == 0) {
                arrToGetNewSize[j] = streamVar;
                newSize++;
            }
        }
        int newArr[] = new int[newSize];
        for(int i = 0, j = 0; i < arrToGetNewSize.length && j < newSize; i++) {
            if(arrToGetNewSize[i] != 0) {
                newArr[j] = arrToGetNewSize[i];
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
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
