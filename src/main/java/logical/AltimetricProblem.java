package logical;

import java.util.HashSet;
import java.util.stream.IntStream;

public class AltimetricProblem {
    public static void main(String[] args) {
        AltimetricProblem runner = new AltimetricProblem();
        runner.usingStreams(1000);
    }

    private void usingStreams(int N) {
        IntStream.range(1, N).filter(AltimetricProblem::hasRepeatedDigitsOptimized).forEach(System.out::println);
    }

    private void usingBruteForceApproch(int N) {
        for (int i = 0; i < N; i++) {
            if(hasRepeatedDigits(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean hasRepeatedDigits(int i) {
        HashSet<Character> digits = new HashSet<>();
        String s = Integer.toString(i);
        for (char digit : s.toCharArray()) {
            if(!digits.add(digit)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasRepeatedDigitsOptimized(int num) {
        int bitmask = 0;
        while (num > 0) {
            int digit = num % 10;
            if((bitmask & (1 << digit)) > 0) {
                return true;
            }
            bitmask |= (1 << digit);
            num /= 10;
        }
        return false;
    }
}
