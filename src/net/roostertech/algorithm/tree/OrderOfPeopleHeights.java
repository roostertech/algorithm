package net.roostertech.algorithm.tree;

import org.junit.Test;

import java.util.*;

/**
 * Created by pnguyen on 12/11/17.
 */
public class OrderOfPeopleHeights {
    public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {


        // create a map of heights and number of people in front
        Map<Integer, Integer> heightMap = new HashMap<>();
        for (int i = 0; i < heights.size(); i++) {
            heightMap.put(heights.get(i), infronts.get(i));
        }

        // sort height for placement
        ArrayList<Integer> sortedHeights = new ArrayList<>(heights);
        Collections.sort(sortedHeights);

        Integer[] order = new Integer[heights.size()];
        for (int i = 0; i < sortedHeights.size(); i++) {
            int height = sortedHeights.get(i);
            place(order, height, heightMap.get(height));
        }

        return new ArrayList<Integer>(Arrays.asList(order));
    }

    private void place(Integer[] order, int height, int infront) {
        int cnt = -1;
        for (int i = 0; i < order.length; i++) {
            // we need to find this many empty spots before we can place person
            if (order[i] == null) {
                cnt++;
            }

            if (cnt == infront) {
                order[i] = height;
                return;
            }
        }
    }

    @Test
    public void testOrdering() {
        System.out.println(order(new ArrayList<>(Arrays.asList(5, 3, 2, 6, 1, 4)),
                new ArrayList<>(Arrays.asList(0, 1, 2, 0, 3, 2))));
    }

}
