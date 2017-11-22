package net.roostertech.algorithm.array;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 https://www.interviewbit.com/problems/colorful-number/

 A number can be broken into different contiguous sub-subsequence parts.
 Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different

 N = 23
 2 3 23
 2 -> 2
 3 -> 3
 23 -> 6
 this number is a COLORFUL number since product of every digit of a sub-sequence are different.

 Output : 1
 */
public class ColorfulNumber {
    public int colorful(int a) {
        // first break into digits
        ArrayList<Integer> digits = new ArrayList<>();
        while (a >= 10) {
            int digit = a % 10;
            digits.add(0, digit);
            a = a / 10;
        }
        digits.add(0, a);

        HashSet<Integer> products = new HashSet<>();
        for (int i = 1; i <= digits.size(); i++) {
            for (int j = 0; j < (digits.size() - i + 1); j++) {
                int product = 1;
                for (int k = 0; k < i; k++) {
                    product *=  digits.get(j+k);
                }
                if (products.contains(product)) {
                    return 0;
                }
                products.add(product);
            }
        }

        return 1;
    }
}
