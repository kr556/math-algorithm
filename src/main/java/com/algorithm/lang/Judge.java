package com.algorithm.lang;

public class Judge {
    public static boolean isInteger(int value) {
        return true;
    }
    public static boolean isInteger(long value) {
        return true;
    }
    public static boolean isInteger(double value) {
        if (value == Double.POSITIVE_INFINITY || value == Double.NEGATIVE_INFINITY) {
            return true;
        }
        return value % 1D == 0D;
    }
    public static boolean isInteger(float value) {
        return isInteger((double) value);
    }
    public static boolean isInteger(String value) {
        return false;
    }
    public static boolean isDouble(int value) {
        return false;
    }
    public static boolean isDouble(long value) {
        return false;
    }
    public static boolean isDouble(double value) {
        return !isInteger(value);
    }
    public static boolean isDouble(float value) {
        return !isInteger(value);
    }
    public static boolean isDouble(String value) {
        return false;
    }
    public static boolean isFloat(int value) {
        return false;
    }
    public static boolean isFloat(long value) {
        return false;
    }
    public static boolean isFloat(double value) {
        return !isInteger(value);
    }
    public static boolean isFloat(float value) {
        return !isInteger(value);
    }
    public static boolean isFloat(String value) {
        return false;
    }
}
