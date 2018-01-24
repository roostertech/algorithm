package net.roostertech.algorithm.graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CaptureRegion {

    /**
     * Mark this spot and all spot corrected to it with a # to indicate none-capturable region
     */
    void mergeRegion(int row, int column, ArrayList<ArrayList<Character>> board) {
        if (row < 0 || row >= board.size() || column < 0 || column >= board.get(0).size()) {
            return;
        }

        if (board.get(row).get(column) != 'O') {
            return;
        } else {
            board.get(row).set(column, '#');
        }

        // up
        mergeRegion(row - 1, column, board);

        // down
        mergeRegion(row + 1, column, board);

        // left
        mergeRegion(row, column - 1, board);

        // right
        mergeRegion(row, column + 1, board);
    }



    public void solve(ArrayList<ArrayList<Character>> a) {
        int rowCnt = a.size();
        int colCnt = a.get(0).size();
        int[][] board = new int[rowCnt][colCnt];

        // find any O along the edges as any region connected to it is not capturable
        for (int row = 0; row < rowCnt; row++) {
            if (a.get(row).get(0) == 'O') {
                mergeRegion(row, 0, a);
            }
            if (a.get(row).get(colCnt - 1) == 'O') {
                mergeRegion(row, colCnt - 1, a);
            }

        }
        for (int col = 0; col < colCnt; col++) {
            if (a.get(0).get(col) == 'O') {
                mergeRegion(0, col, a);
            }
            if (a.get(rowCnt - 1).get(col) == 'O') {
                mergeRegion(rowCnt - 1, col, a);
            }
        }

        // now flip O -> X, and # to O
        for (int row = 0; row < rowCnt; row++) {
            ArrayList<Character> charRow = a.get(row);
            for (int col = 0; col < colCnt; col++) {
                if (charRow.get(col) == 'O') {
                    charRow.set(col, 'X');
                } else if (charRow.get(col) == '#') {
                    charRow.set(col, 'O');
                }
            }
        }
    }

    @Test
    public void testCapture() {
        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        board.add(new ArrayList<Character>(Arrays.asList('X','X','X')));
        board.add(new ArrayList<Character>(Arrays.asList('X','O','X')));
        board.add(new ArrayList<Character>(Arrays.asList('X','X','X')));
        board.add(new ArrayList<Character>(Arrays.asList('X','O','X')));
        solve(board);
        System.out.println(board);


        ArrayList<ArrayList<Character>> board2 = new ArrayList<>();
        board2.add(new ArrayList<Character>("XOOOOOOX".chars().mapToObj((c) -> Character.valueOf((char) c)).collect(Collectors.toList())));
        board2.add(new ArrayList<Character>("XXOOXOOX".chars().mapToObj((c) -> Character.valueOf((char) c)).collect(Collectors.toList())));
        board2.add(new ArrayList<Character>("OXXOXOXX".chars().mapToObj((c) -> Character.valueOf((char) c)).collect(Collectors.toList())));
        solve(board2);
        System.out.println(board2);

        ArrayList<ArrayList<Character>> board3 = new ArrayList<>();
        board3.add(new ArrayList<Character>("XOXXXXOOXX".chars().mapToObj((c) -> Character.valueOf((char) c)).collect(Collectors.toList())));
        board3.add(new ArrayList<Character>("XOOOOXOOXX".chars().mapToObj((c) -> Character.valueOf((char) c)).collect(Collectors.toList())));
        board3.add(new ArrayList<Character>("OXXOOXXXOO".chars().mapToObj((c) -> Character.valueOf((char) c)).collect(Collectors.toList())));
        board3.add(new ArrayList<Character>("OXOXOOOXXO".chars().mapToObj((c) -> Character.valueOf((char) c)).collect(Collectors.toList())));
        board3.add(new ArrayList<Character>("OXOOXXOOXX".chars().mapToObj((c) -> Character.valueOf((char) c)).collect(Collectors.toList())));
        board3.add(new ArrayList<Character>("OXXXOXXOXO".chars().mapToObj((c) -> Character.valueOf((char) c)).collect(Collectors.toList())));
        board3.add(new ArrayList<Character>("OOXXXXOXOO".chars().mapToObj((c) -> Character.valueOf((char) c)).collect(Collectors.toList())));

        solve(board3);

        System.out.println(board3);
    }
}
