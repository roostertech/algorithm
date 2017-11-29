package net.roostertech.algorithm.string;

import junit.framework.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by pnguyen on 11/28/17.
 https://www.interviewbit.com/problems/palindrome-string/
 */
public class Palindrome {
    public int isPalindrome(String a) {
        ArrayList<Character> chars = new ArrayList<>();
        for (char c: a.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                continue;
            }

            chars.add(Character.toLowerCase(c));
        }

        System.out.println(chars);

        for (int i = 0; i < chars.size() / 2; i++) {
            if (chars.get(i) != chars.get(chars.size() - i - 1)) {
                return 0;
            }
        }

        return 1;
    }

    @Test
    public void testIsPalindrome() {
        Assert.assertEquals(1, isPalindrome("aabbaa"));
        Assert.assertEquals(0, isPalindrome("aabbaa1"));

        Assert.assertEquals(1, isPalindrome("aa bb, A a"));
        Assert.assertEquals(1, isPalindrome("aba"));


    }
}
