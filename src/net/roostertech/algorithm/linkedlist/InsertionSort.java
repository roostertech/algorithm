package net.roostertech.algorithm.linkedlist;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by pnguyen on 12/4/17.
 */
public class InsertionSort {

    public ListNode insertionSortList(ListNode a) {
        if (a == null || a.next == null) {
            return a;
        }

        ListNode itor = a;
        int cnt = 0;
        while (itor != null) {
            cnt++;
            itor = itor.next;
        }

        ListNode[] array = new ListNode[cnt];

        itor = a;
        int index = 0;
        while (itor != null) {
            array[index] = itor;
            itor = itor.next;
            index++;
        }

        for (int i = 0; i < cnt; i++) {
            ListNode node = array[i];
            int val = node.val;

            boolean moved = false;

            int j;
            for (j = i - 1; j>= 0 && array[j].val > val; j--) {
                if (!moved) {
                    array[i - 1].next = node.next;
                    moved = true;
                }
                array[j + 1] = array[j];
            }

            // now move node into place
            if (moved) {
                node.next = array[j + 1];
                array[j+1] = node;
                if (j  >= 0) {
                    array[j].next = node;
                }
            }
        }

        return array[0];
    }


    @Test
    public void testSort() {
        System.out.println(insertionSortList(ListNode.makeList(Arrays.asList(1, 3, 2))));
        System.out.println(insertionSortList(ListNode.makeList(Arrays.asList(5, 10, 7,42,-1,444, 3, 2))));

    }


}
