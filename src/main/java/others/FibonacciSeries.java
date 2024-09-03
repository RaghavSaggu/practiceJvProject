package others;

import java.math.BigDecimal;

public class FibonacciSeries {
    public static void main(String[] args) {
        BigDecimal times = BigDecimal.valueOf(100), num1 = BigDecimal.ZERO, num2 = BigDecimal.ONE;
        System.out.println("Fibonacci Series: ");
        String stringToPrint = num1 + ", " + num2;
        System.out.println(stringToPrint);
        for (int i = 2; i < times.intValue(); i++) {
            BigDecimal num3 = num1.add(num2);
            stringToPrint = stringToPrint.concat(", " + num3);
            System.out.println(stringToPrint);
            num1 = num2;
            num2 = num3;
        }
    }
}
