package net.roostertech.algorithm.math;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by pnguyen on 11/21/17.
 */
public class UniquePermutationTest {
    @Test
    public void permutationsRecursive() {
        UniquePermutation alg = new UniquePermutation();

//        alg.permute(new ArrayList<>(Arrays.asList(1,2,3)));

        ArrayList<ArrayList<Integer>> result = alg.permute(new ArrayList<>(Arrays.asList(1,1,2)));
        System.out.println(result.size());
        System.out.println(result);
        Assert.assertEquals(3, result.size());
    }
}
