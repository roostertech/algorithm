package net.roostertech.algorithm.tree;

/**
 * Created by pnguyen on 12/12/17.
 */
public class CompareTree {
    public int isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b != null) {
            return 0;
        } else if (a != null && b == null) {
            return 0;
        } else if (a == null & b == null) {
            return 1;
        }

        if (a.val != b.val) {
            return 0;
        }

        if (isSameTree(a.left, b.left) == 0) {
            return 0;
        }

        if (isSameTree(a.right, b.right) == 0) {
            return 0;
        }
        return 1;
    }
}
