package com.algorithm.math;

import com.algorithm.lang.error.IllegalValueException;

public class MathFunc extends Thread {
    public static final RoundOff roundOff = new RoundOff();
    /**
     * The Greatest Common Divisor.
     */
    public static long gcd(long a, long b) {
        long re;

        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0) {
            return Math.max(a, b);
        }

        while(a % b != 0) {
            re = a % b;
            a = b;
            b = re;
        }
        return b;
    }

    /**
     * The Least Common mMultiple
     */
    public static long lcm(long a, long b) {
        long c,re = a * b;

        while(a % b != 0) {
            c = a % b;
            a = b;
            b = c;
        }

        return re / b;
    }

    public static int factorial(int bound) {
        if (bound < 0) {
            throw new IllegalValueException("Can not use negative number.");
        }
        int re = 1;
        for (int i = 1; i < bound; i++) {
            re *= i;
        }
        return re;
    }
    public static double summation(long first, long end, NormalFunc fun, double... var) {
        double re = 0;
        for (long l = first; l <= end; l++) {
            re += fun.func(l,var);
        }
        return re;
    }
    public static Matrix matrix(double[][] element) {
        return new Matrix(element);
    }
    public static Matrix matrix(int[][] element) {
        return new Matrix(element);
    }
}
