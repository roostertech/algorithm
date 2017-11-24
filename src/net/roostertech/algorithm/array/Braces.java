package net.roostertech.algorithm.array;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by pnguyen on 11/23/17.
 * Check if braces are balanced
 */
public class Braces {

    static boolean isMatch(Character q1, Character q2) {
        // TODO use ascii value?
        if (q1 == '{' && q2 == '}') {
            return true;
        }
        if (q1 == '(' && q2 == ')') {
            return true;
        }
        if (q1 == '[' && q2 == ']') {
            return true;
        }
        return false;
    }

    static String[] braces(String[] values) {
        Set<Character> left = new HashSet<>(Arrays.asList('{', '(', '['));
        Set<Character> right = new HashSet<>(Arrays.asList('}', ')', ']'));

        String[] result = new String[values.length];
        int index = 0;
        for (String value: values) {
            ArrayList<Character> quotes = new ArrayList<>();
            for (int i = 0; i < value.length(); i++) {
                Character quote = value.charAt(i);
                if (left.contains(quote)) {
                    quotes.add(quote);
                    //System.out.println("Adding " + quote);
                } else if (right.contains(quote)) {
                    if (quotes.size() > 0 && isMatch(quotes.get(quotes.size() -1),quote)) {
                        quotes.remove(quotes.size() -1);
                        //System.out.println("Removing " + quote);
                    } else {
                        quotes.add(quote);
                        //System.out.println("Unbalance " + quote + " " +  quotes.get(quotes.size() -1));
                        break;
                    }
                }
            }
            //System.out.println("Result " + quotes);

            if (quotes.size() == 0) {
                result[index] = "YES";
            } else {
                result[index] = "NO";
            }
            index++;
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
        return result;
    }

    private void print(String[] res) {

    }

    @Test
    public void testBraces() {
        Assert.assertTrue(Arrays.equals(new String[]{"YES", "NO", "NO", "YES"}, braces(new String[]{"{}[]()", "{", "}", ""})));
    }
}
