package net.roostertech.algorithm.tree;

/**
 * Created by pnguyen on 12/11/17.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode clone(TreeNode node) {
        TreeNode newNode = new TreeNode(node.val);

        if (node.left != null) {
            newNode.left = clone(node.left);
        }

        if (node.right != null) {
            newNode.right = clone(node.right);
        }

        return newNode;
    }

    public static boolean compare(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null && B != null) {
            return false;
        }

        if (A != null && B == null) {
            return false;
        }

        return A.val == B.val && compare(A.left, B.left) && compare(A.right, B.right);
    }
}
