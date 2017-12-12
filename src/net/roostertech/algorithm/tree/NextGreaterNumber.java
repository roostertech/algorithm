package net.roostertech.algorithm.tree;

/**
 * Created by pnguyen on 12/11/17.
 */
public class NextGreaterNumber {
    public TreeNode getSuccessor(TreeNode a, int b) {
        TreeNode result = null;
        while (a != null) {
            int diff = a.val - b;
            if (diff > 0) {
                if (result == null) {
                    result = a;
                } else if (diff < result.val - b) {
                    result = a;
                }
            }

            if (a.val > b) {
                a = a.left;
            } else if (a.val < b){
                a = a.right;
            } else {
                // try go right
                a = a.right;
            }
        }
        return result;
    }
}
