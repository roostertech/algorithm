package net.roostertech.algorithm.array;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pnguyen on 11/23/17.
 */
public class KthSmallestTest {
    @Test
    public void heapMethod() {
       List<Integer> data = Arrays.asList(2, 1, 4, 3, 2);


        KthSmallest alg = new KthSmallest();
        Assert.assertEquals(1, alg.kthsmallest(data, 1));
        Assert.assertEquals(2, alg.kthsmallest(data, 2));
        Assert.assertEquals(2, alg.kthsmallest(data, 3));
        Assert.assertEquals(3, alg.kthsmallest(data, 4));

    }
}
