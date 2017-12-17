package net.roostertech.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pnguyen on 12/12/17.
 */
public class PathSum {
    public int hasPathSum(TreeNode a, int b) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();

        nodeQueue.add(a);
        sumQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int sum = sumQueue.poll();

            if (sum + node.val == b && node.left == null && node.right == null) {
                return 1;
            }

            if (node.left != null) {
                nodeQueue.add(node.left);
                sumQueue.add(sum + node.val);
            }

            if (node.right != null) {
                nodeQueue.add(node.right);
                sumQueue.add(sum + node.val);
            }
        }

        return 0;
    }
}
