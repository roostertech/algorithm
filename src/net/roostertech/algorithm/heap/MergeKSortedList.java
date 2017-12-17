package net.roostertech.algorithm.heap;

import net.roostertech.algorithm.linkedlist.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pnguyen on 12/16/17.
 */
public class MergeKSortedList {

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        ListNode head = null;
        ListNode tail = null;

        boolean allNull = false;

        while (!allNull) {
            allNull = true;

            int minVal = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i<a.size(); i++) {
                ListNode node = a.get(i);

                if (node == null) {
                    continue;
                }

                allNull = false;

                if (node.val < minVal) {
                    minVal = node.val;
                    minIndex = i;
                }
            }

            if (minIndex >= 0) {
                ListNode minNode = a.get(minIndex);
                a.set(minIndex, minNode.next);
                minNode.next = null;

                if (head == null) {
                    head = minNode;
                    tail = minNode;
                } else {
                    tail.next = minNode;
                    tail = minNode;
                }
            }
        }

        return head;
    }

    @Test
    public void testMergedLSortedList() {
        ListNode node1 = ListNode.makeList(Arrays.asList(1, 10, 20));
        ListNode node2 = ListNode.makeList(Arrays.asList(4, 11, 13));
        ListNode node3 = ListNode.makeList(Arrays.asList(3, 8, 9));

        //1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
        System.out.println(mergeKLists(new ArrayList<>(Arrays.asList(node1, node2, node3))));
    }
}
