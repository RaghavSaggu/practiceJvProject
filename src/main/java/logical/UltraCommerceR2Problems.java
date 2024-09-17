package logical;

import java.util.ArrayList;
import java.util.List;

public class UltraCommerceR2Problems {
    static boolean iterationsFlag = true;
    static int iterations = 0;


    public static void main(String... args) {
        List<Integer> allPrimeNumber = getAllPrimeNumbersTillN(100);
        allPrimeNumber.forEach(i -> System.out.print(i + " "));
        printIterations();

        boolean[] prime = getAllPrimes(100);
        for (int p = 0; p < prime.length; p++) {
            if (prime[p]) {
                System.out.print(p + " ");
            }
        }
        printIterations();

        System.out.println();
        int N = 122, divisor = 5;
        System.out.println("Closest number to " + N + " divisible by " + divisor + " is: " + getGreatestClosestValueMulByDivisorToNum(N, divisor));
    }


    // Method to get all prime numbers up to N using the Sieve of Eratosthenes
    public static boolean[] getAllPrimes(int N) {
        boolean[] prime = new boolean[N + 1];
        if (N < 2) {
            System.out.println("No prime numbers less than 2.");
            return prime;
        }

        // Create a boolean array "prime[0..N]" and initialize all entries as true.
        // A value in prime[i] will be false if i is Not a prime, true if i is a prime.
        for (int i = 0; i <= N; i++) {
            iterations++;
            prime[i] = true;
        }

        // 0 and 1 are not prime numbers
        prime[0] = prime[1] = false;

        for (int p = 2; p * p <= N; p++) {
            iterations++;
            // If prime[p] is not changed, then it is a prime
            if (prime[p]) {
                // Update all multiples of p
                for (int i = p * p; i <= N; i += p) {
                    iterations++;
                    prime[i] = false;
                }
            }
        }
        return prime;
    }


    private static int getGreatestClosestValueMulByDivisorToNum(int number, int divisor) {
        if (divisor == 0) return divisor;
        return (number / divisor) * divisor;
    }


    private static List<Integer> getAllPrimeNumbersTillN(int N) {
        List<Integer> listOfAllPrimeNumber = new ArrayList<>();
        if(N < 2) return listOfAllPrimeNumber;

        for (int i = 2; i <= N; i++) {
            iterations++;
            if (isPrime(i)) {
                listOfAllPrimeNumber.add(i);
            }
        }
        return listOfAllPrimeNumber;
    }

    private static boolean isPrime(int number) {
        int temp = number / 2;
        while (temp > 1) {
            iterations++;
            if (number % temp == 0)
                return false;
            temp--;
        }
        return true;
    }

    private static void printIterations() {
        if (iterationsFlag) {
            System.out.println("   <-[Total iterations done: " + iterations + "]");
            iterations = 0;
        }
    }

}
