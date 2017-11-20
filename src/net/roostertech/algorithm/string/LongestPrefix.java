package net.roostertech.algorithm.string;

import java.util.ArrayList;

/**
 * Created by pnguyen on 11/20/17.
 Find the longest common prefix string amongst an array of strings.
 Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
 As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.

 Example:
 Given the array as:
 [
 "abcdefgh",
 "aefghijk",
 "abcefgh"
 ]

 The answer would be “a”.
 See Expected Output


 */
public class LongestPrefix {
    public String longestCommonPrefix(ArrayList<String> a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.get(0).length(); i++) {

            char n = a.get(0).charAt(i);
            for (int j = 0; j < a.size(); j++) {
                String s = a.get(j);
                if (s.length() < i + 1) {
                    return sb.toString();
                }

                if (s.charAt(i) != n) {
                    return sb.toString();
                }
            }

            sb.append(n);
        }
        return sb.toString();
    }
}
