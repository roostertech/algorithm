package net.roostertech.algorithm.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://www.interviewbit.com/problems/regular-expression-ii/
 * https://www.programcreek.com/2012/12/leetcode-regular-expression-matching-in-java/
 *
 * Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).
 */
public class RegularExpression2 {

    public boolean isRegexMatch(final String input, final String regex) {
        if (regex.length() == 0) {
            return input.length() == 0;
        }

        if (regex.length() == 1) {
            if (input.length() < 1) {
                return false;
            } else if (input.charAt(0) != regex.charAt(0) && regex.charAt(0) != '.') {
                return false;
            } else {
                // match or .
                // if there are more input, and we have ran out of regex, fail the match
                return input.length() == 1;
            }
        }

        if (regex.charAt(1) != '*') {
            // none star case

            // ran out out input
            if (input.length() < 1) {
                return false;
            }

            if (input.charAt(0) != regex.charAt(0) && regex.charAt(0) != '.') {
                return false;
            } else {
                // matched this char, continue with the rest
                return isRegexMatch(input.substring(1), regex.substring(1));
            }
        } else {
            // handle star case

            // match zero character with star
            if (isRegexMatch(input, regex.substring(2))) {
                return true;
            }

            // try to match one or more character with star
            for (int i = 0; i < input.length() && (input.charAt(i) == regex.charAt(0) || regex.charAt(0) == '.'); i++) {
                if (isRegexMatch(input.substring(i + 1), regex.substring(2))) {
                    return true;
                }
            }
            return false;
        }

    }

    public int isMatch(final String input, final String regex) {
        return isRegexMatch(input,regex) ? 1 : 0;
    }

    @Test
    public void testRegex() {
        Assert.assertEquals(1, isMatch("aa", "aa"));
        Assert.assertEquals(0, isMatch("aa", "bb"));
        Assert.assertEquals(1, isMatch("abc", ".*"));
        Assert.assertEquals(0, isMatch("abc", "d.*"));
        Assert.assertEquals(1, isMatch("abc", "a.c"));
        Assert.assertEquals(1, isMatch("ac", "ab*c"));
        Assert.assertEquals(1, isMatch("abbc", "ab*bbc"));

    }

}
