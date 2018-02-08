package net.roostertech.algorithm.tree;

import org.junit.Test;

public class ConvertToSumTree {
    // https://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/

    int toSumTree(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // leaf node
        if (node.left == null && node.right == null) {
            int val = node.val;
            node.val = 0;
            return val;
        }

        int sum = toSumTree(node.left) + toSumTree(node.right);
        int val = node.val;

        node.val = sum;
        return node.val + val;
    }

    @Test
    public void testSumTree() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);

        root.right = new TreeNode(6);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);

        toSumTree(root);
        TreeNode.printInorder(root);
    }
}
