package collectionAndStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;

public class StreamsDemo {
    public static void main(String[] args) {
        StreamsDemo streamsDemo = new StreamsDemo();
        streamsDemo.sequentialAndParallelStreamWithReduceDemo();
    }

    public void streamDemoWithArray() {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(100);
        }
        Arrays.stream(arr).sorted().forEach(i -> System.out.print(i + " "));
    }

    public void streamDemoWithIntList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // stream filter map and forEach
        list.stream().filter(n -> n % 2 != 0).map(n -> n * 2).forEach(i -> System.out.print(i + " "));
        System.out.println();
        // reduce
        int sum = list.stream().filter(n -> n % 2 != 0).mapToInt(n -> n * 2).sum();
        System.out.println("Total using sum(): " + sum);
        int sumUsingReduce = list.stream().filter(n -> n % 2 != 0).map(n -> n * 2).reduce(0, (c, e) -> c + e);
        System.out.println("Total using reduce(): " + sumUsingReduce);
    }

    public void sequentialAndParallelStreamDemo() {
        long startTime, endTime;
        int sum;
        List<Integer> randomNumList = new ArrayList<>(10000);
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            randomNumList.add(random.nextInt(100));
        }

        startTime = System.currentTimeMillis();
        sum = randomNumList.parallelStream().mapToInt(i -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {}
            return i;
        }).sum();
        endTime = System.currentTimeMillis();
        System.out.println("Using parallel stream sum is " + sum + ", and time taken: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        sum = randomNumList.stream().mapToInt(i -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {}
            return i;
        }).sum();
        endTime = System.currentTimeMillis();
        System.out.println("Using sequential stream sum is " + sum + ", and time taken: " + (endTime - startTime));
    }

    public void sequentialAndParallelStreamWithReduceDemo() {
        long startTime, endTime;
        int sum;
        List<Integer> randomNumList = new ArrayList<>(10000);
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            randomNumList.add(random.nextInt(100));
        }

        startTime = System.currentTimeMillis();
        sum = randomNumList.parallelStream().reduce(0, Integer::sum);
        endTime = System.currentTimeMillis();
        System.out.println("Using parallel stream on reduce sum is " + sum + ", and time taken: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer o, Integer o2) {
                return o + o2;
            }
        };
        sum = randomNumList.stream().reduce(0, binaryOperator);
        endTime = System.currentTimeMillis();
        System.out.println("Using sequential stream on reduce sum is " + sum + ", and time taken: " + (endTime - startTime));
    }
}