package net.roostertech.algorithm.codepath;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pnguyen on 12/1/17.
 */
public class Week1Test {

    // ----------------- problem 2 -----------------------------------
    static void permute(ArrayList<ArrayList<Integer>> permutations, ArrayList<Integer> remains, ArrayList<Integer> current) {
        permutations.add(new ArrayList<>(current));

        if (remains.size() == 0) {
            return;
        }

        for (int i = 0; i < remains.size(); i++) {
            ArrayList<Integer> newRemains = new ArrayList<>(remains);
            ArrayList<Integer> newCurrent = new ArrayList<>(current);
            newCurrent.add(remains.get(i));
            newRemains.remove(i);
            permute(permutations, newRemains, newCurrent);
        }
    }

    static int maxLength(int[] a, int k) {
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();
        // generate all permutations
        // eval max length

        ArrayList<Integer> remains = new ArrayList<>();//Arrays.stream(a).boxed().collect(Collectors.toList()));
        for (int i = 0; i < a.length; i++) {
            remains.add(a[i]);
        }
        System.out.println(remains);

        for (int i = 0; i < remains.size(); i++) {
            ArrayList<Integer> current = new ArrayList<>();
            current.add(remains.get(i));
            System.out.println(current);
            ArrayList<Integer> newRemains = new ArrayList<>(remains);
            newRemains.remove(i);
            permute(permutations, newRemains, current);
        }

        int maxLength = 0;
        for (ArrayList<Integer> permutation : permutations) {
            int sum = 0;
            for (Integer num : permutation) {
                sum += num;
            }
            if (sum == k && permutation.size() > maxLength) {
                maxLength = permutation.size();
            }
        }
        System.out.println(permutations);
        System.out.println(permutations.size());
        System.out.println(maxLength);

        return maxLength;
    }

    @Test
    public void testMaxLength() {
        maxLength(new int[]{4, 3, 1, 2, 1}, 4);
//        maxLength(new int[]{1,2,3}, 3);

    }



    // ----------------- problem 3 -----------------------------------
    static int findPermutation(String y, StringBuilder curr, ArrayList<Character> remains, int max) {
        if (curr.length() > max) {
            String maybe = curr.toString();
            if (y.indexOf(maybe) >= 0) {
                max = curr.length();
            }
        }

        if (remains.size() > 0) {
            for (int i = 0; i < remains.size(); i++) {
                char c = remains.get(i);
                ArrayList<Character> newRemains = new ArrayList<>(remains);
                newRemains.remove(i);
                StringBuilder newCurr = new StringBuilder(curr);
                newCurr.append(c);
                int result = findPermutation(y, newCurr, newRemains, max);
                if (result > 0 && result > max) {
                    max = result;
                }
            }
        }

        return max;
    }


    static char[] findMatchingSubsequence(String x, String y) {
        char[] strX = x.toCharArray();
        char[] strY = y.toCharArray();

        Map<Character, Integer> xMap = new HashMap<>();
        Map<Character, Integer> yMap = new HashMap<>();

        for (int i = 0; i < strX.length; i++) {
            char c = strX[i];
            if (xMap.containsKey(c)) {
                xMap.put(c, xMap.get(c) + 1);
            } else {
                xMap.put(c, 1);
            }
        }

        for (int i = 0; i < strY.length; i++) {
            char c = strY[i];
            if (yMap.containsKey(c)) {
                yMap.put(c, yMap.get(c) + 1);
            } else {
                yMap.put(c, 1);
            }
        }

        System.out.println(xMap);
        System.out.println(yMap);

        ArrayList<Character> subsequence = new ArrayList<>();

        // first find match subsequence
        for (Character c : yMap.keySet()) {
            if (!xMap.containsKey(c)) {
                continue;
            }

            int xCount = xMap.get(c);
            int yCount = yMap.get(c);
            int charCount = xCount < yCount ? xCount : yCount;

            for (int i = 0; i < charCount; i++) {
                subsequence.add(c);
            }
        }

        System.out.println("may be seq" + subsequence);

        char[] result = new char[subsequence.size()];
        for (int i = 0; i < subsequence.size(); i++) {
            result[i] = subsequence.get(i);
        }

        return result;
    }

    static int longestSubsequenceInterative(String x, String y) {
        char[] maybeSubseqnence = findMatchingSubsequence(x, y);

        ArrayList<ArrayList<String>> strings = permuteInterative(maybeSubseqnence);
//        System.out.println(strings);

        // now find the longest match?

        return 0;
    }

