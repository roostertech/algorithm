package net.roostertech.algorithm.array;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by pnguyen on 11/20/17.
 */
public class PairSumTest {
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
