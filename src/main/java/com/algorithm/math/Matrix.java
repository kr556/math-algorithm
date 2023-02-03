package com.algorithm.math;

import com.algorithm.lang.error.IllegalValueException;
import com.algorithm.lang.error.MismachSizeOfMatrixException;

public class Matrix {
    private final Frac[][] element;

    /**
     * @param bound Rows size and colume size.
     * @return Identity matrix set size by bound.
     */
    public static Matrix identity(int bound) {
        Frac[][] _re = new Frac[bound][bound];
        for (int y = 0; y < bound; y++) {
            for (int x = 0; x < bound; x++) {
                _re[y][x] = new Frac(x == y ? 1 : 0, 1);
            }
        }
        return new Matrix(_re);
    }

    public Matrix(Frac[][] element) {
        this.element = element;
    }
    public Matrix(double[][] element) {
        this.element = new Frac[element.length][element.length];

        for (int y = 0; y < element.length; y++) {
            for (int x = 0; x < element[0].length; x++) {
                Frac f = Frac.toFrac(element[y][x]);
                setElement(x, y, f);
            }
        }
    }

    public Matrix(int[][] element) {
        this.element = new Frac[element.length][element[0].length];
        for (int y = 0; y < element.length; y++) {
            for (int x = 0; x < element[0].length; x++) {
                this.element[y][x].set(element[y][x], 1);
            }
        }
    }

    /**
     * additon
     */
    public Matrix adi(Matrix m) {
        if (getColumnsQuantity() != m.getColumnsQuantity() ||
                getRowsQuantity() != m.getRowsQuantity()) {
            throw new MismachSizeOfMatrixException();
        }
        Matrix re = this;
        for (int y = 0; y < re.getRowsQuantity(); y++) {
            for (int x = 0; x < re.getColumnsQuantity(); x++) {
                re.setElement(x, y, re.getElement(x, y).adi(m.getElement(x, y)));
            }
        }
        return re;
    }

    public Matrix adi(double var) {
        Frac f = Frac.toFrac(var);
        Matrix re = this;
        for (int y = 0; y < getRowsQuantity(); y++) {
            for (int x = 0; x < getColumnsQuantity(); x++) {
                re.setElement(x, y, re.getElement(x, y).adi(f));
            }
        }
        return re;
    }

    public Matrix mul(double value) {
        Matrix re = this;
        Frac f = Frac.toFrac(value);
        for (int y = 0; y < getRowsQuantity(); y++) {
            for (int x = 0; x < getColumnsQuantity(); x++) {
                re.setElement(x, y, getElement(x, y).mul(f));
            }
        }
        return re;
    }

    public Matrix mul(Frac value) {
        Matrix re = this;
        for (int y = 0; y < getRowsQuantity(); y++) {
            for (int x = 0; x < getColumnsQuantity(); x++) {
                re.setElement(x, y, getElement(x, y).mul(value).arrangeFormat());
            }
        }
        return re;
    }
    /**
     * 逆行列
     */
    /*実装予定*/ Matrix inverse() {
        Matrix re = identity(getRowsQuantity());

        if (this.getColumnsQuantity() != this.getColumnsQuantity()) {
            throw new IllegalValueException("Mismatched row and column size.");
        } else if (this.getRowsQuantity() == 2) {
            Frac f = new Frac(1, getElement(1,1));
        }

        return re;
    }

    public void setElement(int x, int y, Frac value) {
        element[y][x] = value;
    }
    public void setElement(int x, int y, double value) {
        element[y][x] = Frac.toFrac(value);
    }

    public Frac getElement(int x, int y) {
        return element[y][x];
    }
    public int getRowsQuantity() {
        return element.length;
    }
    public int getColumnsQuantity() {
        return element[0].length;
    }
    /**
     * @param rowNumber 何行目か
     * @return 行
     */
    public Frac[] getRow(int rowNumber) {
        return element[rowNumber];
    }
    /**
     * @param columnNumber 何列目か
     * @return 列
     */
    public Frac[] getColumn(int columnNumber) {
        Frac[] re = new Frac[getRowsQuantity()];
        for (int i = 0; i < getRowsQuantity(); i++) {
            re[i] = getElement(columnNumber, i);
        }
        return re;
    }
}
