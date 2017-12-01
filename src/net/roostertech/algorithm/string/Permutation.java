package net.roostertech.algorithm.string;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by pnguyen on 11/30/17.
 http://blog.codingforinterviews.com/string-questions/
 */
public class Permutation {
    public boolean isPermutation (String a, String b) {
        // first check if both strings are the same length
        if (a.length() != b.length()) {
            return false;
        }
        // change a to char array to be iterated through
        char[] astr = a.toCharArray();
        // initialize an array as a counter
        int[] count = new int[128];
        // then we count a's characters
        for (char character : astr) {
            count[character]++;
        }
        // match a's count with b
        char[] bstr = b.toCharArray();
        for (char character : bstr) {
            if(--count[character] < 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testIsPermutation() {
        Assert.assertFalse(isPermutation("aaa", "bbb"));
        Assert.assertTrue(isPermutation("aaa", "aaa"));
        Assert.assertTrue(isPermutation("abc", "bac"));
    }

    // it is better practice to separate functions
    public static boolean isSubstring (String a, String b) {
        // we first check the length of the strings
        if (a.length() < b.length()) {
            return b.contains(a);
        }
        // feel free to use indexOf
        return a.contains(b);
    }

    // assuming that a is the rotated string
    public static boolean isRotation (String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        return isSubstring(a+a,b);
    }

    // the entire function can be optimized to this
    public static boolean isRotation2 (String a, String b) {
        return (a.length() == b.length() && isSubstring(a+a,b));
    }

    @Test
    public void testRotation() {
        Assert.assertTrue(isRotation2("abc", "bca"));
        Assert.assertFalse(isRotation2("abc", "bcA"));
    }

}
