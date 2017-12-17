package net.roostertech.algorithm.binarysearch;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pnguyen on 12/12/17.
 */
public class ArrayMedian {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int len = a.size() + b.size();
        if (len % 2 == 0) {
            return (findKthSmallest(a, 0, b, 0, len / 2 + 1) +
                    findKthSmallest(a, 0, b, 0, len / 2)) /  2.0;
        } else {
            return (findKthSmallest(a, 0, b, 0, len / 2 + 1));
        }
    }

    public int findKthSmallest(final List<Integer> a, int indexA, final List<Integer> b, int indexB, int k) {

        // check if we already at the edge of either array
        // then the value is in the other array, at kth index
        if (indexA >= a.size()) {
            return b.get(indexB + k - 1);
        }

        if (indexB >= b.size()) {
            return a.get(indexA + k - 1);
        }

        if (k == 1){
            return Math.min(a.get(indexA), b.get(indexB));
        }

        int aCandidate, bCandidate;

        // if A still have enough element to test
        if (indexA + k/2 - 1 < a.size()) {
            aCandidate = a.get(indexA + k/2 -1);
        } else {
            aCandidate = Integer.MAX_VALUE;
        }

        if (indexB + k/2 - 1 < b.size()) {
            bCandidate = b.get(indexB + k/2 -1);

        } else {
            bCandidate = Integer.MAX_VALUE;
        }

        // advance index of array with smaller candidate
        if (aCandidate < bCandidate) {
            return findKthSmallest(a, indexA + k/2, b, indexB, k - k / 2);
        } else {
            return findKthSmallest(a, indexA, b, indexB + k / 2, k - k / 2);
        }
    }

    @Test
    public void testArrayMedian() {
        Assert.assertEquals(3.0, findMedianSortedArrays(Arrays.asList(1, 4, 5), Arrays.asList(2, 3)));
        Assert.assertEquals(-20.0, findMedianSortedArrays(Arrays.asList( -50, -41, -40, -19, 5, 21, 28), Arrays.asList(-50, -21, -10)));

    }
}
