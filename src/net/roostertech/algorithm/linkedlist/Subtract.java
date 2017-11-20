package net.roostertech.algorithm.linkedlist;

import net.roostertech.algorithm.ListNode;

/**
 *
 Given a singly linked list, modify the value of first half nodes such that :

 1st node’s new value = the last node’s value - first node’s current value
 2nd node’s new value = the second last node’s value - 2nd node’s current value,
 and so on …
 NOTE :
 If the length L of linked list is odd, then the first half implies at first floor(L/2) nodes. So, if L = 5, the first half refers to first 2 nodes.
 If the length L of linked list is even, then the first half implies at first L/2 nodes. So, if L = 4, the first half refers to first 2 nodes.

 Example :
 Given linked list 1 -> 2 -> 3 -> 4 -> 5,
 You should return 4 -> 2 -> 3 -> 4 -> 5
 as

 for first node, 5 - 1 = 4
 for second node, 4 - 2 = 2

 */
public class Subtract {
    public ListNode subtract(ListNode a) {
        if (a == null) {
            return null;
        }
        int length = 0;

        ListNode itor = a;
        while (itor != null) {
            length++;
            itor = itor.next;
        }

        if (length < 2) {
            return a;
        }

        int half = length / 2;


        itor = a;
        for (int i = 0; i < half; i++) {
            itor = itor.next;
        }

        ListNode halfStart = itor;
        // reverse second half

        ListNode tmp = null;
        ListNode prev = null;
        itor = halfStart;

        while (itor != null) {
            // System.out.println("re " + itor.val);

            tmp = itor.next;
            itor.next = prev;
            prev = itor;
            itor = tmp;
        }

        ListNode end = prev;
        ListNode itorSecondHalf = end;
        itor = a;

        for (int i = 0; i < half; i++) {
            // System.out.println("i " + i + " " + itor + " " + itorSecondHalf.val);

            itor.val = itorSecondHalf.val - itor.val;
            itor = itor.next;
            itorSecondHalf = itorSecondHalf.next;
        }

        // reverse back
        itorSecondHalf = end;
        prev = null;
        while (itorSecondHalf != null) {
            tmp = itorSecondHalf.next;
            itorSecondHalf.next = prev;
            prev = itorSecondHalf;
            itorSecondHalf = tmp;
        }

        return a;
    }
}
