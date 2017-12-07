package net.roostertech.algorithm.hashing;

import org.junit.Test;

import java.util.*;

/**
 * Created by pnguyen on 12/6/17.
 https://www.interviewbit.com/problems/substring-concatenation/
 */

public class SubstringConcatenation {

    private void permutation1(HashSet<String> permutations, ArrayList<String> strings, int remains) {
        if (remains == 1) {
            // make the string
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strings.size(); i++) {
                sb.append(strings.get(i));
            }
            permutations.add(sb.toString());
            return;
        }

        for (int i = 0; i < remains; i++) {
            // swap i and remains - 1
            String tmp = strings.get(remains - 1);
            strings.set(remains -1, strings.get(i));
            strings.set(i, tmp);

            permutation1(permutations, strings, remains - 1);

            // swap it back
            tmp = strings.get(remains - 1);
            strings.set(remains -1, strings.get(i));
            strings.set(i, tmp);
        }
    }

    // this solution blew up when size of b is large
    public ArrayList<Integer> findSubstring1(String a, final List<String> b) {
        // generate permutations
        HashSet<String> permutations = new HashSet<>();
        ArrayList<Integer> results = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>(b);
        permutation1(permutations, strings, strings.size());

        System.out.println(permutations);

        // find all the substrings
        for (int i = 0; i < a.length(); i++) {
            for (int j = i+1; j <= a.length(); j++) {
                String substring = a.substring(i, j);
                if (permutations.contains(substring)) {
                    results.add(i);
                    // no need for check substring starting here any more
                    break;
                }
            }
        }
        System.out.println(results);

        return results;
    }


    //------ this solution passed the test cases
    private void permutationSearch (Set<Integer> results, String haystack, ArrayList<String> strings, int remains) {
        if (remains == 1) {
            // make the string
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strings.size(); i++) {
                sb.append(strings.get(i));
            }
            String perm = sb.toString();

            int index = haystack.indexOf(perm);
            while (index >= 0) {
                results.add(index);
                index ++;
                index = haystack.indexOf(perm, index);
            }
            return;
        }

        for (int i = 0; i < remains; i++) {
            // swap i and remains - 1
            String tmp = strings.get(remains - 1);
            strings.set(remains -1, strings.get(i));
            strings.set(i, tmp);

            permutationSearch(results, haystack, strings, remains - 1);

            // swap it back
            tmp = strings.get(remains - 1);
            strings.set(remains -1, strings.get(i));
            strings.set(i, tmp);
        }
    }
    public ArrayList<Integer> findSubstring(String a, final List<String> b) {
        HashSet<Integer> results = new HashSet<>();

        // sanity check
        int concatLen = 0;
        for (String s: b) {
            concatLen += s.length();
        }
        if (concatLen > a.length()) {
            return new ArrayList<>();
        }

        // generate permutations
        ArrayList<String> strings = new ArrayList<>(b);

        permutationSearch(results, a, strings, strings.size());
        System.out.println(results);
        return new ArrayList<>(results);
    }

    @Test
    public void testPerms() {
        findSubstring("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList("aaa", "aaa", "aaa", "aaa", "aaa"));
        findSubstring("barfoothefoobarman", Arrays.asList("foo","bar"));
        findSubstring("foobangbazABCbazfoobang", Arrays.asList("baz","foo","bang"));
        findSubstring("bcabbcaabbccacacbabccacaababcbb", Arrays.asList("c", "b", "a", "c", "a", "a", "a", "b", "c"));

//        findSubstring("acaaacbcbccbaabaccabcbbcaaccbbbbcbabaacbbcbccababb", Arrays.asList("cabccbbbc", "abbccabbc", "bbbcbbbaa", "acbaabcab", "ccacabccb", "bbacaabca", "acacbaacb", "aabbcccab", "ccccbbcaa", "baaccaabc"));
    }
}
