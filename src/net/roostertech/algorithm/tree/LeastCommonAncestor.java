package net.roostertech.algorithm.tree;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by pnguyen on 12/16/17.
 */
public class LeastCommonAncestor {

    boolean findPath(TreeNode node, int val, ArrayList<Integer> path) {
        if (node == null) {
            return false;
        }

        path.add(node.val);

        if (node.val == val) {
            return true;
        }

        if (node.left != null && findPath(node.left, val, path)) {
            return true;
        }
        if (node.right != null && findPath(node.right, val, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public int lcaSlow(TreeNode a, int val1, int val2) {
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();

        if (!findPath(a, val1, path1) || !findPath(a, val2, path2)) {
            return -1;
        }

        System.out.println(path1);
        System.out.println(path2);

        int searchSize = Math.min(path1.size(), path2.size());
        for (int i = 0; i < searchSize; i++) {
            if (path1.get(i) != path2.get(i)) {
                // diverge at root node
                if (i == 0) {
                    if (path1.get(i) == val1) {
                        return val1;
                    } else
                        return val1;
                } else {
                    return path1.get(i - 1);
                }
            }

        }

        return path1.get(searchSize - 1);
    }

    boolean val1Found = false;
    boolean val2Found = false;

    boolean find(TreeNode node, int val) {
        if (node == null) {
            return false;
        }

        if (node.val == val) {
            return true;
        }

        if (node.left != null && find(node.left, val)) {
            return true;
        }
        if (node.right != null && find(node.right, val)) {
            return true;
        }

        return false;
    }

    TreeNode findLCA(TreeNode node, int val1, int val2) {
        if (node == null) {
            return null;
        }

        if (node.val == val1) {
            val1Found = true;
            return node;
        }

        if (node.val == val2) {
            val2Found = true;
            return node;
        }

        TreeNode leftSearch = findLCA(node.left, val1, val2);
        TreeNode rightSearch = findLCA(node.right, val1, val2);

        // We found path to both value at this node
        if (leftSearch != null && rightSearch != null) {
            return node;
        }

        return leftSearch != null? leftSearch : rightSearch;
    }

    public int lca(TreeNode a, int val1, int val2) {
        val1Found = false;
        val2Found = false;

        TreeNode lcaNode = findLCA(a, val1, val2);
        if (val1Found && val2Found) {
            return lcaNode.val;
        } else if (val1Found && !val2Found) {
            if (find(lcaNode, val2)) {
                return lcaNode.val;
            }
        } else if (!val1Found && val2Found) {
            if (find(lcaNode, val1)) {
                return lcaNode.val;
            }
        }

        return -1;
    }


    @Test
    public void testLca() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(lca(root, 5, 1));
        System.out.println(lca(root, 5, 4));
        System.out.println(lca(root, 5, 10));

    }
}
