package com.algorithm.math;

public class RoundOff {
    public int _09to1(double var) {
        if (var - (int) var < 0.9) {
            return (int) var;
        } else {
            return (int) var + 1;
        }
    }
    public int _08to1(double var) {
        if (var - (int) var < 0.8) {
            return (int) var;
        } else {
            return (int) var + 1;
        }
    }
    public int _07to1(double var) {
        if (var - (int) var < 0.7) {
            return (int) var;
        } else {
            return (int) var + 1;
        }
    }
    public int _06to1(double var) {
        if (var - (int) var < 0.6) {
            return (int) var;
        } else {
            return (int) var + 1;
        }
    }
    public int _05to1(double var) {
        if (var - (int) var < 0.5) {
            return (int) var;
        } else {
            return (int) var + 1;
        }
    }
    public int _04to1(double var) {
        if (var - (int) var < 0.4) {
            return (int) var;
        } else {
            return (int) var + 1;
        }
    }
    public int _03to1(double var) {
        if (var - (int) var < 0.3) {
            return (int) var;
        } else {
            return (int) var + 1;
        }
    }
    public int _02to1(double var) {
        if (var - (int) var < 0.2) {
            return (int) var;
        } else {
            return (int) var + 1;
        }
    }
    public int _01to1(double var) {
        if (var - (int) var < 0.1) {
            return (int) var;
        } else {
            return (int) var + 1;
        }
    }
    public int _00to1(double var) {
        if (var - (int) var == 0D) {
            return (int) var;
        } else {
            return (int) var + 1;
        }
    }
}
