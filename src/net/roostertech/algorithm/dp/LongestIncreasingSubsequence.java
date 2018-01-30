package net.roostertech.algorithm.dp;

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
}
