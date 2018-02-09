package net.roostertech.algorithm.graph;

import org.junit.Test;

import java.util.*;

public class WordLadder2 {

    class TrieNode {
        String val;
        TrieNode parent;
        ArrayList<TrieNode> children = new ArrayList<>();
        HashSet<String> used = new HashSet<>();

        public TrieNode(String val, TrieNode parent) {
            this.parent = parent;
            if (parent != null) {
                used.addAll(parent.used);
            }
            used.add(val);
            this.val = val;
        }
    }

    /**
     * Both words have the same length
     * @param word1
     * @param word2
     * @return true if they are only different by one character
     */
    boolean isLinked(String word1, String word2) {
        boolean hasDiff = false;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (hasDiff) {
                    return false;
                }
                hasDiff = true;
            }
        }
        return true;
    }

    public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> input) {

        ArrayList<ArrayList<String>> paths = new ArrayList<>();

        if (start.equals(end)) {
            paths.add(new ArrayList<>(Arrays.asList(end)));
            return paths;
        }

        TrieNode root = new TrieNode(start, null);
        Queue<TrieNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        HashSet<String> dict = new HashSet<>(input);
        queue.offer(root);
        level.offer(0);

        boolean found = false;
        int stopLevel = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            TrieNode node = queue.poll();
            int currLevel = level.poll();

            if (currLevel > stopLevel) {
                continue;
            }

            if (isLinked(node.val, end)) {
                // Found
                found = true;
                stopLevel = currLevel;
                //generate a result
                ArrayList<String> path = new ArrayList<>();
                path.add(end);
                TrieNode itor = node;
                while (itor != null) {
                    path.add(0, itor.val);
                    itor = itor.parent;
                }
                paths.add(path);
            } else if (!found){
                // Find all possible link from here
                for (String word : dict) {
                    if (!node.used.contains(word) && isLinked(node.val, word)) {
                        TrieNode nextNode = new TrieNode(word, node);
                        nextNode.parent = node;
                        node.children.add(nextNode);
                        queue.offer(nextNode);
                        level.offer(currLevel + 1);
                    }
                }
            }
        }
        return paths;
    }

    @Test
    public void testLadder() {
        System.out.println(findLadders("bbaa", "babb", new ArrayList<String>(Arrays.asList("baba","abba","aaba","bbbb","abaa","abab","aaab","abba","abba","abba","bbba","aaab","abaa","baba","baaa"))));
//        System.out.println(findLadders("bb", "bb", new ArrayList<String>(Arrays.asList())));
//        System.out.println(findLadders("hit", "cog", new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log"))));
    }
}