    // This solution blows up when subsequence length > 12
    static int longestSubsequence(String x, String y) {
        char[] strX = x.toCharArray();
        char[] strY = y.toCharArray();

        Map<Character, Integer> xMap = new HashMap<>();
        Map<Character, Integer> yMap = new HashMap<>();

        for (int i = 0; i < strX.length; i++) {
            char c = strX[i];
            if (xMap.containsKey(c)) {
                xMap.put(c, xMap.get(c) + 1);
            } else {
                xMap.put(c, 1);
            }
        }

        for (int i = 0; i < strY.length; i++) {
            char c = strY[i];
            if (yMap.containsKey(c)) {
                yMap.put(c, yMap.get(c) + 1);
            } else {
                yMap.put(c, 1);
            }
        }

        System.out.println(xMap);
        System.out.println(yMap);

        ArrayList<Character> subsequence = new ArrayList<>();

        // first find match subsequence
        for (Character c : yMap.keySet()) {
            if (!xMap.containsKey(c)) {
                continue;
            }

            int xCount = xMap.get(c);
            int yCount = yMap.get(c);
            int charCount = xCount < yCount ? xCount : yCount;

            for (int i = 0; i < charCount; i++) {
                subsequence.add(c);
            }
        }

        System.out.println("may be seq" + subsequence);

        int max = 0;
        for (int i = 0; i < subsequence.size(); i++) {
            char c = subsequence.get(i);
            ArrayList<Character> remains = new ArrayList<>(subsequence);
            remains.remove(i);
            StringBuilder curr = new StringBuilder();
            curr.append(c);
//            System.out.println("max" + max);
            int result = findPermutation(y, curr, remains, max);
            if (result > max) {
                max = result;
            }
        }

        // find matching permutation

        System.out.println("result" + max);
        // then find sub string
        return max;
    }

    @Test
    public void testLongestSub() {
        long start = System.currentTimeMillis();
//        longestSubsequence("hackerranks", "hackers");
//        longestSubsequence("abc", "aedace");

//        longestSubsequence("hackerrhackersdkdkkzanksiiiia", "hackersdkdkkznnnoVVVVVVVVVVVv   329394fjff");
        //88275
//        longestSubsequence("hagiackss;;sldkkkasesdrs12dasnns3asd4kkdsa;s5", "AAAAAAAAAAAAAAAhackers12345AAAAAAAAAAAAAAAAAAAAAAAAAA");

        longestSubsequenceInterative("hagiackss;;sldkkkasesdrs12dasnns3asd4kkdsa;s5", "AAAAAAAAAAAAAAAhackers12345AAAAAAAAAAAAAAAAAAAAAAAAAA");

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


    public static ArrayList<ArrayList<String>> permuteInterative(char[] chars) {
        // store arrays group by size
        ArrayList<ArrayList<String>> resultBySize = new ArrayList<>();

        // starts out empty
        ArrayList<StringBuilder> results = new ArrayList<>();
        results.add(new StringBuilder());

        for (int i = 0; i< chars.length; i++) {
            ArrayList<StringBuilder> current = new ArrayList<>();
            for (StringBuilder s : results) {
                for (int j = 0; j < s.length() + 1; j++) {
                    s.insert(j, chars[i]);
                    StringBuilder temp = new StringBuilder(s);
                    current.add(temp);
                    s.deleteCharAt(j);
                }
            }
            results =  new ArrayList<>(current);
            //snap shot of that size
            ArrayList<String> strings = new ArrayList<>();
            for (StringBuilder s: current) {
                strings.add(s.toString());
            }
            resultBySize.add(strings);
        }
        System.out.println(resultBySize);
        return resultBySize;
    }

    @Test
    public void testPermuteCharIterative() {
        permuteInterative(new char[]{'a', 'b', 'c'});
    }


    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        //start from an empty list
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < num.length; i++) {
            //list of list in current iteration of the array num
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> l : result) {
                // # of locations to insert is largest index + 1
                for (int j = 0; j < l.size() + 1; j++) {
                    // + add num[i] to different locations
                    l.add(j, num[i]);
                    ArrayList<Integer> temp = new ArrayList<Integer>(l);
                    current.add(temp);
                    //System.out.println(temp);
                    // - remove num[i] add
                    l.remove(j);
                }
            }
            result = new ArrayList<ArrayList<Integer>>(current);
        }
        return result;
    }

    @Test
    public void testPermuteIterative() {
        permute(new int[]{5,6,7});
    }

}
