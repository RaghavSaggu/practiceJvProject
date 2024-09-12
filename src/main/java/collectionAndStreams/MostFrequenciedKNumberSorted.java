package collectionAndStreams;

import java.util.*;
import java.util.stream.Collectors;

public class MostFrequenciedKNumberSorted {
    public static void main(String[] args) {
        Map<Integer, Integer> mp = new HashMap<>();
        int[] arr = {4, 2, 1, 1, 3, 2, 3, 4, 4, 4, 3, 1};
        int N = arr.length;
        int K = 3;
        System.out.println("Most frequently occured numbers ( " + K + " ) with their frequencies in given list are: ");

        for(int i = 0; i<N ; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer> > list = new ArrayList<>(mp.entrySet()).stream()
                .sorted((o1, o2) -> (o1.getValue().compareTo(o2.getValue()) == 0) ? o2.getKey() - o1.getKey() : o2.getValue().compareTo(o1.getValue()))
                .collect(Collectors.toList());

        for (int i = 0; i < K; i++)
            System.out.println(list.get(i).getKey() + ": " + list.get(i).getValue());
    }
}