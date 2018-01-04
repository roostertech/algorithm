package net.roostertech.algorithm.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {
    private boolean checkISSafe(int[][] board, int row, int column) {

        // check to the left, right side should be empty
        for (int i = 0; i < column; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // check to upper left
        for (int i = row,  j = column; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        //check to lower right
        for (int i = row,  j = column; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }


    ArrayList<ArrayList<String>> results = new ArrayList<>();

    private void captureResult(int board[][]) {
        ArrayList<String> solution = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            StringBuilder rowBuilder = new StringBuilder();
            for (int column = 0; column < board.length; column++) {
                if (board[row][column] == 1) {
                    rowBuilder.append("Q");
                } else {
                    rowBuilder.append(".");
                }
            }
            solution.add(rowBuilder.toString());
        }
        results.add(solution);
    }

    private boolean trySolve(int board[][], int column) {
        // all queens placed
        if (column >= board.length) {
            captureResult(board);
            return true;
        }

        // find a row that can solve the solution
        for (int row = 0; row < board.length; row++) {
            if (checkISSafe(board, row, column)) {
                // try to place
                board[row][column] = 1;

                trySolve(board, column+1);

                //backtrack and try another row
                board[row][column] = 0;
            }
        }

        // could not find placement
        return false;
    }

    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        results = new ArrayList<>();
        int [][] board = new int[a][a];

        trySolve(board, 0);
        return results;
    }

    @Test
    public void testNQueens() {
        solveNQueens(2);

        System.out.println(results);
    }
}
