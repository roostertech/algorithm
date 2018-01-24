package net.roostertech.algorithm.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class LargestDistance {

    // NOT TIME OPTIMIZED

    public int solve(ArrayList<Integer> A) {
        if (A.size()== 0) {
            return 0;
        }
        HashMap<Integer, UndirectedGraphNode> nodes = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            UndirectedGraphNode node;
            if (nodes.containsKey(i)) {
                node = nodes.get(i);
            } else {
                node = new UndirectedGraphNode(i);
                nodes.put(i, node);
            }

            // root node
            int parent = A.get(i);
            if (parent == -1) {
                continue;
            }

            UndirectedGraphNode parentNode;
            if (nodes.containsKey(parent)) {
                parentNode = nodes.get(parent);
            } else {
                parentNode = new UndirectedGraphNode(parent);
                nodes.put(parent, parentNode);
            }

            parentNode.neighbors.add(node);
        }

        System.out.println(nodes.get(0).toString());
        int longest = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i+1; j < A.size(); j++) {
                int distance = distance(i, j, nodes, A, new HashSet<>());
//                System.out.println(i + " -> " + j + " " + distance);
                if (distance > longest) {
                    longest = distance;
                }
            }
        }

        return longest;
    }

    int distance(int i, int j, HashMap<Integer, UndirectedGraphNode> nodes, ArrayList<Integer> parents, Set<Integer> searched) {
        if (i == j) {
            return 0;
        }
        searched.add(i);

        int shortestPath = Integer.MAX_VALUE;
        int parent = parents.get(i);
        if (parent != -1 && !searched.contains(parent)) {
            searched.add(parent);
            int distance = distance(parent, j, nodes, parents, searched);
            if (distance != Integer.MAX_VALUE) {
                distance += 1;
                if (distance < shortestPath) {
                    shortestPath = distance;
                }
            }
        }

        for (UndirectedGraphNode neighbor : nodes.get(i).neighbors) {
            if (searched.contains(neighbor.label)) {
                continue;
            }
            searched.add(neighbor.label);
            int distance = distance(neighbor.label, j, nodes, parents, searched);
            // no path
            if (distance == Integer.MAX_VALUE) {
                continue;
            }

            distance += 1;
            if (distance < shortestPath) {
                shortestPath = distance;
            }
        }
        return shortestPath;
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
