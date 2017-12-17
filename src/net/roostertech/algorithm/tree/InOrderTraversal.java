package net.roostertech.algorithm.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by pnguyen on 12/15/17.
 */
public class InOrderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode a) {
        ArrayList<Integer> results = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode curr;
        curr = a;

        while(curr != null || !nodeStack.isEmpty()) {
            while (curr != null) {
                nodeStack.push(curr);
                curr = curr.left;
            }

            // ran out of left node
            curr = nodeStack.pop();
//            System.out.println(curr.val);
            results.add(curr.val);
            curr = curr.right;
        }

        return results;
    }

    @Test
    public void testInOrderTraversal() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        inorderTraversal(root);
    }
}
