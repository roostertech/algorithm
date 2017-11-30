package net.roostertech.algorithm.array;

import java.util.ArrayList;

/**
 * Created by pnguyen on 11/29/17.

 //        0 0 -> 0 2
 //        0 1 -> 1 2
 //        0 2 -> 2 2

 //
 //        0,0  0,1  0,2
 //        1 0  1 1  1 2
 //        2 0  2 1  2 2
 */
public class RotateMatrix {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        if (a == null || a.size() == 0) {
            return;
        }
        int n = a.get(0).size();
        // number of rings
        for (int i = 0; i < n / 2; i++) {
            // how many item on ring edge
            for (int k = 0; k < n - i * 2 - 1; k++) {
                int tmp, tmp2;
                int topRow = i, topColumn = k + i;
                int rightRow = k + i, rightColumn = n - i - 1;
                int bottomRow = n - i - 1, bottomColumn = n - k - i - 1;
                int leftRow = n - k - i - 1, leftColumm = i;

                // top -> right
                int right = a.get(rightRow).get(rightColumn);
                a.get(rightRow).set(rightColumn, a.get(topRow).get(topColumn));

                // right -> bottom
                int bottom = a.get(bottomRow).get(bottomColumn);
                a.get(bottomRow).set(bottomColumn, right);

                // bottom -> left
                int left = a.get(leftRow).get(leftColumm);
                a.get(leftRow).set(leftColumm, bottom);

                // left -> top
                a.get(topRow).set(topColumn, left);
            }
        }

    }
}
