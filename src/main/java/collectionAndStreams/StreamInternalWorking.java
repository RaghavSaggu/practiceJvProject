package collectionAndStreams;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StreamInternalWorking {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        StreamInternalWorking stream = new StreamInternalWorking();
        stream.streamDemoCollectorsFiltering(list);
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

    private void streamDemoCollectorsSummarizingInt(List<Integer> list) {
        System.out.println("Answer is: " + list.stream()
                .peek(i -> System.out.println("Peeking Value: " + i))
                .collect(Collectors.summarizingInt(value -> {
                    System.out.println("Summarizing: " + value);
                    return value;
                })));
    }

    private void streamDemoCollectorsGroupingBy(List<Integer> list) {
        System.out.println("Answer is: " + list.stream()
                .peek(i -> System.out.println("Peeking Value: " + i))
                .collect(Collectors.groupingBy(value -> {
                    System.out.println("Grouping By: " + value);
                    return value;
                })));
    }

    private void streamDemoCollectorsGroupingBy2Param(List<Integer> list) {
        System.out.println("Answer is: " + list.stream()
                .peek(i -> System.out.println("Peeking Value: " + i))
                .collect(Collectors.groupingBy(value -> {
                    System.out.println("Grouping By: " + value);
                    return value;
                }, Collectors.counting())));
    }

    private void streamDemoCollectorsGroupingBy3Param(List<Integer> list) {
        System.out.println("Answer is: " + list.stream()
                .peek(i -> System.out.println("Peeking Value: " + i))
                .collect(Collectors.groupingBy(value -> {
                    System.out.println("Grouping By: " + value);
                    return value;
                }, TreeMap::new, Collectors.counting())));
    }

    private void streamDemoCollectorsFiltering(List<Integer> list) {
        System.out.println("Answer is: " + list.stream()
                .peek(i -> System.out.println("Peeking Value: " + i))
                .collect(Collectors.filtering(i -> {
                    System.out.println("Filtering using Collectors: " + i);
                    return i % 2 == 0;
                }, Collectors.counting())));
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
