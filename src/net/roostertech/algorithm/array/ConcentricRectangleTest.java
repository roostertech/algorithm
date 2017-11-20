package net.roostertech.algorithm.array;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by pnguyen on 11/20/17.
 */
public class ConcentricRectangleTest {
    ConcentricRectangle alg;

    @Before
    public void setup() {
        alg = new ConcentricRectangle();

    }

    @Test
    public void rects() {
        printRect(alg.prettyPrint(1));
        printRect(alg.prettyPrint(2));
        printRect(alg.prettyPrint(3));
        printRect(alg.prettyPrint(4));
    }

    void printRect(ArrayList<ArrayList<Integer>> rect) {
        for (ArrayList<Integer> row : rect) {
            for (int data : row) {
                System.out.print(data);
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

}
