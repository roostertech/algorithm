package net.roostertech.algorithm.linkedlist;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by pnguyen on 12/8/17.
 */
public class Reorder {
    public ListNode reorderList(ListNode a) {
        if (a == null || a.next == null || a.next.next == null) {
            return a;
        }

        ListNode itor = a;
        int cnt = 0;
        while (itor != null) {
            itor = itor.next;
            cnt++;
        }
//        System.out.println(cnt);

        ListNode[] array = new ListNode[cnt];
        int index = 0;
        itor = a;
        while (itor != null) {
            array[index] = itor;
            itor = itor.next;
            index++;
        }
//        System.out.println(index);

        // cnt 3

        for (int i = 0; i < cnt / 2; i++) { // 0
            System.out.println(i);
            ListNode lastNode = array[cnt - i - 1]; //2
            System.out.println("last" +lastNode.val);
            if (array[i].next == lastNode) {
                break;
            }

            array[cnt - i - 2].next = null; // 1 - > null
            array[i].next = lastNode;  // 0 - > last
            lastNode.next = array[i+1]; // last -> 1
//            System.out.println(a);
        }

        return a;
    }

    @Test
    public void testReorder() {
        //99 -> 3 -> 9 -> 23 -> 87 -> 61 -> 56 -> 38 -> 5 -> 28 -> 88 -> 66 -> 49 -> 84 -> 53 -> 1 -> 2 -> 72 -> 4 -> 51 -> 47 -> 10 -> 68 -> 93 -> 32 -> 40 -> 57 -> 25
        //99 -> 3 -> 9 -> 23 -> 87 -> 61 -> 56 -> 38 -> 5 -> 28 -> 88 -> 66 -> 49 -> 84 -> 53 -> 1 -> 2 -> 72 -> 4 -> 51 -> 47 -> 10 -> 68 -> 93 -> 32 -> 40 -> 57 -> 25 ->
//        System.out.println(reorderList(ListNode.makeList(Arrays.asList(99, 9, 87, 56, 5 ,88, 49, 53, 2, 4, 47, 68, 32, 57, 25, 40, 93, 10, 51, 72, 1, 84, 66, 28, 38, 61, 23, 3))).toString());

        //90 -> 8 -> 94 -> 47 -> 25 -> 61 -> 51 -> 101 -> 45 -> 66 -> 29 -> 88 -> 55 -> 76 -> 63 -> 82 -> 48 -> 46 -> 27 -> 21 -> 72 -> 33 -> 10 -> 85 -> 36 -> 58 -> 68 -> 77 -> 16 -> 30 -> 20 -> 26 -> 31 -> 67 -> 7 -> 14 -> 95 -> 87 -> 70 -> 4 -> 89 -> 44 -> 23 -> 65 -> 22 -> 93 -> 9 -> 54 -> 74 -> 1 -> 71 -> 34 -> 35 -> 79 -> 5 -> 60 -> 80 -> 15 -> 11 -> 24 -> 49 -> 81 -> 92 -> 12 -> 69 -> 98 -> 6 -> 18 -> 37 -> 19 -> 84 -> 52 -> 78 -> 53 -> 28 -> 59 -> 43 -> 75 -> 64 -> 97 -> 96 -> 73 -> 57 -> 13 -> 83 ->
        //90 -> 8 -> 94 -> 47 -> 25 -> 61 -> 51 -> 101 -> 45 -> 66 -> 29 -> 88 -> 55 -> 76 -> 63 -> 82 -> 48 -> 46 -> 27 -> 21 -> 72 -> 33 -> 10 -> 85 -> 36 -> 58 -> 68 -> 77 -> 16 -> 30 -> 20 -> 26 -> 31 -> 67 -> 7 -> 14 -> 95 -> 87 -> 70 -> 4 -> 89 -> 44 -> 23 -> 65 -> 22 -> 93 -> 9 -> 54 -> 74 -> 1 -> 71 -> 34 -> 35 -> 79 -> 5 -> 60 -> 80 -> 15 -> 11 -> 24 -> 49 -> 81 -> 92 -> 12 -> 69 -> 98 -> 6 -> 18 -> 37 -> 19 -> 84 -> 52 -> 78 -> 53 -> 28 -> 59 -> 43 -> 75 -> 64 -> 97 -> 96 -> 73 -> 57 -> 13 -> 83
        System.out.println(reorderList(ListNode.makeList(Arrays.asList(90,94,25,51,45,29,55,63,48,27,72,10,36,68,16,20,31,7,95,70,89,23,22,9,74,71,35,5,80,11,49,92,69,6,37,84,78,28,43,64,96,57,83,13,73,97,75,59,53,52,19,18,98,12,81,24,15,60,79,34,1,54,93,65,44,4,87,14,67,26,30,77,58,85,33,21,46,82,76,88,66,101,61,47,8))).toString());
    }
}
