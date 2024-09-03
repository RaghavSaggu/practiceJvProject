package stringRelated;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringCharCount {
    public static void main(String[] args) {
        String testString = "This is a test string";
        Map<String, Long> map = Arrays.stream(testString.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println("character occurances " + map);
        System.out.println("map entryset " + map.entrySet());
        System.out.println("map keyset " + map.keySet());
        System.out.println("map values " + map.values());
    }
}
