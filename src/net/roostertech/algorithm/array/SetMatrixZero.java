package net.roostertech.algorithm.array;

import java.util.ArrayList;

/**
 * Created by pnguyen on 11/29/17.
 https://www.interviewbit.com/problems/set-matrix-zeros/
 */
public class SetMatrixZero {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int[] columnZeros = new int[a.get(0).size()];

        for (ArrayList<Integer> row : a) {
            boolean zeroRow = false;
            for (int i = 0; i < row.size(); i++) {
                Integer element = row.get(i);
                if (element == 0) {
                    zeroRow = true;
                    columnZeros[i] = 1;
                }


            }

            if (zeroRow) {
                for (int i = 0; i < row.size(); i++) {
                    row.set(i, 0);
                }
            }
        }

        // second pass
        for (ArrayList<Integer> row : a) {
            for (int i = 0; i < row.size(); i++) {
                if (columnZeros[i] == 1) {
                    row.set(i, 0);
                }
            }
        }
    }
}
