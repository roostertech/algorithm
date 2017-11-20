package net.roostertech.algorithm.math;

/**
 * Created by pnguyen on 11/20/17.
 *
 * Compute and return the square root of x.
 * If x is not a perfect square, return floor(sqrt(x))
 */
public class SquareRoot {
    public int sqrt(int input) {
        if (input == 0 || input == 1)
            return input;
        long a = 0;
        long b = input;
        while (Math.abs(a - b) > 1) {
            a = (a + b) / 2;
            b = input / a;
        }
        if (a * a > input) {
            return (int) (a - 1);
        }
        return (int) a;
    }
}
