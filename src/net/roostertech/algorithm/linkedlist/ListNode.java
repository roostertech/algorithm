package net.roostertech.algorithm.linkedlist;

import java.util.List;

/**
 * Created by pnguyen on 11/20/17.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            sb.append(node.val + " -> ");
            node = node.next;
        }
        return sb.toString();
    }

    public static ListNode makeList(List<Integer> data) {
        ListNode head = null;
        ListNode tail = null;
        for (int value: data) {
            ListNode node = new ListNode(value);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        return head;
    }

}
