package net.roostertech.algorithm.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Knight {

    class Cell {
        int x;
        int y;
        int dis;

        public Cell(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    //N, M, x1, y1, x2, y2
    //where N and M are size of chess board
    //x1, y1  coordinates of source point
    //x2, y2  coordinates of destination point

    public int knight(int N, int M, int x1, int y1, int x2, int y2) {
        // steps that knight can move
        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};

        // start at 0 instead of 1
        x1 -= 1;
        y1 -= 1;
        x2 -= 1;
        y2 -= 1;

        Queue<Cell> moveQueue = new LinkedList<>();
        boolean visited[][] = new boolean[N][M];

        // initial position
        visited[x1][y1] = true;

        moveQueue.offer(new Cell(x1, y1, 0));

        while (!moveQueue.isEmpty()) {
            Cell cell = moveQueue.poll();
            if (cell.x == x2 && cell.y == y2) {
                return cell.dis;
            }

            for (int i = 0; i < 8; i++) {
                int moveX = cell.x + dx[i];
                int moveY = cell.y + dy[i];
                if (isInside(moveX, moveY, N, M) && !visited[moveX][moveY]) {
                    System.out.println(cell.x + "," + cell.y  + " -> " + moveX + ","+ moveY);
                    visited[moveX][moveY] = true;
                    moveQueue.offer(new Cell(moveX, moveY, cell.dis + 1));
                }
            }
        }

        return -1;
    }


    boolean isInside(int x, int y, int N, int M) {
        return x >= 0 && x < N && y >=0 && y < M;
    }

    @Test
    public void testKnight() {
//        Assert.assertEquals(6, knight(8, 8, 1, 1, 8,8));
//        Assert.assertEquals(2, knight(4, 7, 2, 6, 2, 4));
        Assert.assertEquals(3, knight(3, 11, 3, 11, 2, 11));

    }
}
