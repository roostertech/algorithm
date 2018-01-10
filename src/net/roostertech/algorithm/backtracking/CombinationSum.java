package net.roostertech.algorithm.backtracking;

import org.junit.Test;

import java.util.*;

public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        // A is sorted
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        ArrayList<Integer> combo = new ArrayList<>();

        Set<Integer> dedup = new HashSet<>(A);
        ArrayList<Integer> sorted = new ArrayList<>(dedup);

        Collections.sort(sorted);
        // remove duplicate
        for (int i = 0; i < sorted.size(); i++) {
            combination(results, combo, 0, i, sorted, B);
        }

        return results;
    }

    void combination(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> combo, int sum, int index, ArrayList<Integer> candidates, int target) {
        if (sum > target) {
            return;
        }


        // first fill out with current index

        int curr = candidates.get(index);
        int added = 0;
        while (sum + curr <= target) {
            combo.add(curr);
            sum += curr;
            added ++;
        }

        //back track
        for (int j = 0; j < added; j++) {

            if (sum == target) {
                results.add(new ArrayList<>(combo));
            } else {
                for (int i = index + 1; i < candidates.size(); i++) {
                    combination(results, combo, sum, i, candidates, target);
                }
            }

            combo.remove(combo.size() -1);
            sum -= curr;
        }
    }

    @Test
    public void testCombination() {
        System.out.println(combinationSum(new ArrayList<>(Arrays.asList(2, 3, 6, 7)), 7));
        System.out.println(combinationSum(new ArrayList<>(Arrays.asList(8, 10, 6,11, 1, 16,8)), 28));

    }
}
