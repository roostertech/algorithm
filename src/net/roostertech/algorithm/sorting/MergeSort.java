package net.roostertech.algorithm.sorting;

import org.junit.Test;

import java.util.Arrays;

public class MergeSort {

    private void merge (int[] data, int left, int mid, int right) {

        // copy data into tmp space
        int[] leftTmp = new int[mid - left +1];
        int[] rightTmp = new int[right - mid];
        System.arraycopy(data, left, leftTmp, 0, mid - left + 1);
        System.arraycopy(data, mid+1, rightTmp, 0, right - mid);


        int index = left;
        int leftIndex = 0;
        int rightIndex = 0;

        //merge
        while (index < right) {
            if (leftIndex >= leftTmp.length || rightIndex >= rightTmp.length) {
                break;
            }

            if (leftTmp[leftIndex] <= rightTmp[rightIndex]) {
                data[index++] =  leftTmp[leftIndex++];
            } else if (leftTmp[leftIndex] > rightTmp[rightIndex]) {
                data[index++] =  rightTmp[rightIndex++];
            }
        }

        // remaining
        while (leftIndex < leftTmp.length) {
            data[index++] =  leftTmp[leftIndex++];
        }
        while (rightIndex < rightTmp.length) {
            data[index++] =  rightTmp[rightIndex++];
        }
    }

    private void sort (int[] data, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + ((right - left) / 2);

        sort(data, left, mid);
        sort(data, mid+1, right);

        merge(data, left, mid, right);
    }

    public int[] mergeSort (int[] data) {
        sort(data, 0, data.length -1);

        return data;
    }

    @Test
    public void testMergeSort() {
        System.out.println(Arrays.toString(mergeSort(new int[]{3,2,1})));
        System.out.println(Arrays.toString(mergeSort(new int[]{5,3,6333,1,65,4,53,1,35,99,65,2,1})));
    }

}
