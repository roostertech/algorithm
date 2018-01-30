package net.roostertech.algorithm.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

// https://www.interviewbit.com/problems/repeating-subsequence/
public class RepeatingSubSequence {

    public int anytwo(String A) {
        // first build occurrence list and their index
        if (A.length() == 0 || A.length() == 1) {
            return 0;
        }

        HashMap<Character, ArrayList<Integer>> occurrences = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (!occurrences.containsKey(c)) {
                occurrences.put(c, new ArrayList<>());
            }
            occurrences.get(c).add(i);
        }


        // Now we would only consider the keys with more than 2 appearances
        ArrayList<Character> candidates = new ArrayList<>();
        for (char key: occurrences.keySet()) {
            if (occurrences.get(key).size() > 1) {
                candidates.add(key);
            }
        }

        //special case, only one char
        if (occurrences.size() == 1) {
            if (occurrences.get(A.charAt(0)).size() > 2) {
                return 1;
            }
            return 0;
        }

        // now check for possible pair permutations
        for (int startIndex = 0; startIndex < candidates.size(); startIndex++) {
            ArrayList<Integer> firstCharIndexes = occurrences.get(candidates.get(startIndex));
            for (int otherIndex = 0; otherIndex < candidates.size(); otherIndex++) {
                if (otherIndex == startIndex) {
                    continue;
                    // don't compare to self
                }

                ArrayList<Integer> secondCharIndexes = occurrences.get(candidates.get(otherIndex));
                // First index of first character, find if any index of second character is greater
                int first = firstCharIndexes.get(0);
                int second = -1;
                int secondItor = 0; // keep track of where we are on second character index

                for (;secondItor < secondCharIndexes.size(); secondItor++) {
                    if (secondCharIndexes.get(secondItor) > first) {
                        second = secondCharIndexes.get(secondItor);
                        break;
                    }
                }

                if (second < 0) {
                    // Could not find suitable second char index
                    break;
                }
                secondItor++; // skip over the one we just used

                // Move to next index of the first character, repeat the same check
                first = firstCharIndexes.get(1);
                for (;secondItor < secondCharIndexes.size(); secondItor++) {
                    if (secondCharIndexes.get(secondItor) > first) {
                        return 1;
                    }
                }
                // not a repeating pair
            }
        }
        return 0;
    }

    @Test
    public void repeatingSubSeq() {
        Assert.assertEquals(1, anytwo("abab"));
        Assert.assertEquals(0, anytwo("abba"));
        Assert.assertEquals(1, anytwo("aabb"));
        Assert.assertEquals(1, anytwo("aaaa"));

    }

}
