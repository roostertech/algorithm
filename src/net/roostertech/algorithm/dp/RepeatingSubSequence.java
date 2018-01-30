package net.roostertech.algorithm.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

// https://www.interviewbit.com/problems/repeating-subsequence/
public class RepeatingSubSequence {

    public int anytwov1(String A) {
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

    public int anytwo(String intput) {
        int n = intput.length();
        int dp[][]=new int[n+1][n+1]; // initialized to all 0

        /**
         * Treat this problem like a path finding one. In this case we would walk the grid
         * of possible pairing from 0,0 -> n,n to see if we can find 2 or more matches.
         * Cell with row == column does not count as match.
         *
         * For example
         * A string "abab" would produce a matrix
         *
         *     a b a b
         *   0 0 0 0 0
         * a 0 0 0 X 0
         * b 0 0 0 0 X
         * a 0 X 0 0 0
         * b 0 0 X 0 0
         *
         * Now we would construct another matrix of max pairs that we could encounter when walking
         * toward n,n at each step, the walk can be downward or right. At each step
         * If a match is found - then value of that location is from parent (row -1, column -1) + 1
         * If no match - then value of the location is max of the 2 possible path to get here (go up 1, go left 1)
         *
         *     a b a b
         *   0 0 0 0 0
         * a 0 0 0 1 1
         * b 0 0 0 1 2
         * a 0 1 1 1 2
         * b 0 0 2 2 2
         *
         * Once done, looking at n,n would tell us max number of pairs can be found in the string
         */
        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
                if (intput.charAt(i-1) == intput.charAt(j-1) && i!=j)
                    dp[i][j] =  1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[n][n]>=2 ? 1 : 0;
    }


    @Test
    public void repeatingSubSeq() {
        Assert.assertEquals(1, anytwo("abab"));
        Assert.assertEquals(0, anytwo("abba"));
        Assert.assertEquals(1, anytwo("aabb"));
        Assert.assertEquals(1, anytwo("aaaa"));

    }

}
