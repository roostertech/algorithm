package net.roostertech.algorithm.linkedlist;

import net.roostertech.algorithm.ListNode;

/**
 * Created by pnguyen on 12/8/17.
 */
public class RemoveNode {
    public ListNode removeNthFromEnd(ListNode a, int b) {
        if (a == null) {
            return null;
        }
        if (b == 0) {
            b = 1;
        }
        ListNode itor = a;
        int size = 0;
        while (itor != null) {
            itor = itor.next;
            size++;
        }

        if (b > size) {
            ListNode nodeToRemove = a;
            return a.next;
        }

        // size 1
        // b = 1

        int nodeIndex = size - b;
        ListNode prev = null;
        itor = a;

        while (nodeIndex > 0) {
            prev = itor;
            itor = itor.next;
            nodeIndex--;
        }

        // removing last node
        if (prev == null) {
            return itor.next;
        }

        prev.next = itor.next;
        return a;
    }
}
