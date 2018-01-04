package net.roostertech.algorithm.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Permute {

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        // starts out empty
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());

        for (int i = 0; i< A.size(); i++) {
            ArrayList<ArrayList<Integer>> current = new ArrayList<>();

            for (ArrayList item : results) {
                for (int j = 0; j < item.size() + 1; j++) {
                    item.add(j, A.get(i));

                    ArrayList<Integer>temp = new ArrayList<>(item);
                    current.add(temp);
                    item.remove(j);
                }
            }
            results =  new ArrayList<>(current);
        }

        return results;
    }

    @Test
    public void testPermute() {
        System.out.println(permute(new ArrayList<>(Arrays.asList(1, 2, 3))));
    }
}
