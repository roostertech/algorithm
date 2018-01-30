package net.roostertech.algorithm.graph;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

/**
 * Count number of groups of adjacent 1 of specific size in the matrix
 */
public class CountGroups {

    static int[] countGroups(int[][] m, int[] t) {
        int rows = m.length;
        int columns = m[0].length;
        boolean[][] visited = new boolean[rows][columns];

        HashMap<Integer, Integer> groupSizes = new HashMap<>();

        Stack<Integer> rowStack = new Stack<>();
        Stack<Integer> columnStack = new Stack<>();


        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int size = 0;
                if (visited[row][column]) {
                    continue;
                }
                if (m[row][column] == 0) {
                    visited[row][column] = true;
                    continue;
                }

                // At each position, if not visited, do a DFS to find group size
                rowStack.push(row);
                columnStack.push(column);
                visited[row][column] = true;
//                System.out.println("Start " + row + " " +column);

                while (!rowStack.isEmpty()) {
                    int itemRow = rowStack.pop();
                    int itemColumn = columnStack.pop();
                    size++;

                    // up
                    if (itemRow > 0 && !visited[itemRow -1][itemColumn]) {
                        visited[itemRow - 1][itemColumn] = true;
                        if (m[itemRow -1][itemColumn] == 1) {
                            rowStack.push(itemRow -1);
                            columnStack.push(itemColumn);
                        }
                    }

                    // down
                    if (itemRow < (rows -1) && !visited[itemRow + 1][itemColumn]) {
                        visited[itemRow + 1][itemColumn] = true;
                        if (m[itemRow + 1][itemColumn] == 1) {
                            rowStack.push(itemRow + 1);
                            columnStack.push(itemColumn);
                        }
                    }


                    // left
                    if (itemColumn > 0 && !visited[itemRow][itemColumn - 1]) {
                        visited[itemRow][itemColumn - 1] = true;
                        if (m[itemRow][itemColumn - 1] == 1) {
                            rowStack.push(itemRow);
                            columnStack.push(itemColumn - 1);
                        }
                    }

                    // right
                    if (itemColumn < (columns - 1) && !visited[itemRow][itemColumn + 1]) {
                        visited[itemRow][itemColumn + 1] = true;
                        if (m[itemRow][itemColumn + 1] == 1) {
                            rowStack.push(itemRow);
                            columnStack.push(itemColumn + 1);
                        }
                    }
                }

//                System.out.println("Size " + size);
                if (groupSizes.containsKey(size)) {
                    groupSizes.put(size, groupSizes.get(size)+1);
                } else {
                    groupSizes.put(size, 1);
                }
            }
        }


        int[] result = new int[t.length];
        for (int i = 0; i < t.length;i++) {
            if (groupSizes.containsKey(t[i])) {
                result[i] = groupSizes.get(t[i]);
            }
        }
        return result;
    }

    @Test
    public void testCountGroups() {
        int[][] groups1 = new int[][]{
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 1}
        };


        countGroups(groups1, new int[]{1, 2, 3, 4, 5});
    }
}
