package net.roostertech.algorithm.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by pnguyen on 11/21/17.
 */
public class UniquePermutation {

    HashSet<ArrayList<Integer>> permutations = new HashSet<>();
    /**
     * NOT thread safe
     * @param a
     * @return
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        permutations.clear();
        permuteRecursive(a);

        ArrayList[] permsArray = permutations.toArray(new ArrayList[permutations.size()]);
        return  new ArrayList(Arrays.asList(permsArray));
    }

    public void permuteRecursive(ArrayList<Integer> a) {
        permuteRecursive(new ArrayList<>(), a);
    }

    public void permuteRecursive(ArrayList<Integer> prefix, ArrayList<Integer> a) {
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
            permuteRecursive(newPrefix, newRemain);
        }
    }
}
