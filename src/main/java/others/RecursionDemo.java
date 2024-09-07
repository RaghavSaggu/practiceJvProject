package others;

public class RecursionDemo {
    public static void main(String[] args) {
        callRecursiveMethodToPrintNumber(1234);
    }

    public static void callRecursiveMethodToPrintNumber(int a) {
        System.out.print(a % 10);
        if (a % 10 != 0)
            callRecursiveMethodToPrintNumber(a / 10);
        System.out.print(a % 10);
    }
}
