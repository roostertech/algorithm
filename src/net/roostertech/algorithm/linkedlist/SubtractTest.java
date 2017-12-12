package net.roostertech.algorithm.linkedlist;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by pnguyen on 11/20/17.
 */

public class SubtractTest {
    Subtract alg;
    @Before
    public void setup() {
        alg = new Subtract();
    }

    @Test
    public void singleItem() {
        ListNode input = ListNode.makeList(Arrays.asList(1));
        ListNode result = alg.subtract(input);
        System.out.println(result);
    }
    @Test
    public void shortList() {
        ListNode input = ListNode.makeList(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        ListNode result = alg.subtract(input);
        System.out.println(result);
    }

    @Test
    public void oddItemList() {
        ListNode input = ListNode.makeList(Arrays.asList(1,2,3,4,5,6,7));
        ListNode result = alg.subtract(input);
        System.out.println(result);
    }
}
