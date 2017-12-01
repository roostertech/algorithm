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

    //https://www.interviewbit.com/problems/minimum-characters-required-to-make-a-string-palindromic/
    public int minToMakePalindrome(String A) {

        // zaaz
        // aba
        // aabaa
        // find index where all letters on the left, are also on the right
        boolean odd = A.length() % 2 != 0;

        int start = A.length() / 2 - 1 + A.length() % 2;

        for (int i = start; i >= 0; i--) { // 1
            boolean found = true;
            // check for AA | AA
            if (!(odd && i == start)) {
                for (int j = i; j >= 0; j--) {
                    if (A.charAt(j) != A.charAt(i + (i - j) + 1)) {
                        found = false;
                        break;
                    }
                }

                if (found) {
                    return A.length() - (i+1)*2;
                }
            }

            // check for BB A BB
            found = true;
            for (int j = i - 1; j >= 0; j--) {
                if (A.charAt(j) != A.charAt(i + (i - j))) {
                    found = false;
                    break;
                }
            }

            if (found) {
                return A.length() - i*2 -1;
            }

        }

        return A.length() -1;
    }

    @Test
    public void testMinToMakePalindrome() {
        Assert.assertEquals(4, minToMakePalindrome("abcde"));
        Assert.assertEquals(0, minToMakePalindrome("aaZZaa"));
        Assert.assertEquals(0, minToMakePalindrome("aaZVZaa"));
        Assert.assertEquals(1, minToMakePalindrome("aZVZaa"));
        Assert.assertEquals(1, minToMakePalindrome("babb"));
        Assert.assertEquals(0, minToMakePalindrome("aaaaa"));

//        Assert
        Assert.assertEquals(6, minToMakePalindrome("zzVVzzOOOOOO"));
        Assert.assertEquals(8, minToMakePalindrome("zrzbmnmgqoo"));
        Assert.assertEquals(19, minToMakePalindrome("mmtatbdzqsoemuvnpppsu"));
    }
}
