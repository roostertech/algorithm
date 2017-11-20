package net.roostertech.algorithm.binarysearch;

import java.util.List;

/**
 * Created by pnguyen on 11/20/17.

 Given a sorted array of integers, find the number of occurrences of a given target value.
 Your algorithm’s runtime complexity must be in the order of O(log n).
 If the target is not found in the array, return 0

 **Example : **
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return 2.

 */
public class CountOccurrence {
    private int binarySearch(final List<Integer> a, int value, boolean findFirst) {
        int high = a.size() - 1;
        int low = 0;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = a.get(mid);
            if (midValue == value) {
                result = mid;
                if (findFirst) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (midValue < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public int findCount(final List<Integer> a, int b) {
        int low = binarySearch(a, b, true);
        if (low < 0) {
            return 0;
        }
        int high = binarySearch(a, b, false);
        return high - low + 1;
    }
}
