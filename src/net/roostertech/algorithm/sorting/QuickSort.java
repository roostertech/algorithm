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
//        quickSort(new int[]{11, 4, 6, 12, 7, 8, 2, 10}, 0, 7);

        int[] data = new int[]{97, 86, 67, 19, 107, 9, 8, 49, 23, 46, -4, 22, 72, 4, 57, 111, 20, 52, 99, 2, 113, 81, 7, 5, 21, 0, 47, 54, 76, 117, -2, 102, 34, 12, 103, 69, 36, 51, 105, -3, 33, 91, 37, 11, 48, 106, 109, 45, 58, 77, 104, 60, 75, 90, 3, 62, 16, 119, 85, 63, 87, 43, 74, 13, 95, 94, 56, 28, 55, 66, 92, 79, 27, 42, 70};

        quickSort(data, 0, data.length  - 1);
    }

}
