package net.roostertech.algorithm.array;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by pnguyen on 11/20/17.
 * Input: UNSORTED array of int, and a sum value
 * Find a pair in the array that sum to input sum value
 * Return true if found, false otherwise
 */
public class PairSum {
    boolean findSum(ArrayList<Integer> data, int sum) {
        HashSet<Integer> complementNeed = new HashSet<>();

        for (int num: data) {
            if (complementNeed.contains(num)) {
                return true;
            }
            complementNeed.add(sum - num);
        }
        return false;
    }
}
