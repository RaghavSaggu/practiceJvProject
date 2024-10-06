package stringRelated;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PrintNonNullStrings {
    public static void main(String[] args) {
        //Write a Java program to filter out null values from a list of strings.
        List<String> words = Arrays.asList("apple", null, "banana", null, "cat");
        words.stream().filter(Objects::nonNull).forEach(System.out::println);
    }
}
