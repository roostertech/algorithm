package net.roostertech.algorithm.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// https://www.interviewbit.com/problems/equal-average-partition/
// input [1 7 15 29 11 9]
// output [9 15] [1 7 11 29]
// sum 72 avg 12
public class EqualAvgPartition {

    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    // Dp memoization will be if partition is possible based on
    //  * current index in input
    //  * current sum
    //  * additional number of element we will add from here

    private boolean[][][] dp;
    private ArrayList<Integer> input;
    private ArrayList<Integer> possibleSetIndex = new ArrayList<>();
    /**
     * Not thread safe
     */
    public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> input) {
        if (input.size() == 0) {
            return result;
        }

        Collections.sort(input);
        this.input = input;

        int sum = 0;
        for (int num : input) {
            sum += num;
        }

        dp = new boolean[input.size()][sum + 1][input.size()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                Arrays.fill(dp[i][j], true);
            }
        }

        /*
        In order for the two sets to have the same avg
        sum1 / size1 = sum2 / size2
        sum1 = sum2 * size1 / size2
        sum = sum1 + sum2
        sum1 = (sum - sum1) * (size1 / (size - size1))

        sum1/size1 = (sum - sum1) / (size - size1)
        ...
        sum1 / size1 = sum / size
         */
        // Try to find a set that have the same avg
        // set can consist of 1 to n - 1 elements
        for (int setSize = 1; setSize < input.size(); setSize ++) {

            // For each set size, we can figure out the necessary sum that it has to meet in order
            if ((sum * setSize) % input.size() != 0) {
                continue;
            }

            int setSum = (sum * setSize) / input.size();

            if (isPartitionPossible(setSum, 0, setSize)) {
                break;
            }
        }
        return generatePartitions();
    }

    /**
     *
     */
    public boolean isPartitionPossible(int targetSum, int currIndex, int addSize) {
        if (addSize == 0) {
            return targetSum == 0;
        }

        // Ran out of element, still have not reached sum
        if (currIndex >= input.size()) {
            return false;
        }

        if (dp[currIndex][targetSum][addSize] == false) {
            return false;
        }

        // Should we add the next element
        if (targetSum >= input.get(currIndex)) {
            possibleSetIndex.add(currIndex);
            if (isPartitionPossible(targetSum - input.get(currIndex), currIndex +1, addSize - 1)) {
                return true;
            }

            //back track
            possibleSetIndex.remove(possibleSetIndex.size()-1);
        }

        // try skipping this element
        if (isPartitionPossible(targetSum, currIndex +1, addSize)) {
            return true;
        }

        dp[currIndex][targetSum][addSize] = false;
        return false;
    }

    private ArrayList<ArrayList<Integer>> generatePartitions() {
        // no solution
        if (possibleSetIndex.size() == 0 || possibleSetIndex.size() == input.size()) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> set1 = new ArrayList<>();
        ArrayList<Integer> set2 = new ArrayList<>();

        // Filter array element into their set
        for (int i = 0; i < input.size(); i++) {
            if (possibleSetIndex.contains(i)) {
                set1.add(input.get(i));
            } else {
                set2.add(input.get(i));
            }
        }

        result.add(set1);
        result.add(set2);
        return result;
    }

    @Test
    public void testPartition() {
        System.out.println(avgset(new ArrayList<>(Arrays.asList(1, 7, 15, 29, 11, 9))));
    }

}
