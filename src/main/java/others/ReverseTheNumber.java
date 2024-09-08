package others;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseTheNumber {
    public static void main(String[] args) {
        int num = 12345, reversed = 0;
//        reversed = getTheReversedNumberUsingStringBuilder(num);
//        reversed = getTheReversedNumber(num);
//        reversed = getTheReversedNumberUsingArrays(num);
        reversed = getTheReversedNumberUsingRecursion(num);
        System.out.println("Original number was: " + num);
        System.out.println("Reversed number is: " + reversed);
    }

    private static int response = 0;
    private static int getTheReversedNumberUsingRecursion(int num) {
        if (num == 0)
            return response;

        if (num > 0) {
            int temp = num % 10;
            response = response * 10 + temp;
            getTheReversedNumberUsingRecursion(num / 10);
        }

        return response;
    }

    private static int getTheReversedNumberUsingArrays(int number) {
        String numStr = String.valueOf(number);
        int[] result = numStr.chars().map(Character::getNumericValue).toArray();
        List<Integer> integerList = Arrays.stream(result).boxed().collect(Collectors.toList());
        Collections.reverse(integerList);
        String joinedString = integerList.stream().map(elem -> String.valueOf(elem)).collect(Collectors.joining());
        return Integer.valueOf(joinedString);
    }

    private static int getTheReversedNumber(int num) {
        int reversed = 0;
        while (num != 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }

    private static int getTheReversedNumberUsingStringBuilder(int num) {
        StringBuilder numStr = new StringBuilder(String.valueOf(num));
        return Integer.valueOf(numStr.reverse().toString());
    }
}
