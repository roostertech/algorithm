package net.roostertech.algorithm.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class GrayCode {
    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> codes = new ArrayList<>();
        if (a <= 0) {
            return codes;
        }

        codes.add(0);
        codes.add(1);

        for (int i = 1; i < a; i++) {
            addBit(codes, i);
        }

        return codes;
    }

    private void addBit(ArrayList<Integer> codes, int bitNum) {
        ArrayList<Integer> newBit = new ArrayList<>(codes);
        Collections.reverse(newBit);
        for (int i = 0; i < newBit.size(); i++) {
            int newValue = newBit.get(i) + (int)Math.pow(2, bitNum);
//            System.out.println("old " + Integer.toBinaryString(newBit.get(i)) + " new " + Integer.toBinaryString(newValue));
            newBit.set(i, newValue);
        }

        codes.addAll(newBit);
    }

    private void printBinaryArray(ArrayList<Integer> codes) {
        for (Integer code: codes) {
            System.out.println(Integer.toBinaryString(code));
        }
    }

    @Test
    public void testGrayRCode() {
        printBinaryArray(grayCode(3));
    }

}
