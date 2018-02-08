package net.roostertech.algorithm.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

//https://www.interviewbit.com/problems/longest-increasing-subsequence/

public class LongestIncreasingSubsequence {
    public int lis(final List<Integer> A) {
        int entryCnt = A.size();
        int[] seqLen = new int[entryCnt];
        int maxLen = 0;
        for (int i = entryCnt - 1; i >= 0; i--) {
            int currNum = A.get(i);
            int len = 1; // len from one pass from current index
            int prevLen = 0; // max subsequent len from previously calculated options
            for (int secondIndex = i + 1; secondIndex < entryCnt; secondIndex++) {
                if (A.get(secondIndex) > currNum) {
                    currNum =  A.get(secondIndex);
                    len++;
//                    System.out.println("len " + A.get(i) + " " + A.get(secondIndex) +" "+  len);

                }

                if (seqLen[secondIndex] > prevLen && A.get(secondIndex) > A.get(i)) {
//                    System.out.println("seq len" + A.get(i) + " " + A.get(secondIndex) +" "+  seqLen[secondIndex]);
                    prevLen = seqLen[secondIndex];
                }

            }
            prevLen++;

            // pick whichever is larger
            if (prevLen > len) {
                len = prevLen;
            }

            if (maxLen < len) {
                maxLen = len;
            }

            seqLen[i] = len;
        }

//        System.out.println(Arrays.toString(seqLen));
        return maxLen;
    }

    public int lisv2(final List<Integer> input) {
        int[] lis = new int[input.size()];

        // Base case, we have LIS of at least 1 from any index
        Arrays.fill(lis, 1);

        // Calculate the LIS at each index
        for (int i = 0; i < input.size(); i++) {
            int maxLis;
            for (int j = 0; j <= i; j++) {
                if (input.get(j) < input.get(i) && lis[i] < (lis[j] + 1)) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int maxLis = 0;
        for (int i = 0; i < input.size(); i++) {
            maxLis = Math.max(maxLis, lis[i]);
        }

        return maxLis;
    }
    @Test
    public void testLis() {
        Assert.assertEquals(6, lis(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)));
        Assert.assertEquals(6, lisv2(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)));
    }
}
