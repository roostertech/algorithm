package net.roostertech.algorithm.backtracking;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PartitionPalindrome {

    ArrayList<ArrayList<String>> results = new ArrayList<>();

    public void partition(String s, int start, ArrayList<String> inprogress) {
        if (start == s.length()) {
            // reached the end
            results.add(new ArrayList<>(inprogress));
            return;
        }

        // try to create incrementall bigger palindromes
        for (int i = start + 1; i <= s.length(); i++) {
            String maybe = s.substring(start, i);
            if (isPalindrome(maybe)) {
                inprogress.add(maybe);

                // partition remaining of the string
                partition(s, i, inprogress);

                // backtrack and try creating longer palindromes
                inprogress.remove(inprogress.size() -1);
            }
        }
    }

    public ArrayList<ArrayList<String>> partition(String a) {
        results = new ArrayList<>();
        partition(a, 0, new ArrayList<>());
        return results;
    }


    private boolean isPalindrome(String s) {
        for (int start = 0, end = s.length() -1; end > start; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void testPartition() {
        Assert.assertTrue(isPalindrome("aaaa"));
        Assert.assertTrue(isPalindrome("aaa"));
        Assert.assertFalse(isPalindrome("ab"));

        System.out.println(partition("aab"));
    }
}
