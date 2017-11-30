package net.roostertech.algorithm.string;

/**
 * Created by pnguyen on 11/30/17.
 */
public class Reverse {
    public String reverseWords(String a) {

        String[] words = a.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
