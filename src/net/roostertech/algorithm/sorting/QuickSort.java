package net.roostertech.algorithm.sorting;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by pnguyen on 11/23/17.
 */
public class QuickSort {
    static void swap(int []array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    static int partition(int []array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    static void quickSort(int[] data, int left, int right) {
        if (left < right) {
            int pivot = data[left + (right-left)/2];
            int partition = partition(data, left, right, pivot);

            quickSort(data, left, partition -1);
            quickSort(data, partition, right);
        }
        System.out.println(Arrays.toString(data));
    }

    @Test
    public void sort() {
        quickSort(new int[]{11, 4, 6, 12, 7, 8, 2, 10}, 0, 7);
    }

}
