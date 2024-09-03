package others;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumFromIntegers {
    public static void main(String[] args) {
        int[] intArr = {5,4,3,2,1};
        // first way
        Arrays.sort(intArr);
        int minValue = intArr[0];
        int maxValue = intArr[intArr.length-1];
        System.out.print("Min was : " + minValue);
        System.out.println(", Max was : " + maxValue);

        List<Integer> intList = Arrays.stream(intArr).boxed().collect(Collectors.toList());
        // another way
        minValue = intList.stream().map(v -> Integer.valueOf((int) v)).min(Integer::compare).get();
        maxValue = intList.stream().map(v -> Integer.valueOf((int) v)).max(Integer::compare).get();
        System.out.print("Min was : " + minValue);
        System.out.println(", Max was : " + maxValue);

//        // another way
        List<Integer> sortedList = intList.stream().sorted().collect(Collectors.toList());
        minValue = sortedList.get(0);
        maxValue = sortedList.get(sortedList.size()-1);
        System.out.print("Min was : " + minValue);
        System.out.println(", Max was : " + maxValue);
    }
}
