package collectionAndStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamInternalWorking {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        StreamInternalWorking stream = new StreamInternalWorking();
        stream.streamDemoReduce(list);
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

    private void streamDemoReduce(List<Integer> list) {
        System.out.println("Answer is: " + list.stream()
                .filter(i -> {
                    boolean result = i % 2 == 0;
                    System.out.println(i + " filter: " + result);
                    return result;
                })
                .reduce(0, (c,e) -> {
                    System.out.println("C + E :" + c + " + " + e);
                    return c + e;
                }));
    }

    private void streamDemoCollectorsReducing(List<Integer> list) {
        System.out.println("Answer is: " + list.stream()
                .filter(i -> {
                    boolean result = i % 2 == 0;
                    System.out.println(i + " filter: " + result);
                    return result;
                })
                .collect(Collectors.reducing(0, (c,e) -> {
                    System.out.println("C + E :" + c + " + " + e);
                    return c + e;
                })));
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
