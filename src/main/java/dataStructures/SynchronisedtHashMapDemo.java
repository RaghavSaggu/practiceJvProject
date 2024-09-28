package dataStructures;

import java.util.*;

public class SynchronisedtHashMapDemo {
    public static void main(String args[])
    {
        // Creating a HashMap
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();

        // Adding the elements using put method
        hmap.put(10, "ten");
        hmap.put(20, "twenty");
        hmap.put(30, "thirty");
        hmap.put(40, "forty");
        hmap.put(50, "fifty");
        hmap.put(60, null);
        hmap.put(null, "sixty");

        traverseAndPrint(hmap);
    }

    public static void traverseAndPrint(HashMap hmap) {
        // Creating a synchronized map
        Map map = Collections.synchronizedMap(hmap);
        Iterator<HashMap<Integer, String>> itr = map.entrySet().iterator();
        // Printing the elements
        while (itr.hasNext()) {
            Map.Entry me = (Map.Entry)itr.next();
            System.out.println(me.getKey() + ": " + me.getValue());
        }
    }
}
