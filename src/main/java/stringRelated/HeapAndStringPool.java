package stringRelated;

public class HeapAndStringPool {
    public static void main(String[] args) {
        heapAndStringPool();
    }
    private static void heapAndStringPool() {
        String a = "hello";
        String b = new String("hello");
        String c = "hello";
        String d = new String("hello");

        System.out.println(a == b);
    }
}
