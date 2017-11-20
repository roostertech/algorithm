package net.roostertech.algorithm.binarysearch;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by pnguyen on 11/20/17.
 */
public class MatrixSearchTest {
    @Test
    public void matrixSearch() {
        MatrixSearch search = new MatrixSearch();

        ArrayList<ArrayList<Integer>> data = new ArrayList<>();

        data.add(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5)));
        data.add(new ArrayList<Integer>(Arrays.asList(6,7,9,10)));
        data.add(new ArrayList<Integer>(Arrays.asList(100,200,1000)));

        Assert.assertEquals(1, search.searchMatrix(data, 1));
        Assert.assertEquals(1, search.searchMatrix(data, 9));
        Assert.assertEquals(1, search.searchMatrix(data, 200));
        Assert.assertEquals(0, search.searchMatrix(data, 101));
        Assert.assertEquals(0, search.searchMatrix(data, 8));
        Assert.assertEquals(0, search.searchMatrix(data, 300));


    }
}
