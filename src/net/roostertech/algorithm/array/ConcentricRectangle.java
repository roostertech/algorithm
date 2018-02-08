package net.roostertech.algorithm.array;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by pnguyen on 11/20/17.
 * Print concentric rectangular pattern in a 2d matrix.

 A = 4
 4 4 4 4 4 4 4
 4 3 3 3 3 3 4
 4 3 2 2 2 3 4
 4 3 2 1 2 3 4
 4 3 2 2 2 3 4
 4 3 3 3 3 3 4
 4 4 4 4 4 4 4

 A = 3
 3 3 3 3 3
 3 2 2 2 3
 3 2 1 2 3
 3 2 2 2 3
 3 3 3 3 3

 */
public class ConcentricRectangle {
    public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = -a + 1; i < a; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            result.add(row);
            int minValue = Math.abs(i) + 1;

            for (int j = -a + 1; j < a; j++) {
                int value = Math.abs(j) + 1;
                if (value >= minValue) {
                    row.add(value);
                } else {
                    row.add(minValue);
                }
            }
        }
        return result;
    }

    @Test
    public void rects() {
        printRect(prettyPrint(1));
        printRect(prettyPrint(2));
        printRect(prettyPrint(3));
        printRect(prettyPrint(4));
    }

    void printRect(ArrayList<ArrayList<Integer>> rect) {
        for (ArrayList<Integer> row : rect) {
            for (int data : row) {
                System.out.print(data);
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
}
