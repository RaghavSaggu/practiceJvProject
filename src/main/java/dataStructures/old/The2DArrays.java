package dataStructures.old;

import java.util.Arrays;

public class The2DArrays {
    public static void main(String[] args) {
        char board[][] = new char[][]{
                new char[]{'-', '-', '-'},
                new char[]{'-', '-', '-'},
                new char[]{'-', '-', '-'}
        };
        System.out.println(Arrays.deepToString(board));
        for(char[] row: board) {
            for(char c: row) {
                System.out.print(c + "  ");
            }
            System.out.println();
        }
    }
}
