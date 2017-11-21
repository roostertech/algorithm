package net.roostertech.algorithm.math;

/**
 * Created by pnguyen on 11/21/17.
 Implement pow(A, B) % C.

 In other words, given A, B and C,
 find (AB)%C.

 Input : A = 2, B = 3, C = 3
 Return : 2
 2^3 % 3 = 8 % 3 = 2

 (a * b) % m = ((a % m) * (b % m)) % m
 Note Math.floormod is different than java % (remainder(
 */
public class ModularExponentiation {
    public int mod(int a, int b, int c) {
        if (a == 0) {
            return 0;
        }

        if (b == 0) {
            return 1;
        }

        long y;
        if (b % 2 == 0) {
            // even
            y = mod(a, b / 2, c);
            y = (y * y) % c;
        } else {
            // odd
            y = a % c;
            y = (y  * mod(a, b - 1, c)) % c;
        }
        return (int) ((y + c) % c);
    }
}
