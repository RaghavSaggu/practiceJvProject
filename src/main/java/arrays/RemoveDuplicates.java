package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 2, 3, 4, 4};
        HashSet<Integer> set = new HashSet<>();
//        set = (HashSet<Integer>) Arrays.asList(arr).stream().collect(Collectors.toSet());
//        System.out.println(set);
        for (int num : arr) {
            set.add(num);
        }
        System.out.println(set);
    }
}
