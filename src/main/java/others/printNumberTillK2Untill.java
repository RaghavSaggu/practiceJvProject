package others;

public class printNumberTillK2Untill {
    private static void printNumberTillK(int K, int untill) {
        System.out.println(K);
        K++;
        if(K > untill) {
            return;
        } else {
            printNumberTillK(K, untill);
        }
    }

    public static void main(String[] args) {
        printNumberTillK(1, 100);
    }
}
