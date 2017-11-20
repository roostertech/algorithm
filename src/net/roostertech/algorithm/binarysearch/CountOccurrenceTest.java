package net.roostertech.algorithm.binarysearch;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by pnguyen on 11/20/17.
 */
public class CountOccurrenceTest {
    @Test
    public void countOccurrence() {
        CountOccurrence alg = new CountOccurrence();

        Assert.assertEquals(0, alg.findCount(Arrays.asList(1,2,3,4,5,5,5,7,8,8,9,10), 6));
        Assert.assertEquals(3, alg.findCount(Arrays.asList(1,2,3,4,5,5,5,7,8,8,9,10), 5));
        Assert.assertEquals(2, alg.findCount(Arrays.asList(1,2,3,4,5,5,5,7,8,8,9,10), 8));
        Assert.assertEquals(0, alg.findCount(Arrays.asList(1), 8));

    }
}
