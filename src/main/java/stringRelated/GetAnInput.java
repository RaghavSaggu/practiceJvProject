package stringRelated;

import java.util.Scanner;

public class GetAnInput {
    public static void main(String... args) throws InterruptedException {
        Integer i = Integer.valueOf((String) getAnInput());
        System.out.println("i = " + i);
    }

    private static Object getAnInput() {
        String str = null;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the value of N: ");
            str = scanner.nextLine();
        }
        return str;
    }
}
