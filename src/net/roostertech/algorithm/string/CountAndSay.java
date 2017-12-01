package net.roostertech.algorithm.string;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by pnguyen on 11/30/17.
 https://www.interviewbit.com/problems/count-and-say/
 */
public class CountAndSay {
    public String countAndSay(int a) {
        ArrayList<Integer> solution = new ArrayList<>(Arrays.asList(1));

        for (int i = 1; i < a; i++) {
            ArrayList<Integer> newArray = new ArrayList<>();
            Integer lastNum = null;
            int count = 0;
            for (Integer num : solution) {
                if (lastNum == null) {
                    lastNum = num;
                    count++; // 1
                } else {
                    if (!lastNum.equals(num)) {
                        // number has changed, read it out
                        newArray.add(count);
                        newArray.add(lastNum);
                        count = 1;
                        lastNum = num;
                    } else {
                        // same number, keep counting
                        count++;
                    }
                }
            }

            // read out the last number
            newArray.add(count);
            newArray.add(lastNum);
            solution = newArray;
        }

        StringBuilder sb = new StringBuilder();
        // create the string
        for (Integer num : solution) {
            sb.append(num);
        }

        return sb.toString();
    }

    @Test
    public void testcountAndSay() {
        Assert.assertEquals("21", countAndSay(3));
        Assert.assertEquals("1211", countAndSay(4));
    };
}
