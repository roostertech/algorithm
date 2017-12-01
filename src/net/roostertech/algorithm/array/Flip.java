package net.roostertech.algorithm.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by pnguyen on 12/1/17.
 https://www.interviewbit.com/problems/flip/
 */
public class Flip {
    public ArrayList<Integer> flip(String A) {
        ArrayList<Integer> res = new ArrayList<>();

        if (A.length() == 1) {
            return res;
        }

        int[] binary = new int[A.length()];

        for (int i = 0; i < A.length(); i++) {
            binary[i] = A.charAt(i) - '0';
        }

        int ones = 0;
        int highestOnes = 0;

        System.out.println("in "+ Arrays.toString(binary));
        // find the first 0
        int left = -1, right = -1, maybeLeft = -1, maybeHigher = -1;
        for (int i = 0; i < binary.length; i++) {
            if (binary[i] == 0) {
                if (left < 0 ) {
                    left = i + 1;
                    right = i + 1;
                    ones = 1;
                    highestOnes = 1;
                    continue;
                } else if (ones < 0) {
                    maybeLeft = i + 1;
                    maybeHigher = 1;
                    ones = 1;
                } else {
                    ones++;
                    if (ones > highestOnes) {
                        if (maybeLeft > 0) {
                            left = maybeLeft;
                            maybeLeft = -1;
                        }
                        right = i + 1;
                        highestOnes = ones;
                    }
                }
            } else if (binary[i] == 1) {
                if (left > 0) {
                    ones--;
                }
            }
        }

        // no 0? all done
        if (left < 0) {
            System.out.println(res);
            return res;
        }

        if (right < 0) {
            right = binary.length;
        }
        res.add(left);
        res.add(right);

        System.out.println(res);
        return res;
    };

    @Test
    public void testFlip() {
//        flip("101");
        flip("010");
        flip("000");
        flip("111");
        flip("1110");
        flip("1101010001");
        flip("100101101");
        flip("0111000100010");
        flip("0011101");
    }
}
