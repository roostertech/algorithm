package net.roostertech.algorithm.linkedlist;

import org.junit.Test;

/**
 * Created by pnguyen on 12/7/17.
 */
public class CycleDetection {
    public ListNode detectCycle(ListNode a) {
        if (a == null || a.next == null) {
            return null;
        }
        ListNode slow = a.next;
        ListNode fast = slow == null? null : slow.next;

        boolean hasLoop = false;
        while (slow != null && fast != null) {
            if (slow == fast) {
                hasLoop = true;
                break;
            }
            slow = slow.next;
            // move 2
            fast = fast.next;
            fast = fast == null? null: fast.next;
        }

//        System.out.println(hasLoop);
//        System.out.println(cntToLoop);

        if (!hasLoop) {
            return null;
        }

        slow = a;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        // bad?
        return slow;
    }

    @Test
    public void testDetectCycle() {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = head;

        System.out.println("loop is at " + detectCycle(head).val);
    }
}
