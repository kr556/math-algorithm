package com.algorithm.lang.print;

public final class TimePrint {
    public void microSecond(long start, long end) {
        System.out.printf("%f", (double)(end - start) / 10E3D);
    }
    public void milliSecond(long start, long end) {
        System.out.printf("%f", (double)(end - start) / 10E6D);
    }
    public void second(long start, long end) {
        System.out.printf("%f", (double)(end - start) / 10E9D);
    }
    public void minute(long start, long end) {
        System.out.printf("%f", (double)(end - start) / 600E9D);
    }
    public void hour(long start, long end) {
        System.out.printf("%f", (double)(end - start) / 3600E9D);
    }
    public void day(long start, long end) {
        System.out.printf("%f", (double)(end - start) / 3600E9D / 24);
    }
}
