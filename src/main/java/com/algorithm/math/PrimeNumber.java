package com.algorithm.math;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber extends Thread{
    public static boolean isPrime(long value) {
        if (value == 2 || value == 5) {
            return true;
        } else if (value < 2 || value % 2 == 0 || value % 5 == 0) {
            return false;
        }


        if (value % 3 == 0) {
            return false;
        }

        double sq = Math.sqrt(value);
        for (long l1 = 5; l1 <= sq; l1 += 4) {
            for (byte l2 = 0; l2 <= 2; l2 += 2) {
                l1 += l2;
                if (value % l1 == 0D) { // 素数で割ったときの余りが0のとき
                    return false;
                }
            }
        }
        return true;
    }
    public static List<Long> range(long min, long max) {
        List<Long> re = new ArrayList<>();

        if (min % 2L == 0) {
            min++;
        } else if (min != 5 && (min % 5L == 0 || min == 1L))  {
            if (min <= 1 && max >= 2) {
                re.add(2L);
            }
            min += 2;
        }

        while (true) {
            if (min % 6L != 0 && min != 3) {
                min++;
            } else if (min % 6L == 0) {
                min--;
                break;
            } else if (min == 3) {
                break;
            }
        }

        if (min == 3) {
            re.add(3L);
            min = 5;
        }


        lp : for (long num = min;; num += 4) {
            for (byte _num = 0; _num <= 2; _num += 2) {
                num += _num;

                if (num > max) {
                    break lp;
                }
                System.out.print(num + ":");
                System.out.println(isPrime(num));
                if (isPrime(num)) {
                    re.add(num);
                }
            }
        }
        return re;
    }
}