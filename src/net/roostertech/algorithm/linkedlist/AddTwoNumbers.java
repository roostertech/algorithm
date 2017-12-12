package net.roostertech.algorithm.linkedlist;

/**
 * Created by pnguyen on 12/7/17.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode a, ListNode b) {

        int carryOver = 0;
        ListNode result = null, tail = null;

        while (a != null || b != null) {
            int addition = ((a != null) ? a.val : 0) + ((b != null) ? b.val : 0) + carryOver;

            ListNode newNode = new ListNode(addition % 10);
            carryOver = addition / 10;

            if (tail != null) {
                tail.next = newNode;
                tail = newNode;
            } else {
                tail = newNode;
                result = newNode;
            }


            if (a != null) {
                a = a.next;
            }
            if (b != null) {
                b = b.next;
            }
        }

        if (carryOver > 0) {
            ListNode newNode = new ListNode(carryOver);
            tail.next = newNode;

        }
        return result;
    }
}
