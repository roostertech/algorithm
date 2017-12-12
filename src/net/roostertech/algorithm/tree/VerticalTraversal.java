package net.roostertech.algorithm.tree;

import java.util.*;

/**
 * Created by pnguyen on 12/11/17.
 */
public class VerticalTraversal {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (A == null) {
            return result;
        }

        // column -> array of node
        Map<Integer, ArrayList<Integer>> verticalMap = new HashMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> columnQueue = new LinkedList<>();

        int min = 0;
        int max = 0;

        // start with root node as column 0
        nodeQueue.add(A);
        columnQueue.add(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int column = columnQueue.poll();
            min = Math.min(min, column);
            max = Math.max(max, column);

            if (!verticalMap.containsKey(column)) {
                verticalMap.put(column, new ArrayList<Integer>());
            }
            verticalMap.get(column).add(node.val);

            if (node.left != null) {
                nodeQueue.add(node.left);
                columnQueue.add(column - 1);
            }

            if (node.right != null) {
                nodeQueue.add(node.right);
                columnQueue.add(column + 1);
            }
        }

        // produce themap
        for (int i = min; i <= max; i++) {
            result.add(verticalMap.get(i));
        }
        return result;
    }
}
