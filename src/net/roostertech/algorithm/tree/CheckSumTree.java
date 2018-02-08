package net.roostertech.algorithm.tree;

// https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/

import org.junit.Assert;
import org.junit.Test;

public class CheckSumTree {


    /**
     *
     * @param node
     * @return null if not a sum node, otherwise the sum
     */
    Integer sumNode(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // leaf node
        if (node.left == null && node.right == null) {
            return node.val;
        }

        int expectedSum = 0;

        if (node.left != null) {
            Integer leftSum = sumNode(node.left);
            if (leftSum == null) {
                return null;
            }
            expectedSum += leftSum;
        }

        if (node.right != null) {
            Integer rightSum = sumNode(node.right);
            if (rightSum == null) {
                return null;
            }
            expectedSum += rightSum;
        }

        if (expectedSum == node.val) {
            return expectedSum + node.val;
        }

        return null;
    }

    boolean isSumTree(TreeNode root) {
        return sumNode(root) != null;
    }


    @Test
    public void testSumTree() {
        TreeNode root = new TreeNode(26);

        root.left = new TreeNode(10);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(3);

        Assert.assertEquals(true, isSumTree(root));
    }
}
