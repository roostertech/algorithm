package net.roostertech.algorithm.graph;

import java.util.HashMap;

public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return cloneGraph(node, new HashMap<>());
    }

    UndirectedGraphNode cloneGraph(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> ori2CloneMap) {
        if (node == null) {
            return null;
        }

        if (ori2CloneMap.containsKey(node)) {
            return ori2CloneMap.get(node);
        }

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        ori2CloneMap.put(node, newNode);

        for (UndirectedGraphNode neighbor : node.neighbors) {
            UndirectedGraphNode newNeighbor = cloneGraph(neighbor, ori2CloneMap);
            newNode.neighbors.add(newNeighbor);
        }

        return newNode;
    }

}
