package net.roostertech.algorithm.math;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by pnguyen on 11/28/17.
 //https://www.interviewbit.com/problems/prime-numbers/
 */
public class FindPrimes {
    public ArrayList<Integer> sieve(int a) {
        int maxIndex = (int) Math.sqrt(a);
        boolean[] tmp = new boolean[a+1];

        for (int i = 0; i <= a; i++) {
            tmp[i] = true;
        }
        tmp[0] = false;
        tmp[1] = false;

        for (int i = 2; i <= maxIndex; i++) {
            if (tmp[i]) {
                for (int j = 2; i*j <= a; j++) {
                    tmp[i*j] = false;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList();

        for (int i = 0; i <= a; i++) {
            if (tmp[i]) {
                result.add(i);
            }
        }
        return  result;
    }

    @Test
    public void testSieve() {
        Assert.assertEquals(Arrays.asList(2, 3, 5, 7), sieve(10));
    }
}
