package net.roostertech.algorithm.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by pnguyen on 11/24/17.
 https://www.interviewbit.com/problems/wave-array/
 */
public class WaveArray {

    static void swap(Integer []array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    static int partition(Integer []array, int left, int right, int pivot) {
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

    static void quickSort(Integer[] data, int left, int right) {
        if (left < right) {
            int pivot = data[left + (right-left)/2];
            int partition = partition(data, left, right, pivot);

            quickSort(data, left, partition -1);
            quickSort(data, partition, right);
        }
//        System.out.println(Arrays.toString(data));
    }

    public static ArrayList<Integer> wave(ArrayList<Integer> a) {
        Integer[] arr = a.toArray(new Integer[a.size()]);

        quickSort(arr, 0, arr.length-1);

        for (int i = 0; i + 1 < arr.length; i+=2) {
            swap(arr, i, i+1);
        }
        return new ArrayList<Integer>(Arrays.asList(arr));
    };


    @Test
    public void testWave() {
        System.out.println(wave(new ArrayList<>(Arrays.asList(5,7,1,2,4))));
        System.out.println(wave(new ArrayList<>(Arrays.asList())));
        System.out.println(wave(new ArrayList<>(Arrays.asList(5))));
    }
}
