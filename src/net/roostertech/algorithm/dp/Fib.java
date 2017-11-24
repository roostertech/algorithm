package net.roostertech.algorithm.dp;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by pnguyen on 11/23/17.
 */
public class Fib {
    static long bottomUpFib(int n) {
        long[] fibs = new long[n+1];
        for (int k = 1; k <= n; k++) {
            if (k <= 2) {
                fibs[k] = 1;
                continue;
            }

            fibs[k] = fibs[k-1] + fibs[k-2];
        }
        return fibs[n];
    };

    @Test
    public void testFib() {
        Assert.assertEquals(1, bottomUpFib(1));
        Assert.assertEquals(1, bottomUpFib(2));
        Assert.assertEquals(2, bottomUpFib(3));
        Assert.assertEquals(55, bottomUpFib(10));
        Assert.assertEquals(6765, bottomUpFib(20));
    }
}
