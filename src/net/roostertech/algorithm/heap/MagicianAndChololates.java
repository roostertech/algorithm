package net.roostertech.algorithm.heap;

import org.junit.Test;

import java.util.*;

/**
 * Created by pnguyen on 12/16/17.
 */
public class MagicianAndChololates {
    public int nchoc(int A, ArrayList<Integer> B) {
        int MOD = (int)Math.pow(10, 9) + 7;

        PriorityQueue<Integer> bags = new PriorityQueue<>(B.size(),
                (Integer v1, Integer v2) ->  v1 > v2 ? -1 : v1 < v2 ? +1 : 0
        );

        for (Integer i : B) {
            bags.add(i);
        }

        int total = 0;
        while (!bags.isEmpty() && A > 0) {
            Integer chololate = bags.remove();
            total = (total + (chololate % MOD)) % MOD;
            bags.add(chololate / 2);
            System.out.println(A + " " + chololate + " " + total);
            A--;
        }

        System.out.println(total);
        return total;
    }

    @Test
    public void testCholo() {
//        nchoc(3, new ArrayList<>(Arrays.asList(6, 5)));
        //284628164
        nchoc(10, new ArrayList<>(Arrays.asList(2147483647, 2000000014, 2147483647)));
    }
}
