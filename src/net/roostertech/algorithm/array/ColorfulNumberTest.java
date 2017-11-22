package net.roostertech.algorithm.array;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by pnguyen on 11/22/17.
 */
public class ColorfulNumberTest {
    @Test
    public void colorfulNumber() {
        ColorfulNumber alg = new ColorfulNumber();
        Assert.assertEquals(1,alg.colorful(23));
        Assert.assertEquals(1, alg.colorful(3245));

// 102 - 1 0 2 0 0
        Assert.assertEquals(0, alg.colorful(102));

    }
}
