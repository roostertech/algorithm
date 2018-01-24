package net.roostertech.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(label + " -> ");
        sb.append("[");

        for (UndirectedGraphNode n: neighbors) {
            sb.append(n.toString());
        }
        sb.append("]\n");

        return sb.toString();
    }
}
