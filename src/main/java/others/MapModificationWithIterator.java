package others;

import java.util.*;

public class MapModificationWithIterator {
    public static void main(String[] args) {
        Map<Integer, Integer> mapInt = new HashMap<>();
        try {
            for (int i = 1; i <= 100; i++) {
                mapInt.put(i, i);
            }
            System.out.println(mapInt);

//            // it will throw ConcurrentModificationException
//            for (Integer key : mapInt.keySet()) {
//                if (mapInt.get(key) % 2 != 0) {
//                    mapInt.remove(key);
//                }
//            }

            Iterator<Map.Entry<Integer, Integer>> iterator = mapInt.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if(entry.getValue() % 2 != 0) {
                    iterator.remove();
                }
            }
            System.out.println(mapInt);
        } catch (ConcurrentModificationException cme) {
            cme.printStackTrace();
            System.out.println("Map entry modification not allowed here");
        } catch (Exception e) {
            System.out.println("Something went wrong ::: " + e.getMessage());
        }
    }
}
