package net.roostertech.algorithm.recursion;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by pnguyen on 11/23/17.
 */
public class StringPermutation {
    static void permutate(HashSet<String> results, ArrayList<String> resultList, StringBuilder inProgress, ArrayList<Character> chars, int len) {
        if (len == 0) {
            String perm = inProgress.toString();
            if (!results.contains(perm)) {
                results.add(perm);
                resultList.add(perm);
            }
            return;
        }

        for (int i = 0 ; i < chars.size(); i++) {
            StringBuilder sb = new StringBuilder(inProgress);
            sb.append(chars.get(i));

            ArrayList<Character> remain = new ArrayList<>(chars);
            remain.remove(chars.get(i));
            for (int j = 1; j <= chars.size(); j++) {
                permutate(results, resultList, sb, remain, len - 1);
            }
        }
    }
    static String[] buildSubsequences(String s) {
        ArrayList<Character> chars = new ArrayList<>();
        // chop s into sorted char seq
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (chars.size() == 0) {
                chars.add(c);
                continue;
            }
            int index = -1;
            for (int j = 0; j < chars.size(); j++) {
                if (chars.get(j).compareTo(c) > 0) {
                    index = j;
                    break;
                }
            }
            if (index == -1) {
                chars.add(c);
            } else {
                chars.add(index,c);
            }
        }
        HashSet<String> results = new HashSet<>();
        ArrayList<String> resultList = new ArrayList<>();

        System.out.println(chars);

        StringBuilder sb = new StringBuilder();
        for (int j = 1; j <= chars.size(); j++) {
            permutate(results, resultList, sb, chars, j);
        }
//        System.out.println(results);
        System.out.println(resultList);

        // now generate permutations
        return resultList.toArray(new String[resultList.size()]);
    }

    @Test
    public void stringPermutations() {
        String[] seq1 = {"a", "b", "c", "ab", "ac", "ba", "bc", "ca", "cb", "abc", "acb", "bac", "bca", "cab", "cba"};
        Assert.assertTrue(Arrays.equals(seq1, buildSubsequences("abc")));
        Assert.assertTrue(Arrays.equals(new String[]{"a", "b", "ab", "ba"}, buildSubsequences("ab")));
    }
}
