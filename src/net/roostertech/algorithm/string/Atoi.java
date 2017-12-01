package net.roostertech.algorithm.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pnguyen on 11/30/17.
 */
public class Atoi {
    public int atoi(final String a) {
        int number = 0;
        int mult = 1;
        boolean started = false;

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (c == '-' && !started) {
                mult = -1;
                started = true;
            } else if (c == '+' && !started) {
                    started = true;
            } else if (Character.isDigit(c)) {
                if (Integer.MAX_VALUE / 10 < number) {
                    if (mult > 0) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
                number = number * 10 + c - '0';
                started = true;
            } else if (!started && c == ' ') {
                // ignore
            } else {
                if (started) {
                    break;
                } else {
                    return 0;
                }
            }

        }
        return number * mult;
    }

    @Test
    public void testAtoi() {
        Assert.assertEquals(7, atoi("7 U 0 T7165 0128862 089 39 5"));
        Assert.assertEquals(0, atoi("abb 1"));
        Assert.assertEquals(-1, atoi("-1"));
        Assert.assertEquals(0, atoi("- 1"));
        Assert.assertEquals(1, atoi("+1"));
        Assert.assertEquals(0, atoi("- 1"));
    }
}
