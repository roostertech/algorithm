package net.roostertech.algorithm.math;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by pnguyen on 11/21/17.
 Implement pow(A, B) % C.

 In other words, given A, B and C,
 find (AB)%C.

 Input : A = 2, B = 3, C = 3
 Return : 2
 2^3 % 3 = 8 % 3 = 2

 (a * b) % m = ((a % m) * (b % m)) % m
 Note Math.floormod is different than java % (remainder(
 */
public class ModularExponentiation {
    public int mod(int a, int b, int c) {
        if (a == 0) {
            return 0;
        }

        if (b == 0) {
            return 1;
        }

        long y;
        if (b % 2 == 0) {
            // even
            y = mod(a, b / 2, c);
            y = (y * y) % c;
        } else {
            // odd
            y = a % c;
            y = (y  * mod(a, b - 1, c)) % c;
        }
        return (int) ((y + c) % c);
    }

    public int modIterative(int b, int e, int m) {
        int c = 1;
        for (int i = 0; i < e; i++) {
            c = (c * b) % m;
        }

        return c;
    }

    @Test
    public void testModuleExponentiation() {
        Assert.assertEquals(445, mod(4, 13, 497));
        Assert.assertEquals(445, modIterative(4, 13, 497));
    }

    @Test
    public void modularExponentiation() {
        Assert.assertEquals(2, mod(2, 3, 3));

        Assert.assertEquals(2, (int) (Math.floorMod((int) Math.pow(2, 5),30)));
//        Assert.assertEquals(2, (int) (Math.pow(2, 5) % 30));
        Assert.assertEquals(2, mod(2, 5, 30));

        Assert.assertEquals(19, (int) (Math.floorMod((int) Math.pow(-1, 1),20)));
//        Assert.assertEquals(-1, (int) (Math.pow(-1, 1) % 20));
        Assert.assertEquals(19, mod(-1, 1, 20));

        Assert.assertEquals(6, mod(5, 3, 7));
        Assert.assertEquals(4, mod(5, 2, 7));
        Assert.assertEquals(0, mod(0, 0, 1));

    }
}
