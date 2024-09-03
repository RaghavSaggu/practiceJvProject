package others;

public class ReverseTheNumber {
    public static void main(String[] args) {
        int num = 12345, reversed = 0;
//        while (num != 0) {
//            reversed = reversed * 10 + num % 10;
//            num /= 10;
//        }
        StringBuilder numStr = new StringBuilder(String.valueOf(num));
        reversed = Integer.valueOf(numStr.reverse().toString());
        System.out.println(reversed);
    }
}
