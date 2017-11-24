package net.roostertech.algorithm.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by pnguyen on 11/24/17.
 https://www.interviewbit.com/problems/add-one-to-number/
 
 */
public class AddOne {
    public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        int add = 1;
        for (int i = a.size()-1; i >= 0; i--) {
            if (add == 0) {
                break;
            } else {
                if (a.get(i) == 9) {
                    // carry over
                    a.set(i, 0);
                } else {
                    a.set(i, a.get(i) +1);
                    add = 0;
                }
            }
        }
        if (add == 1) {
            a.add(0, 1);
        }

        while (a.get(0) == 0) {
            a.remove(0);
        }

        System.out.print(a);
        return a;
    }

    @Test
    public void testAddOne() {
        plusOne(new ArrayList<Integer>(Arrays.asList(0, 0, 4, 4, 6, 0, 9, 6, 5, 1)));
    }
}
