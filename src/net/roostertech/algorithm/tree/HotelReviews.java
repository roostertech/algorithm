package net.roostertech.algorithm.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pnguyen on 12/16/17.
 */
public class HotelReviews {
    public class Node {
        Map<Character, Node> childs = new HashMap<>();
        boolean isMatch = false;
    }

    void insert(String s, Node n) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (n.childs.containsKey(c)) {
                n = n.childs.get(c);
            } else {
                Node newNode = new Node();
                n.childs.put(c, newNode);
                n = newNode;
            }
        }
        n.isMatch = true;
    }

    boolean isMatch(String s, Node n) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (n.childs.containsKey(c)) {
                n = n.childs.get(c);
            } else {
                return false;
            }
        }
        // this would handle partial match and overlap good word
        return n.isMatch;
    }

    Node loadGoodWords(String goodWords) {
        Node root = new Node();
        for (String s: goodWords.split("_")) {
            insert(s, root);
        }
        return root;
    }

    int countGoodWords(String review, Node root) {
        int cnt = 0;
        for (String s : review.split("_")) {
            if (isMatch(s, root)) {
                cnt++;
            }
        }

        return cnt;
    }

    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        Node goodWords = loadGoodWords(A);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // cnt -> reviews
        Map<Integer, ArrayList<Integer>> resultIndex = new HashMap<>();

        for (int i = 0; i < B.size(); i++) {
            String review = B.get(i);
            int cnt = countGoodWords(review, goodWords);
            if (resultIndex.containsKey(cnt)) {
                resultIndex.get(cnt).add(i);
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                resultIndex.put(cnt, arrayList);
            }

            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = max; i >=min; i--) {
            if (resultIndex.containsKey(i)) {
                result.addAll(resultIndex.get(i));
            }
        }

        return result;
    }

    @Test
    public void testHotelReviews() {
        System.out.println(solve("cool_ice_wifi", new ArrayList<>(Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed"))));
    }
}
