package net.roostertech.algorithm.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by pnguyen on 12/15/17.
 */
public class PreOrderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode a) {
        ArrayList<Integer> results = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(a);

        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.pop();
//            System.out.println(curr.val);
            results.add(curr.val);
            if (curr.right != null) {
                nodeStack.push(curr.right);
            }
            if (curr.left != null) {
                nodeStack.push(curr.left);
            }
        }

        return results;
    }


    @Test
    public void testPreOrderTraversal() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        preorderTraversal(root);
    }
}
