package net.roostertech.algorithm.dp;

public class Edit {
    public static int editDistance(String start, String end) {
        int startLen = start.length();
        int endLen = end.length();

        int[][]edits = new int[startLen + 1][endLen + 1];


        for (int startIndex = 0; startIndex <= startLen; startIndex++) {

            for (int endIndex = 0; endIndex <= endLen; endIndex++) {
                if (startIndex == 0) {
                    edits[startIndex][endIndex] = endIndex;
                    continue;
                }

                if (endIndex == 0) {
                    edits[startIndex][endIndex] = startIndex;
                    continue;
                }

                char startC = start.charAt(startIndex -1);
                char endC = end.charAt(endIndex -1);

                if (startC == endC) {
                    edits[startIndex][endIndex] = edits[startIndex - 1][endIndex - 1];
                } else {
                    int min = Math.min(edits[startIndex - 1][endIndex - 1], edits[startIndex - 1][endIndex]);
                    min = Math.min(edits[startIndex][endIndex - 1], min);
                    edits[startIndex][endIndex] = min + 1;
                }
            }
        }

        return edits[startLen][endLen];
    }
}
