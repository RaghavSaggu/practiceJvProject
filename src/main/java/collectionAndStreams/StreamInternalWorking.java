package collectionAndStreams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamInternalWorking {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        StreamInternalWorking stream = new StreamInternalWorking();
        stream.getMinAndMaxUsingCollectorsGroupingBy(list);
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

    public void getMinAndMaxUsingCollectorsGroupingBy(List<Integer> noUseList) {
        //Given a list of share market with symbol, opening price (min,max), and closing price (min,max), group them by symbol and find the minimum and maximum opening and closing each symbol.

        List<MarketPrice> shares = Arrays.asList(
                new MarketPrice("AAPL", 150.0, 155.0),
                new MarketPrice("AAPL", 152.0, 157.0),
                new MarketPrice("AAPL", 153.0, 160.0),
                new MarketPrice("AAPL", 151.0, 158.0),
                new MarketPrice("GOOGL", 2800.0, 2825.0),
                new MarketPrice("GOOGL", 2790.0, 2810.0),
                new MarketPrice("GOOGL", 2815.0, 2830.0),
                new MarketPrice("GOOGL", 2785.0, 2805.0),
                new MarketPrice("MSFT", 300.0, 305.0),
                new MarketPrice("MSFT", 302.0, 310.0),
                new MarketPrice("MSFT", 298.0, 307.0),
                new MarketPrice("MSFT", 299.0, 306.0),
                new MarketPrice("AMZN", 3400.0, 3425.0),
                new MarketPrice("AMZN", 3390.0, 3410.0),
                new MarketPrice("AMZN", 3415.0, 3430.0),
                new MarketPrice("AMZN", 3385.0, 3405.0),
                new MarketPrice("TSLA", 700.0, 710.0),
                new MarketPrice("TSLA", 695.0, 720.0),
                new MarketPrice("TSLA", 705.0, 715.0),
                new MarketPrice("TSLA", 690.0, 700.0),
                new MarketPrice("NFLX", 500.0, 510.0),
                new MarketPrice("NFLX", 495.0, 505.0),
                new MarketPrice("NFLX", 505.0, 515.0),
                new MarketPrice("NFLX", 490.0, 500.0),
                new MarketPrice("FB", 350.0, 355.0),
                new MarketPrice("FB", 348.0, 360.0),
                new MarketPrice("FB", 352.0, 358.0),
                new MarketPrice("FB", 349.0, 356.0)
        );

        Map<String, DoubleSummaryStatistics> result = shares.stream()
                .collect(Collectors.groupingBy(MarketPrice::getShareName, Collectors.summarizingDouble(MarketPrice::getMinPrice)));
        // Print Min and Max prices
        for (String shareName : result.keySet()) {
            DoubleSummaryStatistics stats = result.get(shareName);
            System.out.println("Share: " + shareName +
                    ", Min Price: " + stats.getMin() +
                    ", Max Price: " + shares.stream()
                    .filter(marketPrice -> marketPrice.getShareName().equals(shareName))
                    .mapToDouble(MarketPrice::getMaxPrice)
                    .max().orElse(Double.NaN));
        }
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

class MarketPrice {
    private String shareName;
    private double minPrice;
    private double maxPrice;

    public MarketPrice(String shareName, double opening, double maxPrice) {
        this.shareName = shareName;
        this.minPrice = opening;
        this.maxPrice = maxPrice;
    }

    public String getShareName() {
        return shareName;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }
}