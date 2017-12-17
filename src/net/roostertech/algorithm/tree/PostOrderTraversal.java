package net.roostertech.algorithm.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by pnguyen on 12/15/17.
 */
public class PostOrderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode a) {
        ArrayList<Integer> results = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();

        TreeNode curr = a;

        while (curr != null || !nodeStack.isEmpty()) {

            while (curr !=  null) {
                if (curr.right != null) {
                    nodeStack.push(curr.right);
//                    System.out.println("Push " + curr.right.val);

                }
                nodeStack.push(curr);
//                System.out.println("Push " + curr.val);

                curr = curr.left;
            }

            curr = nodeStack.pop();
            if (curr.right != null && !nodeStack.isEmpty() && curr.right == nodeStack.peek()) {
                TreeNode tmp = nodeStack.pop();
                nodeStack.push(curr);
                curr = tmp;
            } else {
//                System.out.println(curr.val);
                results.add(curr.val);
                curr = null;
            }
        }

        return results;
    }

    @Test
    public void testPostOrderTraversal() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        postorderTraversal(root);
    }
}
