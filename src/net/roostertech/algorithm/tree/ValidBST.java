package net.roostertech.algorithm.tree;

/**
 * https://www.interviewbit.com/problems/valid-binary-search-tree/
 */
public class ValidBST {
    public int isValidBST(TreeNode a) {
        return isBST(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static int isBST(TreeNode node, int min, int max) { // 3
        if (node.val <= min || node.val >= max) {
            return 0;
        }

        if (node.left != null && isBST(node.left, min, node.val) == 0) {
            return 0;
        }

        if (node.right != null && isBST(node.right, node.val, max) == 0) {
            return 0;
        }

        return 1;
    }

    /**
     *   11
     *           3
     *        2        4
     *     1    3   -1   -1
     *  -1 -1 -1 -1
     */
}
