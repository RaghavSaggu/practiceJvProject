package collectionAndStreams;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountingUsingStreamsAndMaps {
    public static void main(String[] args) {
        String testString = "This is a test string";
        printStringCharFrequency(testString);
        testString = "1, 2, 3, 4, 5, 5, 5, 5, 4, 1, 1, 1, 5, 1, 2, 3, 4, 4, 1, 1, 1";
        printMostFrequentIntegerInCommaSeparatedString(testString);
    }

    private static void printStringCharFrequency(String testString) {
        Map<String, Long> map = Arrays.stream(testString.split(""))
                .filter(s -> !s.trim().isEmpty())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("All characters with their frequency in \"" + testString + "\":\n\t" + map);
//        System.out.println("map entryset " + map.entrySet());
//        System.out.println("map keyset " + map.keySet());
//        System.out.println("map values " + map.values());
    }

    public static void printMostFrequentIntegerInCommaSeparatedString(String commaSeparatedIntVals) {
        if (commaSeparatedIntVals.isEmpty()) commaSeparatedIntVals = "1, 2, 3, 4, 5, 5, 5, 5, 4, 1, 1, 1, 5";
        int arr[] = Arrays.stream(commaSeparatedIntVals.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxOccurredElement = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()) // Find entry with max count
                .map(Map.Entry::getKey) // Get the element
                .orElseThrow(() -> new RuntimeException("Array is empty")); // Handle empty commaSeparatedIntVals
        System.out.println(maxOccurredElement + " is the most frequent number in \n\t{" + commaSeparatedIntVals + "}");
    }
}
