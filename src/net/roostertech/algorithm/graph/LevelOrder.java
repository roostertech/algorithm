package net.roostertech.algorithm.graph;

import net.roostertech.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * https://www.interviewbit.com/problems/level-order/
 */

public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        LinkedList<Integer> levels = new LinkedList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        nodes.add(A);
        levels.add(1);

        int currLevel = 0;
        ArrayList<Integer> currList = null;

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove();
            int level = levels.remove();

            if (level != currLevel) {
                currList = new ArrayList<>();
                result.add(currList);
                currLevel = level;
            }

            currList.add(node.val);

            if (node.left != null) {
                nodes.add(node.left);
                levels.add(currLevel + 1);
            }

            if (node.right != null) {
                nodes.add(node.right);
                levels.add(currLevel + 1);
            }
        }

        return result;
    }
}
