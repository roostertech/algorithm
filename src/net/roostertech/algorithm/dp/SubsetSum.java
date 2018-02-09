package net.roostertech.algorithm.dp;

import org.junit.Assert;
import org.junit.Test;

public class SubsetSum {

    // The answer at each location will either be whether to include that element in the sum or not
    // isSubsetSum(input, size, sum) = isSubsetSum(input, size - 1, sum) || isSubsetSum(input, size - 1, sum - input[size -1])

    public boolean isSubsetSum(int input[], int sum) {

        // DP based on [size, sum]
        boolean dp[][] = new boolean[input.length + 1][sum + 1];

        // if sum = 0, then true for all size
        for (int i = 0; i <= input.length; i++) {
            dp[i][0] = true;
        }

        // if size is 0, and sum is not zero, then false (default value of array)

        // fill out DP
        for (int sumItor = 1; sumItor <= sum; sumItor++) {
            for (int sizeItor = 1; sizeItor <= input.length; sizeItor++) {
                // If the sum is smaller than the last element, only one choice is to skip it
                if (sumItor >= input[sizeItor - 1]) {
                    dp[sizeItor][sumItor] = dp[sizeItor - 1][sumItor] || dp[sizeItor - 1][sumItor - input[sizeItor - 1]];
                } else {
                    dp[sizeItor][sumItor] = dp[sizeItor - 1][sumItor];
                }
            }
        }

        return dp[input.length][sum];
    }

    @Test
    public void testSubsetSum() {
        Assert.assertEquals(true, isSubsetSum(new int[]{3, 34, 4, 12, 5, 2}, 9));
        Assert.assertEquals(false, isSubsetSum(new int[]{3, 34, 4, 12, 3, 2}, 1));

    }
}
