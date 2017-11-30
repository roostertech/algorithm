package net.roostertech.algorithm.array;

import java.util.HashMap;
import java.util.List;

/**
 * Created by pnguyen on 11/29/17.
 https://www.interviewbit.com/problems/n3-repeat-number/
 */
public class N3RepeatNumber {
    public int repeatedNumber(final List<Integer> a) {
        HashMap<Integer, Integer> occurences = new HashMap<>();

        for (Integer num: a) {
            if (occurences.containsKey(num)) {
                occurences.put(num, occurences.get(num) + 1);
            } else {
                occurences.put(num, 1);
            }
        }

        int n3 = a.size() / 3;
        for (Integer num: occurences.keySet()) {
            if (occurences.get(num) > n3) {
                return num;
            }
        }

        return -1;
    }
}
