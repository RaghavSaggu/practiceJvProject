package stringRelated;

import collectionAndStreams.DemoFuncInterface;

import java.util.Map;
import java.util.TreeMap;

public class WordCharFrequency {
    static void count_freq(String str) {
        Map<Character, Integer> mp = new TreeMap<>();

        // Splitting to find the word
        char[] arr = str.toCharArray();

        // Loop to iterate over the words
        for (int i = 0; i < arr.length; i++) {
            if (mp.containsKey(arr[i])) {
                mp.put(arr[i], mp.get(arr[i]) + 1);
            } else {
                mp.put(arr[i], 1);
            }
        }

        // Loop to iterate over the elements of the map
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String country = "RAGHAV";
        count_freq(country);
//        int num = 12;
//        System.out.println("square of " + num + " is : " + result(num, x -> x * x));
    }

    public static int result(int num, DemoFuncInterface funcInterface) {
        return funcInterface.calculateSquare(num);
    }
}
