package collectionAndStreams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindNthNumberFromListUsingStreams {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = Arrays.asList(12, 15, 24, 75, 89);
        Integer nthNumber = getNthSmallestNumber(listOfIntegers, 3);
//        Integer nthNumber = getNthLargestNumber(listOfIntegers, 3);
        System.out.println(nthNumber);
    }

    private static Integer getNthLargestNumber(List<Integer> listOfIntegers, int i) {
        return listOfIntegers.stream().sorted(Comparator.reverseOrder()).skip(i-1).findFirst().orElse(null);
    }

    private static Integer getNthSmallestNumber(List<Integer> listOfIntegers, int i) {
        return listOfIntegers.stream().sorted(Integer::compareTo).skip(i-1).findFirst().orElse(null);
    }
}


//    SELECT c.Name from
//    customer c
//    join orders o on c.cust_id = o.cust_id where
//    GROUP BY c.cust_id, c.cust_name
//    HAVING count(o.order_id) >2 AND SUM(o.amount) > 300;
