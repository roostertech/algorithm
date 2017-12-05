package net.roostertech.algorithm.linkedlist;

import net.roostertech.algorithm.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by pnguyen on 12/4/17.
 */
public class Reverse {

    // m, n index from 1
    public ListNode reverseBetween(ListNode a, int m, int n) {
        if (m == n) {
            return a;
        }

        ListNode prevLeft = null, left = null, right, postRight;
        ListNode itor = a, itorPrev = null;
        ListNode head = a;


        for (int i = 1; i <= n; i++) {
            ListNode next = itor.next;
            if (i == m) {
                prevLeft = itorPrev;
                left = itor;
                if (prevLeft != null) {
                    prevLeft.next = null;
                }
            } else if (i == n) {
                postRight = itor.next;

                right = itor;
                right.next = itorPrev;

                if (prevLeft != null) {
                    prevLeft.next = right;
                } else {
                    head = right;
                }

                left.next = postRight;
            } else if (i > m) {
                // swap back
                itor.next = itorPrev;
            }

            itorPrev = itor;
            itor = next;
        }
        return head;
    };

    @Test
    public void testReverse() {
        System.out.println(reverseBetween(ListNode.makeList(Arrays.asList(1, 2, 3, 4, 5)), 2, 4));
        System.out.println(reverseBetween(ListNode.makeList(Arrays.asList(1, 2, 3, 4, 5)), 1, 1));
        System.out.println(reverseBetween(ListNode.makeList(Arrays.asList(1, 2, 3, 4, 5)), 5, 5));
        System.out.println(reverseBetween(ListNode.makeList(Arrays.asList(1, 2, 3, 4, 5)), 1, 5));

        System.out.println(reverseBetween(ListNode.makeList(Arrays.asList(1, 2, 3, 4, 5)), 1, 2));
        System.out.println(reverseBetween(ListNode.makeList(Arrays.asList(1, 2, 3, 4, 5)), 4, 5));



    }
}
