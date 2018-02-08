package net.roostertech.algorithm.greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GasStation {
    public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
        int size = gas.size();

        for (int i = 0; i < size; i++) {
            int currPos = i;
            int gasTank = gas.get(i);

            // calculate how far till we run out of gas
            while (gasTank >= 0) {
                gasTank -= cost.get(currPos);
                if (gasTank < 0) {
                    break;
                }
                currPos++;
                if (currPos == size) {
                    currPos %= size;
                }
                if (currPos == i) {
                    return i;
                }
                gasTank += gas.get(currPos);
            }

        }

        return -1;
    }

    @Test
    public void testGasStation() {
//        Assert.assertEquals(1, canCompleteCircuit(Arrays.asList(1, 2), Arrays.asList(2, 1)));
        Assert.assertEquals(0, canCompleteCircuit(Arrays.asList(0), Arrays.asList(0)));

    }
}
