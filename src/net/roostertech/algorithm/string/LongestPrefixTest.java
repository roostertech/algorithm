package net.roostertech.algorithm.string;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by pnguyen on 11/20/17.
 */
public class LongestPrefixTest {
    @Test
    public void longestPrefix() {
        LongestPrefix alg = new LongestPrefix();

        Assert.assertEquals("a", alg.longestCommonPrefix(new ArrayList<>(Arrays.asList("a"))));
        Assert.assertEquals("a", alg.longestCommonPrefix(new ArrayList<>(Arrays.asList("a", "abc, abcde"))));
        Assert.assertEquals("a", alg.longestCommonPrefix(new ArrayList<>(Arrays.asList("abcdefgh", "aefghijk, abcefgh"))));
        Assert.assertEquals("", alg.longestCommonPrefix(new ArrayList<>(Arrays.asList("abcdefgh", "aefghijk, abcefgh","z"))));
    }
}
