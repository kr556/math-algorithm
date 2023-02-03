package com.algorithm.lang.print;

import com.algorithm.lang.Judge;
import com.algorithm.math.Frac;
import com.algorithm.math.Matrix;

import java.io.PrintStream;
import java.util.Locale;

/**
 * Use for debug.
 */
public class Print {
    public static final TimePrint time = new TimePrint();

    public static void print(boolean b) {
        System.out.print(b);
    }
    public static void print(char c) {
        System.out.print(c);
    }
    public static void print(int i) {
        System.out.print(i);
    }
    public static void print(long l) {
        System.out.print(l);
    }
    public static void print(float f) {
        System.out.print(f);
    }
    public static void print(double d) {
        System.out.print(d);
    }
    public static void print(char[] c) {
        System.out.print(c);
    }
    public static void print(String s) {
        System.out.print(s);
    }
    public static void print(Object o) {
        System.out.print(o);
    }

    public static void println(boolean b) {
        System.out.println(b);
    }
    public static void println(char c) {
        System.out.println(c);
    }
    public static void println(int i) {
        System.out.println(i);
    }
    public static void println(long l) {
        System.out.println(l);
    }
    public static void println(float f) {
        System.out.println(f);
    }
    public static void println(double d) {
        System.out.println(d);
    }
    public static void println(char[] c) {
        System.out.println(c);
    }
    public static void println(String s) {
        System.out.println(s);
    }
    public static void println(Object o) {
        System.out.println(o);
    }

    public static PrintStream printf(String fomat, Object... o) {
        return System.out.printf(fomat, o);
    }
    public static PrintStream printf(Locale l, String fomat, Object... o) {
        return System.out.printf(l, fomat, o);
    }

    public static void frac(Frac frac) {
        System.out.println(frac.getNum() + "/" + frac.getDen());
    }

    public static void matrix(Matrix matrix) {
        for (int y = 0; y < matrix.getRowsQuantity(); y++) {
            for (int x = 0; x < matrix.getColumnsQuantity(); x++) {
                if (matrix.getElement(x, y).toDouble() == Double.POSITIVE_INFINITY ||
                        matrix.getElement(x, y).toDouble() == Double.NEGATIVE_INFINITY) {
                    System.out.printf("%-6s", "inf");
                } else {
                    System.out.printf(Judge.isInteger(matrix.getElement(x, y).toDouble()) ? "%-6d" : "%d/", matrix.getElement(x, y).getNum());
                    System.out.printf(Judge.isInteger(matrix.getElement(x, y).toDouble()) ? "" : "%-4d", (int) matrix.getElement(x, y).getDen());
                }
            }
            System.out.println("\n\n");
        }
    }


}
