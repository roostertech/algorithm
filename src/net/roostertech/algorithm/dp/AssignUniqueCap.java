package net.roostertech.algorithm.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * There 100 different types of caps each having a unique id from 1 to 100.
 * Also, there ‘n’ persons each having a collection of variable number of caps.
 * One day all of these persons decide to go in a party wearing a cap but to look
 * unique they decided that none them will wear the same type of cap. So, count
 * the total number of arrangements or ways such that none of them is wearing same type of cap.
 * Constraints: 1 <= n <= 10
 */
// https://www.geeksforgeeks.org/bitmasking-and-dynamic-programming-set-1-count-ways-to-assign-unique-cap-to-every-person

public class AssignUniqueCap {

    // DP of mask and hat index
    int dp[][] = new int[1025][101];

    // Array of persons with their hats
    ArrayList<ArrayList<Integer>> capList = new ArrayList<>();

    // This mask indicate that all person are wearing hat
    int allMask;


    /**
     *
     * @param mask Bitmask represent who is wearing a hat
     * @param hatIndex Which hat to attempt to distribute next
     * @return
     */
    int countWays(int mask, int hatIndex) {
        if (mask == allMask) {
            // Everyone is already wearing a hat
            return 1;
        }

        // Finished with all the possible hats
        if (hatIndex > 100) {
            return 0;
        }

        if (dp[mask][hatIndex] != -1) {
            return dp[mask][hatIndex];
        }

        // If this hat was skipped, unassigned
        int ways = countWays(mask, hatIndex + 1);

        // Loop through all person to see if we can distribute hat
        for (int j = 0; j < capList.size(); j++) {
            // If this person does not have this hat, skip
            if (!capList.get(j).contains(hatIndex)) {
                continue;
            }

            // If this person is already wearing a hat
            if ((mask & (1 << j)) != 0) {
                continue;
            }

            // Assign the hat
            ways += countWays(mask | 1 << j, hatIndex +1);
        }
//        System.out.println("Ways " + Integer.toBinaryString(mask) + " " + hatIndex + " " + ways);
        dp[mask][hatIndex] = ways;

        return dp[mask][hatIndex];
    }

    int countWays(ArrayList<ArrayList<Integer>> inputCapList) {
        capList = inputCapList;

        allMask =  (1 << inputCapList.size()) -1;

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return countWays(0, 1);
    }


    @Test
    public void testHats() {
        Assert.assertEquals(4, countWays(new ArrayList<>(
           Arrays.asList(
                   new ArrayList<>(Arrays.asList(5, 100, 1)),
                   new ArrayList<>(Arrays.asList(2)),
                   new ArrayList<>(Arrays.asList(5, 100))
           )
        )));
    }

}
