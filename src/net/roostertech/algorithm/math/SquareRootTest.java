package net.roostertech.algorithm.math;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by pnguyen on 11/20/17.
 */
public class SquareRootTest {
    @Test
    public void squares() {
        SquareRoot alg = new SquareRoot();
        // special cases
        Assert.assertEquals(1, alg.sqrt(1));
        Assert.assertEquals(0, alg.sqrt(0));


        Assert.assertEquals(1, alg.sqrt(2));

        Assert.assertEquals(3, alg.sqrt(9));
        Assert.assertEquals(3, alg.sqrt(10));
        Assert.assertEquals(3, alg.sqrt(11));
        Assert.assertEquals(3, alg.sqrt(12));
        Assert.assertEquals(3, alg.sqrt(13));
        Assert.assertEquals(3, alg.sqrt(14));
        Assert.assertEquals(3, alg.sqrt(15));
        Assert.assertEquals(4, alg.sqrt(16));
    }
}
