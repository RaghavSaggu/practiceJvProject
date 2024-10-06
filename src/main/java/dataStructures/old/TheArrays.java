package dataStructures.old;

import java.util.Arrays;

public class TheArrays {
    public static void main(String[] args) {
        String colors[] = new String[5];
        colors[0] = "Red";
        colors[1] = "White";
        System.out.println(Arrays.toString(colors));
        System.out.println(colors[0]);

        for(String str: colors) {
            System.out.print(str + ", ");
        }
        System.out.println();
        Arrays.stream(colors).forEach(System.out::print);
    }
}
