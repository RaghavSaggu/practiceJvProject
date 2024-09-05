package dataStrucures;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        // create an instance of ConcurrentHashMap
        ConcurrentHashMap<Integer, String> chmap = new ConcurrentHashMap();

        // Add elements using put()
        chmap.put(10, "ten");
        chmap.put(20, "twenty");
        chmap.put(30, "thirty");
        chmap.put(40, "forty");
        chmap.put(50, "fifty");
//        chmap.put(60, null);
//        chmap.put(null, "sixty");

        traverseAndPrint(chmap);
    }

    public static void traverseAndPrint(ConcurrentHashMap chmap) {
        // Create an Iterator over the ConcurrentHashMap
        Iterator<ConcurrentHashMap.Entry<Integer, String> > itr = chmap.entrySet().iterator();

        // The hasNext() method is used to check if there is a next element and the next() method is used to retrieve the next element
        while (itr.hasNext()) {
            ConcurrentHashMap.Entry<Integer, String> entry = itr.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }
}
