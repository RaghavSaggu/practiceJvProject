package dataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxRepeatAllowedUpto2 {

    public static void main(String[] args) {
        MaxRepeatAllowedUpto2 runner = new MaxRepeatAllowedUpto2();
        int[] arr = {1, 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5};
        int[] list = runner.removeRepeatedNumbersFromArray(arr);
        System.out.println("Total elements in list (repeated max 2): " + list.length);
        Arrays.stream(list).forEach(element -> System.out.print(element + " "));
        System.out.println("\n======================================= END =======================================");
    }

    public int[] removeRepeatedNumbersFromArray(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; ) {
            if (arr[i] == arr[i + 1]) {
                int element = arr[i];
                int elementIter = 0;
                for (int j = i; j < arr.length && arr[j] == element; j++) {
                    elementIter++;
                }

                if (elementIter > 1) {
                    i = i + elementIter;
                    list.add(element);
                    list.add(element);
                } else {
                    i++;
                    list.add(element);
                }
            } else {
                list.add(arr[i]);
                i++;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}