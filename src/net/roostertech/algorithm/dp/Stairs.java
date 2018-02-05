package net.roostertech.algorithm.dp;

import org.junit.Assert;
import org.junit.Test;

// https://www.interviewbit.com/problems/stairs/
public class Stairs {
    public int climbStairs(int steps) {
        if (steps == 1) {
            return 1;
        }

        if (steps == 2) {
            return 2;
        }

        int[] paths = new int[steps];

        // 1st step, only 1 choice
        paths[0] = 1;
        // 2nd step, can be reached by 1 + 1 or 2
        paths[1] = 2;

        for (int i = 2; i < steps; i++) {
            paths[i] = paths[i - 1] + paths[i - 2];
        }

        return paths[steps -1];
    }

    @Test
    public void testSteps() {
        Assert.assertEquals(3, climbStairs(3));
    }
}
