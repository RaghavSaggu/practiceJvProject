package stringRelated;

public class StringBufferAndObjectDiff {
    public void matchTheStrings () {
        String t1 = "Raghav";
        String t2 = "Raghav";
        String t3 = new String("Raghav");

        System.out.println("t1 == t2 = " + (t1 == t2)); // true
        System.out.println("t2 == t3 = " + (t1 == t3)); // false
    }
}
