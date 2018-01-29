package net.roostertech.algorithm.graph;

import net.roostertech.algorithm.linkedlist.ListNode;
import net.roostertech.algorithm.tree.TreeNode;

//https://www.interviewbit.com/problems/convert-sorted-list-to-binary-search-tree/
//https://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/

public class SortedList2BinaryTree {

    ListNode curr;
    public TreeNode sortedListToBST(ListNode a) {

        ListNode temp = a;
        int cnt = 0;

        while (temp != null) {
            temp = temp.next;
            cnt ++;
        }

        curr = a;

        TreeNode root = convert(cnt);
        return root;
    }

    TreeNode convert(int size) {
        if (size <= 0) {
            return null;
        }

        TreeNode left = convert(size / 2);

        TreeNode root = new TreeNode(curr.val);
        root.left = left;

        curr = curr.next;

        root.right = convert(size - size / 2 -1);
        return root;
    }


}
