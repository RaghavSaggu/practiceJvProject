package arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinMaxFromIntegers {
    public static void main(String[] args) {
        int[] intArr = {5, 4, 3, 2, 1};
        printMinAndMaxUsingBruteForce(intArr);
//        printMinAndMaxUsingStreamMinMax(intArr);
//        printMinAndMaxUsingStream(intArr);
    }

    private static void printMinAndMaxUsingBruteForce(int[] intArr) {
        Arrays.sort(intArr);
        System.out.println("Brute Force Way");
        System.out.print("Min was : " + intArr[0]);
        System.out.println(", Max was : " + intArr[intArr.length - 1]);
    }

    // another way
    private static void printMinAndMaxUsingStreamMinMax(int[] intArr) {
        List<Integer> intList = Arrays.stream(intArr).boxed().collect(Collectors.toList());
        System.out.println("Using stream min and max");
        System.out.print("Min was : " + intList.stream().min(Integer::compare).get());
        System.out.println(", Max was : " + intList.stream().max(Integer::compare).get());
    }

    // another way
    private static void printMinAndMaxUsingStream(int[] intArr) {
        List<Integer> intList = Arrays.stream(intArr).boxed().collect(Collectors.toList());
        List<Integer> sortedList = intList.stream().sorted().collect(Collectors.toList());
        System.out.println("Using stream sorting");
        System.out.print("Min was : " + sortedList.get(0));
        System.out.println(", Max was : " + sortedList.get(sortedList.size() - 1));
    }
}
