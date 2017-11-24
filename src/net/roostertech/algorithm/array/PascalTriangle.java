package net.roostertech.algorithm.array;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by pnguyen on 11/24/17.
 */
public class PascalTriangle {
    public ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= a; i++) {
            if (i < 2) {
                result.add(1);
            } else {
                for (int j = 0; j < result.size() - 1; j++) {
                    result.set(j, result.get(j) + result.get(j+1));
                }
                result.add(0, 1);
                result.set(result.size() - 1, 1);
            }
        }

        return result;
    }

    @Test
    public void testPalscalTriangle() {
        System.out.println(getRow(0));

        System.out.println(getRow(1));
        System.out.println(getRow(2));

        System.out.println(getRow(3));

        System.out.println(getRow(4));
        System.out.println(getRow(5));

    }
}
