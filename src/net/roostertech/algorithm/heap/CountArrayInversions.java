package net.roostertech.algorithm.heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

// https://www.interviewbit.com/problems/inversions/
// https://www.geeksforgeeks.org/counting-inversions/
public class CountArrayInversions {
    public int countInversionsMapMethod(ArrayList<Integer> input) {

        TreeMap<Integer, ArrayList<Integer>> indexMap = new TreeMap<>();

        for (int i = 0; i < input.size(); i++) {
            int num = input.get(i);
            if (!indexMap.containsKey(num)) {
                indexMap.put(num, new ArrayList<>());
            }
            indexMap.get(num).add(i);
        }
        ArrayList<Integer> keys = new ArrayList<>(indexMap.keySet());

        int inversions = 0;
        for (int i = 0; i < keys.size(); i++) {
            ArrayList<Integer> indexes = indexMap.get(keys.get(i));
            for (int j = i + 1; j < keys.size(); j++) {
                ArrayList<Integer> otherIndexes = indexMap.get(keys.get(j));

                for (int i1 = 0; i1 < indexes.size(); i1++) {
                    for (int i2 = 0; i2 < otherIndexes.size(); i2++) {
                        if (otherIndexes.get(i2) < indexes.get(i1)) {
                            inversions++;
                        }
                    }
                }
//                System.out.println(keys.get(i) + "->" + indexes + " " + keys.get(j) + "->"+ otherIndexes + " " + inversions);
            }
        }
        return inversions;
    }

    /**
     * Use mergesort
     */
    public int countInversions(ArrayList<Integer> A) {
        int[] input = A.stream().mapToInt(Integer::intValue).toArray();
        int[] tmp = new int[input.length];


        return mergeSort(input, tmp, 0, input.length - 1);
    }

    int mergeSort(int[] input, int[] tmp, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int invCount = 0;

        int mid = left + (right - left) / 2;

        invCount += mergeSort(input, tmp, left, mid);
        invCount += mergeSort(input, tmp, mid + 1, right);

        invCount += merge(input, tmp, left, mid + 1, right);

//        System.out.println(Arrays.toString(input));
        return invCount;
    }

    int merge(int[] input, int[] tmp, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid;
        int mergedIndex = left;
//        System.out.println(Arrays.toString(input));
        int invCount = 0;
        while (leftIndex < mid && rightIndex <= right) {
            if (input[leftIndex] <= input[rightIndex]) {
                tmp[mergedIndex++] = input[leftIndex++];
            } else {
                tmp[mergedIndex++] = input[rightIndex++];
                invCount += mid - leftIndex;
//                System.out.println(mid - leftIndex);
            }
        }

        for (; leftIndex < mid; leftIndex++) {
            tmp[mergedIndex++] = input[leftIndex];
        }

        for (; rightIndex <= right; rightIndex++) {
            tmp[mergedIndex++] = input[rightIndex];
        }

        for (int i = left; i <= right; i++) {
            input[i] = tmp[i];
        }

        return invCount;
    }


    @Test
    public void testInversion() {
        Assert.assertEquals(14, countInversions(new ArrayList<>(Arrays.asList(8, 8, 9, 9, 9, 9, 9, 1, 1))));
        Assert.assertEquals(3, countInversions(new ArrayList<>(Arrays.asList(2, 4, 1, 3, 5))));
        Assert.assertEquals(290, countInversions(new ArrayList<>(Arrays.asList(84, 2, 37, 3, 67, 82, 19, 97, 91, 63, 27, 6, 13, 90, 63, 89, 100, 60, 47, 96, 54, 26, 64, 50, 71, 16, 6, 40, 84, 93, 67, 85, 16, 22, 60))));
    }



}
