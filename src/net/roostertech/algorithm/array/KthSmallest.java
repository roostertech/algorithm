package net.roostertech.algorithm.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by pnguyen on 11/23/17.
 *
 https://www.interviewbit.com/problems/kth-smallest-element-in-the-array/
 */
public class KthSmallest {
    public int kthsmallest(final List<Integer> a, int k) {
        // assume k < a.size()

        ArrayList<Integer> smallests = new ArrayList<>();
        smallests.addAll(a.subList(0, k));

        smallests.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });


        for (int i = k; i < a.size(); i++) {
            int num = a.get(i);
            // insert num order
            int low = 0;
            int high = smallests.size() - 1;
            int mid = 0;
            while (low <= high) {
                mid = low + (high - low) / 2;
                int midVal = smallests.get(mid);

                if (midVal == num) {
                    break;
                } else if (midVal > num) {
                    high = mid -1;
                } else {
                    low = mid + 1;
                }
            }

            if (low > mid) {
                smallests.add(mid + 1, num);
            } else if (high < mid) {
                smallests.add(mid, num);
            } else {
                smallests.add(mid, num);
            }

            //pop off highest
            smallests.remove(smallests.size() - 1);
        }
        return smallests.get(smallests.size() -1);
    }
}