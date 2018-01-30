package net.roostertech.algorithm.dp;
// https://www.interviewbit.com/problems/unique-paths-in-a-grid/

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class UniquePath {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int rowCnt = A.size();
        int columnCnt = A.get(0).size();

        int pathCount[][] = new int[rowCnt][columnCnt];
        for (int row = rowCnt - 1; row >= 0; row--) {
            for (int column = columnCnt - 1; column >= 0; column--) {
                int pathsFromHere = 0;
                if (A.get(row).get(column) == 1) {
                    //skip
                    continue;
                }

                if (row == rowCnt -1 && column == columnCnt -1) {
                    pathCount[row][column] = 1;
                    continue;
                }

                // possible to move right
                if (column + 1 < columnCnt) {
                    if (A.get(row).get(column + 1) == 0) {
                        pathsFromHere += pathCount[row][column + 1];
                    }
                }

                if (row + 1 < rowCnt) {
                    if (A.get(row +1).get(column) == 0) {
                        pathsFromHere += pathCount[row + 1][column];
                    }
                }

                pathCount[row][column] = pathsFromHere;
            }
        }

//        System.out.println(Arrays.toString(pathCount));
        return pathCount[0][0];
    }

    @Test
    public void testUniquePaths() {
        Assert.assertEquals(2, uniquePathsWithObstacles(new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(0,0,0)),
                        new ArrayList<>(Arrays.asList(0,1,0)),
                        new ArrayList<>(Arrays.asList(0,0,0)))
                        )));
        Assert.assertEquals(6, uniquePathsWithObstacles(new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(0,0,0)),
                        new ArrayList<>(Arrays.asList(0,0,0)),
                        new ArrayList<>(Arrays.asList(0,0,0)))
        )));
        Assert.assertEquals(1, uniquePathsWithObstacles(new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(0)))
        )));
    }
}
