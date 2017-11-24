package net.roostertech.algorithm.array;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by pnguyen on 11/23/17.
 */
public class Anagram {

    private static int delta(int[] a1, int[] a2) {
        int delta = 0;

        for (int i = 0; i < a1.length; i++) {
            delta += Math.abs(a1[i] - a2[i]);
        }
        return delta;
    }

    private static int[] getCharCounts(String s) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars[c - (int)'a']++;
        }
        return chars;
    }

    public static int charNeeded(String s1, String s2) {
        int[] a1 = getCharCounts(s1);
        int[] a2 = getCharCounts(s2);

        return delta(a1, a2);
    }

    @Test
    public void testAnagram() {
        Assert.assertEquals(0, charNeeded("abc", "abc"));
        Assert.assertEquals(1, charNeeded("abc", "abcd"));
        Assert.assertEquals(6, charNeeded("hello", "billion"));

    }
}
