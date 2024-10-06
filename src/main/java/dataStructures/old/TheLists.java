package dataStructures.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheLists {
    public static void main(String[] args) {
        List<String> colors = new ArrayList();
        colors.add("Red");
        colors.add("White");
        colors.add("Black");

        System.out.println(colors);
        System.out.println(Arrays.toString(colors.toArray()));
        System.out.println(colors.size());
        System.out.println(colors.containsAll(List.of("Red", "Black")));

        for(String color: colors) {
            System.out.print(color + ", ");
        }
    }
}
