package net.roostertech.algorithm.greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MajorityElement {
    public int majorityElement(final List<Integer> input) {
        if (input.size() == 1) {
            return input.get(0);
        }

        HashMap<Integer, Integer> occurence = new HashMap<>();

        int majority = input.size()/2;

        for (int i = 0; i < input.size(); i++) {
            int num = input.get(i);
            if (occurence.containsKey(num)) {
                int prevCnt = occurence.get(num);
                if (prevCnt + 1 > majority) {
                    return num;
                }
                occurence.put(num, prevCnt + 1);
            } else {
                occurence.put(num, 1);
            }
        }
        return -1;
    }


    @Test
    public void testMajority() {
        Assert.assertEquals(2, majorityElement(Arrays.asList(2, 1, 2)));
        Assert.assertEquals(2, majorityElement(Arrays.asList( 2, 2, 1, 1, 1)));

    }
}
