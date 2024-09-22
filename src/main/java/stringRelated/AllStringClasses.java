package stringRelated;

public class AllStringClasses {
    public static void main (String[] args) {
        AllStringClasses obj = new AllStringClasses();
        obj.stringBuilderCapacityExample();
    }

    void stringPoolAndStringObjectDifference() {
        String literal1 = "Raghav";
        String literal2 = "Raghav";
        String strObj1 = new String("Raghav");
        String strObj2 = strObj1;
        String strObj3 = new String("Raghav");
        String strObjIntern = strObj2.intern();


        System.out.println("literal1 == literal2 = " + (literal1 == literal2)); // true
        System.out.println("literal2 == strObj1 = " + (literal2 == strObj1)); // false
        System.out.println("strObj1 == strObj2 = " + (strObj1 == strObj2)); // false
        System.out.println("strObj1 == strObj3 = " + (strObj1 == strObj3)); // false
        System.out.println("literal2 == strObjIntern = " + (literal2 == strObjIntern)); // true
    }

    void stringBufferCapacityExample() {
        // thread safe version of StringBuilder
        System.out.println("StringBuffer default capacity: " + new StringBuffer().capacity());
        StringBuffer s = new StringBuffer("test");
        System.out.println("StringBuffer capacity before trimToSize: " + s.capacity());
        s.trimToSize();
        System.out.println("StringBuffer capacity after trimToSize: " + s.capacity());
    }

    void stringBuilderCapacityExample() {
        System.out.println("StringBuffer default capacity: " + new StringBuilder().capacity());
        StringBuilder s = new StringBuilder("test");
        System.out.println("StringBuffer capacity before trimToSize: " + s.capacity());
        s.trimToSize();
        System.out.println("StringBuffer capacity after trimToSize: " + s.capacity());
    }
}
