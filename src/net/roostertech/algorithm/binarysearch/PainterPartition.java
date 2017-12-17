package net.roostertech.algorithm.binarysearch;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by pnguyen on 12/13/17.
 */
public class PainterPartition {


    public boolean isPossible(int painterCount, int paintRate, ArrayList<Integer> boardLength, long time) {
        int n = boardLength.size();
        int index = 0;

        // loop till we run out of board or out of painter
        for(int i = 0; i < painterCount && index < n; i++) {
            long total = 0;

            // calculate see how many board a painter can paint before time run out
            while(total < time && index  < n) {
                total += (1L * boardLength.get(index) * paintRate);
                if(total > time) {
                    // if time ran out partially through the board, don't count it
                    break;
                }
                index++;
            }
        }
        return (index == n);
    }

    public int paint(int a, int b, ArrayList<Integer> c) {
        long high = Long.MAX_VALUE;

        // binary search for min time
        long result = Long.MAX_VALUE;
        long low = 0;
        long mid = 0;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (isPossible(a, b, c, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int)(result % 10000003);
    }

    @Test
    public void testPaint() {
        Assert.assertEquals(50, paint(2, 5, new ArrayList<>(Arrays.asList(1, 10))));
        Assert.assertEquals(9400003, paint(1, 1000000, new ArrayList<>(Arrays.asList(1000000, 1000000))));

    }
}
