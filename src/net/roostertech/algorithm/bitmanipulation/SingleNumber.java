package net.roostertech.algorithm.bitmanipulation;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SingleNumber {
    public int singleNumber(final List<Integer> A) {
        int ones = 0;
        int twos = 0;
        int common_bit_mask;
        // Let us take the example of {3, 3, 2, 3} to understand this
        for(int i =0; i < A.size(); i++){
            // bits that are both in ones and new number
            twos = twos | (ones & A.get(i));

            // bits that appeared odd number of times
            ones = ones ^ A.get(i);

            // bits that appeared 3 times
            common_bit_mask = ~(ones & twos);

            // remove bits that appeared 3 times
            ones &= common_bit_mask;
            twos &= common_bit_mask;
        }
        return ones;
    }

    @Test
    public void testSingleNumber() {
        singleNumber(Arrays.asList(3,3,2,3));
    }
}
