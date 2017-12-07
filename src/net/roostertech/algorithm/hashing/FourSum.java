package net.roostertech.algorithm.hashing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by pnguyen on 12/6/17.
 */
public class FourSum {

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {
        HashSet<ArrayList<Integer>> resultSet = new HashSet<>();
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();

        Collections.sort(a);
        for (int i = 0; i < a.size(); i++) {
            for (int j = i+1; j < a.size(); j++) {
                int left = j + 1;
                int right = a.size() - 1;

                while (left < right) {
                    int sum = a.get(i) + a.get(j) + a.get(left) + a.get(right);

                    if (sum > b) {
                        right --;
                    } else if (sum < b) {
                        left ++;
                    } else if (sum == b) {
                        ArrayList<Integer> quad = new ArrayList<>(Arrays.asList(a.get(i), a.get(j), a.get(left), a.get(right)));
                        if (!resultSet.contains(quad)) {
                            resultSet.add(quad);
                            results.add(quad);
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return results;
    }

    @Test
    public void testFourSum() {
        System.out.println(fourSum(new ArrayList<Integer>(Arrays.asList(1, 0, -1, 0, -2 ,2)), 0));
    }

}
