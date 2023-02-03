package com.algorithm.math;

import com.algorithm.lang.Judge;
import com.algorithm.lang.error.IllegalFractionValueException;
import com.algorithm.lang.print.Print;

/**
 * Fraction ※栗修正
 */
public class Frac {
    /**
     * 分子
     */
    public long num,
    /**
     * 分母
     */
                den;
    public double numSqrt = 1D,
                    denSqrt = 1D;

    public static final Frac POSITIVE_INFINITY = new Frac(1, 0),
            NEGATIVE_INFINITY = new Frac(-1, 0),
            ZERO = new Frac(0, 1),
            INDEFINE_ZERO = new Frac(0, 0),
            NORMAL = new Frac(1, 1);

    public static Frac toFrac(double value) {
        long i = 1;
        if (value == Double.POSITIVE_INFINITY ||
                value == Double.NEGATIVE_INFINITY) {
            return value == Double.POSITIVE_INFINITY ?
                    new Frac(1, 0) : new Frac(-1, 0);
        }
        while (!Judge.isInteger(value)) {
            value *= 10;
            i *= 10;
        }
        long g = MathFunc.gcd(i, (long) value);
        return new Frac((long) value / g, i / g);
    }
    public static Frac toFrac(int value) {
        return new Frac(value, 1);
    }
    public static Frac toFrac(long value) {
        return new Frac(value, 1);
    }

    public Frac(double value) {
        set(value);
    }

    public Frac(long numer, long denominator) {
        if (numer == 0) {
            den = den > 0 ?
                    1 : -1;
        } else if (denominator == 0) {
            num = num > 0 ?
                    1 : -1;
        } else {
            num = numer;
            den = denominator;
        }
    }
    public Frac(long numer, Frac denominator) {
        den = denominator.getNum();
        num = numer * denominator.getDen();
        arrangeFormat();
    }
    public Frac(Frac numer, long denominator) {
        num = numer.num;
        den = denominator * numer.den;
        arrangeFormat();
    }
    public Frac(Frac numer, Frac denominator) {
        Frac f = numer.div(denominator);
        num = f.num;
        den = f.den;
        arrangeFormat();
    }

    public void set(long numer, long denominator) {
        num = numer;
        den = denominator;
    }

    public void set(Frac fraction) {
        set(fraction.getNum(), fraction.getDen());
    }

    public void set(long value) {
        set(value, 1);
    }

    public void set(double value) {
        set(Frac.toFrac(value));
    }

    /**
     * @return 分母
     */
    public long getDen() {
        return den;
    }

    /**
     * @return 分子
     */
    public long getNum() {
        return num;
    }
    /**
     * 逆数
     */
    public static Frac reciprocal(Frac fraction) {
        return new Frac(fraction.getDen(), fraction.getNum());
    }

    /**
     * 逆数
     */
    public static Frac reciprocal(long value) {
        return new Frac(1L, value);
    }

    /**
     * 逆数
     */
    public Frac reciprocal() {
        return new Frac(getDen(), getNum());
    }

    /**
     * 加算
     * Additon
     */
    public Frac adi(Frac fraction) {
        this.arrangeFormat();
        fraction.arrangeFormat();

        Print.frac(fraction);                   //del
        Print.println(fraction.isInfinity());   //del

        if ((this.equals(POSITIVE_INFINITY) && fraction.equals(NEGATIVE_INFINITY)) ||
                (this.equals(NEGATIVE_INFINITY) && fraction.equals(POSITIVE_INFINITY))) {   // 無限大の処理
            throw new IllegalFractionValueException(" infinity");
        } else if (this.isInfinity()) {
            Print.println(fraction.toDouble());     //del
            Print.println(fraction.isPositive());   //del
            Print.println("inf");
            return this.isPositive() ?
                    POSITIVE_INFINITY : NEGATIVE_INFINITY;
        } else if (fraction.isInfinity()) {
            return fraction.isPositive() ?
                    POSITIVE_INFINITY : NEGATIVE_INFINITY;
        }

        DoubleFrac df = reduce(this,fraction);
        Frac re = new Frac(df.getFirstArg().getNum() + df.getSecondArg().getNum(),
                df.getFirstArg().getDen());
        re.arrangeSign();
        return re;
    }

