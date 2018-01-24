package net.roostertech.algorithm.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class LargestDistance {
    class Node {
        int label;
        HashSet<Node> neighbors;

        Node(int label) {
            this.label = label;
            neighbors = new HashSet<>();
        }

    }

    public int solve(ArrayList<Integer> A) {
        if (A.size() == 0) {
            return 0;
        }


        HashMap<Integer, Node> nodes = new HashMap<>();

        // build the graph!
        for (int i = 0; i < A.size(); i++) {
            Node node;
            if (nodes.containsKey(i)) {
                node = nodes.get(i);
            } else {
                node = new Node(i);
                nodes.put(i, node);
            }

            int neighbor = A.get(i);
            if (neighbor == -1) {
                continue;
            }

            Node neighborNode;
            if (nodes.containsKey(neighbor)) {
                neighborNode = nodes.get(neighbor);
            } else {
                neighborNode = new Node(neighbor);
                nodes.put(neighbor, neighborNode);
            }

            neighborNode.neighbors.add(node);
            node.neighbors.add(neighborNode);
        }

        // BFS walk
        Node root = nodes.get(0);

        Queue<Node> nodeQueue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();

        nodeQueue.offer(root);
        levels.offer(0);

        int maxLevel = 0;
        Node furthestNode = null;
        HashSet<Node> visited = new HashSet<>();

        while (!nodeQueue.isEmpty()) {
            Node currNode = nodeQueue.poll();
            int currLevel = levels.poll();
            visited.add(currNode);

            if (currLevel >= maxLevel) {
                maxLevel = currLevel;
                furthestNode = currNode;
            }

            for (Node n : currNode.neighbors) {
                if (visited.contains(n)) {
                    continue;
                }
                nodeQueue.offer(n);
                levels.offer(currLevel + 1);
            }
        }


        // second BFS to find furthest point from furthest node
        nodeQueue.offer(furthestNode);
        levels.offer(0);

        maxLevel = 0;
        visited.clear();
        while (!nodeQueue.isEmpty()) {
            Node currNode = nodeQueue.poll();
            int currLevel = levels.poll();
            visited.add(currNode);


            if (currLevel > maxLevel) {
                maxLevel = currLevel;
                furthestNode = currNode;
            }

            for (Node n : currNode.neighbors) {
                if (visited.contains(n)) {
                    continue;
                }
                nodeQueue.offer(n);
                levels.offer(currLevel + 1);
            }
        }

        return maxLevel;


    }


    @Test
    public void testDistance() {
        Assert.assertEquals(0, solve(new ArrayList<>(Arrays.asList(-1))));

        Assert.assertEquals(3, solve(new ArrayList<>(Arrays.asList(-1, 0, 0, 0, 3))));

        Assert.assertEquals(14, solve(new ArrayList<>(Arrays.asList(
                -1, 0, 1, 1, 2, 0, 5, 0, 3, 0,
                0, 2, 3, 1, 12, 14, 0, 5, 9, 6,
                16, 0, 13, 4, 17, 2, 1, 22, 14, 20,
                10, 17, 0, 32, 15, 34, 10, 19, 3, 22,
                29, 2, 36, 16, 15, 37, 38, 27, 31, 12,
                24, 29, 17, 29, 32, 45, 40, 15, 35, 13,
                25, 57, 20, 4, 44, 41, 52, 9, 53, 57, 18,
                5, 44, 29, 30, 9, 29, 30, 8, 57,
                8, 59, 59, 64, 37, 6, 54, 32, 40, 26, 15, 87,
                49, 90, 6, 81, 73, 10, 8, 16))));
    }

}
