package logical;

import java.math.BigDecimal;

public class FactorialOfNumber {
    public static void main(String[] args) {
        int number = 10;
        BigDecimal factorial = null;
        for (int i = 1; i <= number; i++) {
            if(factorial == null) factorial = BigDecimal.ONE;
            factorial = factorial.multiply(BigDecimal.valueOf(i));
        }
        System.out.println("Facotrial of number " + number + " is: " + factorial);
        // using recursion method
        System.out.println("Factorial of number using recursion " + number + ": " + factorial(BigDecimal.valueOf(number)));
    }

    private static BigDecimal factorial(BigDecimal number) {
        if(number.compareTo(BigDecimal.ZERO) == 0) return BigDecimal.ONE;
        else
            return number.multiply(factorial(number.subtract(BigDecimal.ONE)));
    }
}
