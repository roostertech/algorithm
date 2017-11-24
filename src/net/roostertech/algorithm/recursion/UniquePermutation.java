package net.roostertech.algorithm.recursion;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by pnguyen on 11/21/17.
 https://www.interviewbit.com/problems/all-unique-permutations/
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 */
public class UniquePermutation {

    private static void permuteRecursive(HashSet<ArrayList<Integer>> permutations, ArrayList<Integer> a) {
        permuteRecursive(permutations, new ArrayList<>(), a);
    }

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        HashSet<ArrayList<Integer>> permutations = new HashSet<>();

        permuteRecursive(permutations, a);

        ArrayList[] permsArray = permutations.toArray(new ArrayList[permutations.size()]);
        return  new ArrayList(Arrays.asList(permsArray));
    }


    private static void permuteRecursive(HashSet<ArrayList<Integer>> permutations, ArrayList<Integer> prefix, ArrayList<Integer> a) {
        int len = a.size();
        if (len == 0) {
            permutations.add(prefix);
            return;
        }
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> newPrefix = new ArrayList<>(prefix);
            newPrefix.add(a.get(i));
            ArrayList<Integer> newRemain = new ArrayList<>(a);
            newRemain.remove(i);
            permuteRecursive(permutations, newPrefix, newRemain);
        }
    }

    @Test
    public void permutationsRecursive() {
        UniquePermutation.permute(new ArrayList<>(Arrays.asList(1,2,3)));

        ArrayList<ArrayList<Integer>> result = UniquePermutation.permute(new ArrayList<>(Arrays.asList(1,1,2)));

        System.out.println(result.size());
        System.out.println(result);
        Assert.assertEquals(3, result.size());
    }
}
