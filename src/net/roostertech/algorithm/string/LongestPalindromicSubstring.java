package net.roostertech.algorithm.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by pnguyen on 11/29/17.
 * https://www.interviewbit.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome2(String a) {
        ArrayList<Character> chars = new ArrayList<>();
        for (char c : a.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                continue;
            }

            chars.add(Character.toLowerCase(c));
        }
        System.out.println(chars);

        int mid = chars.size() / 2;
        for (int i = 0; i < mid; i++) {
            // go left

            int lstart = 0, lend = 0;
            for (int j = 0; j < mid; j++) {
                if (mid - i - j > 0 && mid - i + j < chars.size()) {
                    if (chars.get(mid - i - j) == chars.get(mid - i + j + 1)) {
                        lstart = mid - i - j;
                        lend = mid - i + j + 1;
                    } else {
                        break;
                    }
                }
            }

            System.out.println("ls " + lstart + " lend " + lend);
        }

        return "";
    }

    public String longestPalindrome(String A) {

        int n;
        boolean[][] dp;
        int i;

        n = A.length();

        dp = new boolean[n][n];

        // sub string that start/end at self, single character
        for (i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int len = 2; len <= n; len++) {
            int j;
            for (i = 0; i < n - len + 1; i++) {

                j = i + len - 1;
                // check the first two characters
                if (len == 2) {
                    if (A.charAt(i) == A.charAt(j)) {
                        dp[i][j] = true;
                    }
                } else {
                    // After that, check the previous substring, this will also cover odd length palindrome
                    if (A.charAt(i) == A.charAt(j) && dp[i + 1][j - 1])
                        dp[i][j] = true;
                }

            }

        }

        int start = -1;
        int len = -1;

        for (i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j] && j - i + 1 > len) {
                    len = j - i + 1;
                    start = i;
                }
            }
        }


        return A.substring(start, start + len);
    }

    @Test
    public void testLongestPalindrome() {
//        Assert.assertEquals("aa", longestPalindrome("aa"));
        Assert.assertEquals("aba", longestPalindrome("aba"));
    }
}
