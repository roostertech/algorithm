package net.roostertech.algorithm.bitmanipulation;

import java.util.ArrayList;
import java.util.Collections;

public class MinXOR {
    public int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);

        int minXOR = Integer.MAX_VALUE;
        for (int i = 0; i < A.size() - 1; i++) {
            int xor = A.get(i) ^ A.get(i+1);
            if (xor < minXOR) {
                minXOR = xor;
            }
        }

        return minXOR;
    }
}
