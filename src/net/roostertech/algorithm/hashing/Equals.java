package net.roostertech.algorithm.hashing;

import junit.framework.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by pnguyen on 12/4/17.
 */
public class Equals {

    class Pair {
        int index1;
        int index2;

        Pair(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }

        public int getIndex1() {
            return index1;
        }

        public int getIndex2() {
            return index2;
        }
    }


    private int compare (ArrayList<Integer> a, ArrayList<Integer> b) {
        // Each has 4 entries
        for (int i = 0; i < 4; i++) {
            if (a.get(i) < b.get(i)) {
                return -1;
            } else if (a.get(i) > b.get(i)) {
                return 1;
            }
        }

        return 0;
    }

    boolean isIntersect(Pair a, Pair b) {
        return a.getIndex1() == b.getIndex1()
                || a.getIndex1() == b.getIndex2()
                || a.getIndex2() == b.getIndex1()
                || a.getIndex2() == b.getIndex2();
    }

    public ArrayList<Integer> equal(ArrayList<Integer> a) {
        HashMap<Integer, Pair> sums = new HashMap<>();
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            HashSet<Integer> localSums = new HashSet<>();
            for (int j = i+1; j < a.size(); j++) {
                int sum = a.get(i) + a.get(j);
                Pair newPair = new Pair(i, j);
                if (localSums.contains(sum)) {
                    // already have this sum with a smaller index
                } else {
                    if (sums.containsKey(sum)) {
                        if (isIntersect(sums.get(sum), newPair)) {
                            continue;
                        }
                        // found our pair
                        ArrayList<Integer> result = new ArrayList<>();
                        Pair firstPair = sums.get(sum);
                        result.add(firstPair.getIndex1());
                        result.add(firstPair.getIndex2());
                        result.add(i);
                        result.add(j);
                        results.add(result);
                    } else {
                        sums.put(sum, newPair);
                        localSums.add(sum);
                    }
                }
            }
        }

        if (results.size() == 0) {
            return new ArrayList<>();
        }

        ArrayList<Integer> smallest = null;
        for (ArrayList<Integer> s : results) {
            if (smallest == null || compare(smallest, s) > 0) {
                smallest = s;
            }
        }

        return smallest;
    }

    @Test
    public void testEqual() {
        Assert.assertEquals(Arrays.asList(0, 2, 3, 5), equal(new ArrayList<>(Arrays.asList(3, 4, 7, 1, 2, 9, 8))));
        Assert.assertEquals(Arrays.asList(0, 1, 2, 3), equal(new ArrayList<>(Arrays.asList( 1, 1, 1, 1, 1))));

    }

}
