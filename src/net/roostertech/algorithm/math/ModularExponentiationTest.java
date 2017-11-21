package net.roostertech.algorithm.math;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by pnguyen on 11/21/17.
 */
public class ModularExponentiationTest {
    @Test
    public void modularExponentiation() {
        ModularExponentiation alg = new ModularExponentiation();
        Assert.assertEquals(2, alg.mod(2, 3, 3));

        Assert.assertEquals(2, (int) (Math.floorMod((int) Math.pow(2, 5),30)));
//        Assert.assertEquals(2, (int) (Math.pow(2, 5) % 30));
        Assert.assertEquals(2, alg.mod(2, 5, 30));

        Assert.assertEquals(19, (int) (Math.floorMod((int) Math.pow(-1, 1),20)));
//        Assert.assertEquals(-1, (int) (Math.pow(-1, 1) % 20));
        Assert.assertEquals(19, alg.mod(-1, 1, 20));

        Assert.assertEquals(6, alg.mod(5, 3, 7));
        Assert.assertEquals(4, alg.mod(5, 2, 7));
        Assert.assertEquals(0, alg.mod(0, 0, 1));

    }
}
