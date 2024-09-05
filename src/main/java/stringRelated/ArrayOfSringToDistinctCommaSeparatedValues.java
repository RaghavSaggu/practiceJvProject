package stringRelated;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ArrayOfSringToDistinctCommaSeparatedValues {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1,0,2,3,4", "4,5,2,6");
        String setFromStringList = list.stream()
                .flatMap(str -> Arrays.stream(str.split(","))) // Split each string by comma and flatten
                .filter(Predicate.not(String::isBlank))
                .map(Integer::parseInt) // Convert each substring to Integer
                .collect(Collectors.toSet()) // Collect into a Set to ensure uniqueness
                .stream() // Convert the Set back to a Stream
                .map(String::valueOf) // Convert each integer to a String
                .collect(Collectors.joining(",")); // Join the strings with commas
        System.out.println(setFromStringList);
    }
}
