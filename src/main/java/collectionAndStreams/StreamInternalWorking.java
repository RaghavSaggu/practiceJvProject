package collectionAndStreams;

import java.util.Arrays;
import java.util.List;

public class StreamInternalWorking {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(11, 12, 33, 84, 15, 16, 11, 12, 35, 66, 57, 68, 65, 43, 22, 22);
        StreamInternalWorking stream = new StreamInternalWorking();
        stream.streamDemo(list);
    }

    private void streamDemo(List<Integer> list) {
        System.out.println("Answer is: " + list.stream()
                .filter(i -> {
                    boolean result = i % 2 == 0;
                    System.out.println(i + " filter: " + result);
                    return result;
                }).map(i -> {
                    int result = i *= 2;
                    System.out.println(i + " map: " + result);
                    return result;
                })
                .mapToInt(i -> i).sum());
    }

    private void streamDemoShortCircuitIntermediateLimit(List<Integer> list) {
        System.out.println("Answer is: " + list.stream()
                .filter(i -> {
                    boolean result = i % 2 == 0;
                    System.out.println(i + " filter: " + result);
                    return result;
                }).limit(3)
                .mapToInt(i -> i).sum());
    }

    private void parallelStreamDemo(List<Integer> list) {
        System.out.println("Answer is: " + list.parallelStream()
                .filter(i -> {
                    boolean result = i % 2 == 0;
                    System.out.println(i + " filter: " + result);
                    return result;
                })
                .map(i -> {
                    int result = i * 2;
                    System.out.println(i + " mapping: " + result);
                    return result;
                })
                .findAny().get());
    }
}
