package net.roostertech.algorithm.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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

    public ArrayList<ArrayList<Integer>> generate(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (a == 0) {
            return result;
        }

        result.add(new ArrayList<>(Arrays.asList(1)));
        if (a == 1) {
            return result;
        }

        for (int i = 1; i < a; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            ArrayList<Integer> prior = result.get(i - 1);
            row.add(1);

            for (int j = 0; j < i - 1; j++) {
                row.add(prior.get(j)+ prior.get(j+1));
            }

            row.add(1);
            result.add(row);
        }

        return result;
    }

    @Test
    public void testGenerate() {
//        generate(1);
//        generate(2);
//        generate(3);
        generate(4);

    }
}
