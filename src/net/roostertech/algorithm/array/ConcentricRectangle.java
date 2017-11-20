package net.roostertech.algorithm.array;

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
}
