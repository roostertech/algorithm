package net.roostertech.algorithm.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Find the longest incrementing subsequence
 * Example:
 * {2, 4, 3, 2, 4, 5, 1, 7}
 * Longest subsequence would be
 * 2, 3, 4, 5, 7 -> 5
 *
 */
public class LongestSubSeq {
    public int longestSubSeq(int[] input) {
        int[] seqLen = new int[input.length];
        int maxLen = 0;
        for (int i = input.length - 1; i >= 0; i--) {
            int currNum = input[i];
            int len = 1;
            int prevLen = 0;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] > currNum) {
                    currNum = input[j];
                    len++;
                    System.out.println("len " + input[i] + " " + input[j] +" "+  len);

                }

                if (seqLen[j] > prevLen && input[j] > input[i]) {
                    System.out.println("seq len" + input[i] + " " + input[j] +" "+  seqLen[j]);
                    prevLen = seqLen[j];
                }

            }
            prevLen++;

            if (len > prevLen) {

            } else {
                len = prevLen;
            }



            if (maxLen < len) {
                maxLen = len;
            }
            seqLen[i] = len;
        }

        System.out.println(Arrays.toString(seqLen));

        return maxLen;

    }

    @Test
    public void testSeq() {
        Assert.assertEquals(5, longestSubSeq(new int[]{2, 4, 3, 2, 4, 5, 1, 7}));
    }
}
