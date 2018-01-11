package net.roostertech.algorithm.bitmanipulation;

import org.junit.Test;

public class ReverseBits {
    public long reverse(long a) {
        long result = 0;
        for (int i = 0; i< 32; i++) {
            if ((a & (long)Math.pow(2, i)) != 0) {
                result |= (long)Math.pow(2, 31 - i);
            }
        }

        return result;
    }

    @Test
    public void testReverse() {
        System.out.println(Long.toBinaryString(reverse(3)));
        System.out.println(Long.toBinaryString(reverse(5)));
    }
}