    /**
     * 加算
     * Additon
     */
    public Frac adi(long value) {
        return adi(toFrac((double) value));
    }

    /**
     * 加算
     * Additon
     */
    public Frac adi(double value) {
        return adi(toFrac(value));
    }

    /**
     * 減算
     * Subtraction
     */
    public Frac sub(Frac fraction) {
        return adi(fraction.mul(-1));
    }
    /**
     * 乗算
     * Multiplication
     */
    public Frac mul(Frac fraction) {
        return new Frac(getNum() * fraction.getNum(),
                getDen() * fraction.getDen());
    }

    public Frac mul(long mol, long den) {
        return new Frac(getNum() * mol,
                getDen() * den);
    }

    public Frac mul(long l) {
        return new Frac(getNum() * l,
                getDen());
    }

    /**
     * 除算
     * Division
     */
    public Frac div(Frac fraction) {
        return mul(fraction.reciprocal()).reduction();
    }

    /**
     * 約分
     */
    public Frac reduction() {
        if (this.equals(ZERO)) {
            return ZERO;
        } else if (this.num != 0 || this.den == 0) {
            return this.num > 0 ?
                    POSITIVE_INFINITY : NEGATIVE_INFINITY;
        } else if (this.equals(ZERO)) {
            return ZERO;
        } else if (this.equals(INDEFINE_ZERO)) {
            throw new IllegalFractionValueException(" zero/zero");
        }
        long l = MathFunc.gcd(getNum(), getDen());
        return new Frac(getNum() / l, getDen() / l);
    }

    /**
     * 通分
     */
    public static DoubleFrac reduce(Frac a, Frac b) {
        if (a.isInfinity() || b.isInfinity()) {
            return new DoubleFrac(a, b);
        }
        long l;
        try {
            l = MathFunc.lcm(a.getDen(), b.getDen());
        } catch (ArithmeticException e) {
            return a.isInfinity() ?
                    new DoubleFrac(a, NORMAL) :
                    new DoubleFrac(NORMAL, b);
        }
        return new DoubleFrac(new Frac(a.getNum() * (l / a.getDen()), l),
                new Frac(b.getNum() * (l / b.getDen()), l));
    }

    /**
     * 符号を整える。
     */
    public Frac arrangeSign() {
        if (num == 0) {
            return ZERO;
        } else if ((num < 0 && den <= 0) ||
                (num > 0 && den >= 0)) {
            return new Frac(
                    num < 0 ? num * -1 : num,
                    den < 0 ? den * -1 : den);
        } else {
            return this;
        }
    }

    /**
     * 符号だけでなく訳文とかもして最小の状態にする。
     */
    public Frac arrangeFormat() {
        return arrangeSign().reduction();
    }

    public boolean equals(Frac frac) {
        return getNum() == frac.getNum() &&
                getDen() == frac.getDen();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int toInteger() {
        return MathFunc.roundOff._05to1(toDouble());
    }

    public double toDouble() {
        double ren;
        if ((double) num / (double)den == Double.POSITIVE_INFINITY ||
                (double) num / (double) den == Double.NEGATIVE_INFINITY) {
            ren = (double) num /(double) den == Double.POSITIVE_INFINITY ?
                    Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
            return ren;
        } else if (num == 0) {
            return 0D;
        }
        return (double) num / (double) den;
    }

    /**
     * @return {@link FracContents#NOMAL} -> Except that<br>
     * {@link FracContents#POSITIVE_INFINITY} -> Positive infinity<br>
     * {@link FracContents#NEGATIVE_INFINITY} -> Negative infinity<br>
     */
    public boolean isInfinity() {
        return this.equals(POSITIVE_INFINITY) ||
                this.equals(NEGATIVE_INFINITY);
    }

    public boolean isPositive() {
        return (num > 0 && den > 0) ||
                (num < 0 && den < 0) ||
                (num > 0 && den == 0);
    }
    public boolean isNegative() {
        return (num < 0 && den >= 0) ||
                (num > 0 && den <= 0) ||
                (num < 0 && den == 0);
    }

    /**
     * 通分した値を返すためのクラス。double型のDoubleではない。
     */
    public record DoubleFrac(Frac a, Frac b) {
        public Frac getFirstArg() {
                return a;
            }
        public Frac getSecondArg() {
                return b;
            }
    }
}
