package net.roostertech.algorithm.string;

/**
 * Created by pnguyen on 11/30/17.
 */
public class StrStr {
    public int strStr(final String haystack, final String needle) {
        if (needle == null || needle.length() == 0) {
            return -1;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() -  needle.length(); i++) {
            boolean match = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return i;
            }
        }

        return -1;
    }
}
