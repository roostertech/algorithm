package net.roostertech.algorithm.hashing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pnguyen on 12/5/17.
 */
public class WindowString {

    private boolean contains(Map<Character, Integer> needle, Map<Character, Integer> hayStack) {
        for (Character c : needle.keySet()) {
            if (!hayStack.containsKey(c)) {
                return false;
            }

            if (hayStack.get(c) < needle.get(c)) {
                return false;
            }
        }

        return true;
    }

    private void removeFromMap(Map<Character, Integer> map, char c) {
        int remain = map.get(c);
        remain--;
        if (remain > 0) {
            map.put(c, remain);
        } else {
            map.remove(c);
        }
    }

    private void addToMap(Map<Character, Integer> map, char c) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        } else {
            map.put(c, 1);
        }
    }

    // does not handle some case properly
    public String minWindowStrMapMethod(String S, String T) {
        Map<Character, Integer> needle = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {
            addToMap(needle, T.charAt(i));
        }

        Map<Character, Integer> movingHaystack = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            addToMap(movingHaystack, S.charAt(i));
        }

        if (!contains(needle, movingHaystack)) {
            return "";
        }

        ArrayList<Integer> windows = new ArrayList<>();
        int end = S.length() - 1, start = 0;

        while (true) {
            int windowStart = -1, windowEnd = -1;

            movingHaystack.clear();
            for (int i = start; i <= end; i++) {
                addToMap(movingHaystack, S.charAt(i));
            }

            if (!contains(needle, movingHaystack)) {
                break;
            }

            for (int i = end; i >= start; i--) {
                char c = S.charAt(i);
                removeFromMap(movingHaystack, c);
                if (!contains(needle, movingHaystack)) {
                    addToMap(movingHaystack, c);
                    windowEnd = i + 1;
                    break;
                }
            }

            for (int i = start; i <= windowEnd; i++) {
                char c = S.charAt(i);
                removeFromMap(movingHaystack, c);
                if (!contains(needle, movingHaystack)) {
                    windowStart = i;
                    break;
                }
            }

            start = windowEnd + 1;
            if (windowEnd >= 0 && windowStart >= 0) {
                windows.add(windowStart);
                windows.add(windowEnd);
            } else {
                break;
            }
        }

        System.out.println(windows);

        // find the smallest window
        int smallest = S.length() + 1;
        int smallestStart = 0;
        int smallestEnd = 0;
        for (int i = 0; i < windows.size(); i = i + 2) {
            int s = windows.get(i);
            int e = windows.get(i + 1);

            if (e - s < smallest) {
                smallestStart = s;
                smallestEnd = e;
                smallest = e - s;
            }

        }


        return S.substring(smallestStart, smallestEnd);
    }

    public String minWindow(String S, String T) {
        if (T.length() > S.length()) {
            return "";
        }

        Map<Character, Integer> needle = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {
            addToMap(needle, T.charAt(i));
        }

        int minStart = S.length() + 1;
        int minLen = S.length() + 1;

        int start = 0;
        int end = T.length() - 1;
        Map<Character, Integer> movingHaystack = new HashMap<>();
        for (int k = 0; k <= end; k++) {
            addToMap(movingHaystack, S.charAt(k));
        }

        while (start < S.length() && end < S.length()) {
            int len = end - start + 1;
            if (contains(needle, movingHaystack)) {
                if (minLen > len) {
                    minLen = len;
                    minStart = start;
                } else if (len == minLen && minStart > start) {
                    minLen = len;
                    minStart = start;
                }
                start++;
                removeFromMap(movingHaystack, S.charAt(start - 1));
            } else {
                end++;
                if (end < S.length()) {
                    addToMap(movingHaystack, S.charAt(end));
                }
            }
        }

        if (minStart > S.length()) {
            return "";
        }

        return S.substring(minStart, minStart + minLen);
    }

    @Test
    public void testMinWindow() {
        System.out.println(minWindow("w", "o"));
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("A", "A"));
        //8oHqXoQYWWll8Pumov89wXDe0Qx6bEjsNJQAQ0A6K21Z0BrmM96FWEdRG69M9CYtdBOrDjzVGPf83UdP3kc4gK0uHVKcPN4HPdccm9Qd2VfmmOwYCYeva6BSG6NGqTt1aQw9BbkNsgAjvYzkVJPOYCnz7U4hBeGpcJkrnlTgNIGnluj6L6zPqKo5Ui75tC0jMojhEAlyFqDs7WMCG3dmSyVoan5tXI5uq1IxhAYZvR
        System.out.println(minWindow("xiEjBOGeHIMIlslpQIZ6jERaAVoHUc9Hrjlv7pQpUSY8oHqXoQYWWll8Pumov89wXDe0Qx6bEjsNJQAQ0A6K21Z0BrmM96FWEdRG69M9CYtdBOrDjzVGPf83UdP3kc4gK0uHVKcPN4HPdccm9Qd2VfmmOwYCYeva6BSG6NGqTt1aQw9BbkNsgAjvYzkVJPOYCnz7U4hBeGpcJkrnlTgNIGnluj6L6zPqKo5Ui75tC0jMojhEAlyFqDs7WMCG3dmSyVoan5tXI5uq1IxhAYZvRQVHtuHae0xxwCbRh6S7fCLKfXeSFITfKHnLdT65K36vGC7qOEyyT0Sm3Gwl2iXYSN2ELIoITfGW888GXaUNebAr3fnkuR6VwjcsPTldQSiohMkkps0MH1cBedtaKNoFm5HbH15kKok6aYEVsb6wOH2w096OwEyvtDBTQwoLN87JriLwgCBBavbOAiLwkGGySk8nO8dLHuUhk9q7f0rIjXCsQeAZ1dfFHvVLupPYekXzxtWHd84dARvv4Z5L1Z6j8ur2IXWWbum8lCi7aErEcq41WTo8dRlRykyLRSQxVH70rUTz81oJS3OuZwpI1ifBAmNXoTfznG2MXkLtFu4SMYC0bPHNctW7g5kZRwjSBKnGihTY6BQYItRwLUINApd1qZ8W4yVG9tnjx4WyKcDhK7Ieih7yNl68Qb4nXoQl079Vza3SZoKeWphKef1PedfQ6Hw2rv3DpfmtSkulxpSkd9ee8uTyTvyFlh9G1Xh8tNF8viKgsiuCZgLKva32fNfkvW7TJC654Wmz7tPMIske3RXgBdpPJd5BPpMpPGymdfIw53hnYBNg8NdWAImY3otYHjbl1rqiNQSHVPMbDDvDpwy01sKpEkcZ7R4SLCazPClvrx5oDyYolubdYKcvqtlcyks3UWm2z7kh4SHeiCPKerh83bX0m5xevbTqM2cXC9WxJLrS8q7XF1nh", "dO4BRDaT1wd0YBhH88Afu7CI4fwAyXM8pGoGNsO1n8MFMRB7qugS9EPhCauVzj7h"));

    }
}
