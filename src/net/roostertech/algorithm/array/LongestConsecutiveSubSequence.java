package net.roostertech.algorithm.array;

import org.junit.Test;

import java.util.*;

/**
 * https://www.interviewbit.com/problems/longest-consecutive-sequence/
 * https://www.geeksforgeeks.org/longest-consecutive-subsequence/
 */
public class LongestConsecutiveSubSequence {

    public int longestConsecutive(final List<Integer> a) {

        int max = 0;
        HashSet<Integer> numbers = new HashSet<>(a);

        while (!numbers.isEmpty()) {
            int num = numbers.iterator().next();
            numbers.remove(num);
            int len = 1;
            // go forward

            int search = num + 1;
            while (numbers.contains(search)) {
                numbers.remove(search);
                search++;
                len++;
            }

            search = num - 1;
            while (numbers.contains(search)) {
                numbers.remove(search);
                search--;
                len++;
            }

            max = Math.max(max, len);
        }
        return max;
    }

    @Test
    public void testConsecutive() {
        longestConsecutive(Arrays.asList(97, 86, 67, 19, 107, 9, 8, 49, 23, 46, -4, 22, 72, 4, 57, 111, 20, 52, 99, 2, 113, 81, 7, 5, 21, 0, 47, 54, 76, 117, -2, 102, 34, 12, 103, 69, 36, 51, 105, -3, 33, 91, 37, 11, 48, 106, 109, 45, 58, 77, 104, 60, 75, 90, 3, 62, 16, 119, 85, 63, 87, 43, 74, 13, 95, 94, 56, 28, 55, 66, 92, 79, 27, 42, 70));

    }

}
