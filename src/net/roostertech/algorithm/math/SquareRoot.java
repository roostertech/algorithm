package net.roostertech.algorithm.math;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by pnguyen on 11/20/17.
 *
 * Compute and return the square root of x.
 * If x is not a perfect square, return floor(sqrt(x))
 */
public class SquareRoot {
    public int sqrt(int input) {
        if (input == 0 || input == 1)
            return input;
        long a = 0;
        long b = input;
        while (Math.abs(a - b) > 1) {
            a = (a + b) / 2;
            b = input / a;
        }
        if (a * a > input) {
            return (int) (a - 1);
        }
        return (int) a;
    }

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
