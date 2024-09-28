package dataStructures;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMapAndHashTableDiff {
    public static void main(String[] args) {
        mapDemo();
    }

    public static void mapDemo() {
        Map<Integer, Integer> map = new HashMap<>();
//        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            map.put((int) (Math.random() * 100), null);
        }
        System.out.println(map);
        map.put(2, null);
        map.put(null, null);
        map.put(1, null);
        System.out.println(map);
    }

    public static void hashTableDemo() {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for(int i = 0; i<10 ; i++) {
            hashtable.put(i, i);
        }
        System.out.println(hashtable);
    }
}
