package net.roostertech.algorithm.array;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
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

    @Test
    public void pairSum() {
        PairSum alg = new PairSum();

        Assert.assertTrue(alg.findSum(new ArrayList<>(Arrays.asList(1,2,3,4,5)), 3));
        Assert.assertTrue(alg.findSum(new ArrayList<>(Arrays.asList(1,2,3,4,5)), 5));
        Assert.assertTrue(alg.findSum(new ArrayList<>(Arrays.asList(1,2,3,4,5)), 4));
        Assert.assertFalse(alg.findSum(new ArrayList<>(Arrays.asList(1,2,3,4,5)), 10));
        Assert.assertFalse(alg.findSum(new ArrayList<>(Arrays.asList(1,2,3,4,5)), 1));
        Assert.assertFalse(alg.findSum(new ArrayList<>(Arrays.asList(1,2,3,4,5)), 2));
        Assert.assertFalse(alg.findSum(new ArrayList<>(), 1));
        Assert.assertFalse(alg.findSum(new ArrayList<>(Arrays.asList(2)), 1));
    }
}
