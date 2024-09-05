package stringRelated;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxLengthStringFinder {

    public static void main(String[] args) {
        // Example list of strings
        List<String> strings = Arrays.asList("apple", "banana", "kiwi", "strawberry", "blueberry", "z");

        // Find the longest string
        String longest = findLongestStringWithStreams(strings);
        System.out.println("The longest string is: " + longest);
    }

    public static String findLongestStringWithStreams(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }
        // Using Streams to find the longest string
        String longest = strings.stream()
                .max((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .orElseThrow(() -> new IllegalArgumentException("List cannot be empty"));

        return longest;
    }

    public static String findLongestStringUsingMapsWithStream(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }
        Map<Integer, String> map = strings.stream()
                .collect(Collectors.groupingBy(s -> Integer.valueOf(s.length()), Collectors.joining()));
        String longest = (map != null && !map.keySet().isEmpty())
                ? map.get(map.keySet().stream().max(Integer::compareTo).get())
                : null;
        return longest;
    }

    public static String findLongestString(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }

        // Initialize the longest string to the first element
        String longest = strings.get(0);

        // Iterate through the list to find the longest string
        for (String str : strings) {
            if (str.length() > longest.length()) {
                longest = str;
            }
        }

        return longest;
    }
}
