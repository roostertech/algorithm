package net.roostertech.algorithm.binarysearch;

import java.util.ArrayList;

/**
 * Created by pnguyen on 11/20/17.
 * <p>
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than or equal to the last integer of the previous row.
 */
public class MatrixSearch {
    private int isRowInRange(ArrayList<Integer> row, int b) {
        if (row.get(0) > b) {
            return 1;
        }

        if (row.get(row.size() - 1) < b) {
            return -1;
        }
        return 0;
    }

    private int findRow(ArrayList<ArrayList<Integer>> a, int b) {
        int low = 0;
        int high = a.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int inRange = isRowInRange(a.get(mid), b);
            if (inRange == 0) {
                return mid;
            } else if (inRange > 0) {
                high = mid - 1;
            } else if (inRange < 0) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        int rowIndex = findRow(a, b);
        if (rowIndex < 0) {
            return 0;
        }

        ArrayList<Integer> row = a.get(rowIndex);
        int low = 0;
        int high = row.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = row.get(mid);
            if (midVal == b) {
                return 1;
            } else if (midVal < b) {
                low = mid + 1;
            } else if (midVal > b) {
                high = mid - 1;
            }
        }
        return 0;
    }
}
