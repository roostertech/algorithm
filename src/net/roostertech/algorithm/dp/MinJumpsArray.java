package net.roostertech.algorithm.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MinJumpsArray {
    public int jumpv1(ArrayList<Integer> input) {
        int[] jumpCount = new int[input.size()];
        Arrays.fill(jumpCount, Integer.MAX_VALUE);

        jumpCount[0] = 0;

        for (int i = 0; i < input.size(); i++) {
            int range = input.get(i);
            for (int j = i + 1; j <= i + range && j < input.size(); j++) {
                // Mark all step in range of this node if jumping from here is cheaper
                jumpCount[j] = Math.min(jumpCount[j], jumpCount[i] + 1);
//                System.out.println(i + " " + j + " " + jumpCount[j]);
            }
        }

        return jumpCount[input.size() -1] < 0? -1: jumpCount[input.size() -1];
    }
    public int jump(ArrayList<Integer> input) {
        int stepCount = input.size();
        int maxJumpIndex = 0; // highest step that possibly be jumped to
        int next = 0; // where we jumped to last


        int jumpCount = 0;
        // only run i to size -1 because we do not need to jump from last step
        for (int i = 0; i < stepCount -1 && next < stepCount; i++) {
            maxJumpIndex = Math.max(maxJumpIndex, i + input.get(i));
            if (i == next) {
                if (maxJumpIndex == next) {
                    // can't jump any futher, ran into step of 0?
                    return -1;
                }
                next = maxJumpIndex;
                jumpCount++;
            }

        }

        return jumpCount;
    }

    @Test
    public void testJumpCount() {
        Assert.assertEquals(0, jump(new ArrayList<>(Arrays.asList(0))));
        Assert.assertEquals(2, jump(new ArrayList<>(Arrays.asList(2,3,1,1,4))));
        Assert.assertEquals(-1, jump(new ArrayList<>(Arrays.asList(0, 46, 46, 0, 2, 47, 1, 24, 45, 0, 0, 24, 18, 29, 27, 11, 0, 0, 40, 12, 4, 0, 0, 0, 49, 42, 13, 5, 12, 45, 10, 0, 29, 11, 22, 15, 17, 41, 34, 23, 11, 35, 0, 18, 47, 0, 38, 37, 3, 37, 0, 43, 50, 0, 25, 12, 0, 38, 28, 37, 5, 4, 12, 23, 31, 9, 26, 19, 11, 21, 0, 0, 40, 18, 44, 0, 0, 0, 0, 30, 26, 37, 0, 26, 39, 10, 1, 0, 0, 3, 50, 46, 1, 38, 38, 7, 6, 38, 27, 7, 25, 30, 0, 0, 36, 37, 6, 39, 40, 32, 41, 12, 3, 44, 44, 39, 2, 26, 40, 36, 35, 21, 14, 41, 48, 50, 21, 0, 0, 23, 49, 21, 11, 27, 40, 47, 49))));

    }
}
