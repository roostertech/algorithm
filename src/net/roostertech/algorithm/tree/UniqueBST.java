package net.roostertech.algorithm.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

//https://www.interviewbit.com/problems/unique-binary-search-trees/
// This is not an optimal solution. Need a better way to check if our new permutation match an existing one
// Possible approach, keep a BFS string representation in hash?

public class UniqueBST {

    ArrayList<TreeNode> results = new ArrayList<>();

    public ArrayList<TreeNode> generateTrees(int a) {

        LinkedList<Integer> nodes = new LinkedList<>();
        // Create set of initial tree starting point
        for (int i = 1; i <= a; i++) {
            nodes.add(i);
        }

        for (int i = 0; i < a; i++) {
            int val = nodes.get(i);
            LinkedList<Integer> remain = new LinkedList<>(nodes);
            remain.remove(i);


            TreeNode root = new TreeNode(val);
//            System.out.println("Root " + val);
            buildTree(root, remain);
        }

        return results;
    }

    void buildTree(TreeNode root, LinkedList<Integer> nodes) {
        if (nodes.size() == 0) {
            // we have used up all our nodes and this is the tree
            for (TreeNode r: results) {
                if (TreeNode.compare(r, root)) {
                    // already have this tree, don't add
                    return;
                }
            }
            results.add(TreeNode.clone(root));
            return;
        }
        for (int i = 0; i < nodes.size(); i++) {
            int val = nodes.get(i);
            LinkedList<Integer> remain = new LinkedList<>(nodes);
            remain.remove(i);

            // Find an insertion point
            TreeNode node = root;
            TreeNode insertPoint = null;
            int min = Integer.MIN_VALUE;
            int max = Integer.MAX_VALUE;
            while (node != null) {
                insertPoint = node;
                if (val > node.val) {
                    if (node.right == null) {
                        if (val < max) {
                            // insert
//                            System.out.println(node.val + " Right -> " + val);
                            TreeNode newNode = new TreeNode(val);
                            node.right = newNode;
                            break;
                        } else {
//                            System.out.println("Invalid BST ->" + val);
                            // can't insert, invalid BST
                            return;
                        }
                    } else {
                        min = node.val;
                        node = node.right;
                    }
                } else if (val < node.val) {
                    if (node.left == null) {
                        if (val > min) {
//                            System.out.println(node.val + " Left -> " + val);
                            TreeNode newNode = new TreeNode(val);
                            node.left = newNode;
                            break;
                        } else {
//                            System.out.println("Invalid BST ->" + val);
                            // can't insert, invalid BST
                            return;
                        }
                    } else {
                        max = node.val;
                        node = node.left;
                    }
                }
                // no equal case as all nodes are unique
            }

            buildTree(root, remain);
            // remove for next permutation
            if (insertPoint.left != null && insertPoint.left.val == val) {
                insertPoint.left = null;
            } else if (insertPoint.right != null && insertPoint.right.val == val) {
                insertPoint.right = null;
            }
        }

    }

    @Test
    public void testGenTree() {
        generateTrees(3);
    }
}
