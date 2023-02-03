package com.algorithm.lifegame;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private List<List<Boolean>> cell = new ArrayList<>();

    /**差分(重なってるとこを削除)。否定論理積*/
    public static int BOOL_DIFFERENCE = 500,
    /**交差(重なってるいとこを上書きしない)。論理和*/
            BOOL_INTERSECT = BOOL_DIFFERENCE + 1,
    /**結合(重なっているとこを上書き)*/
            BOOL_UNION = BOOL_DIFFERENCE + 2;
    public enum bool {DIFFERENCE,INTERSECT,UNION}

    public Cell() {
        // ignored
    }
    public Cell(int width, int height) {
        List<Boolean> _cell = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            cell.add(_cell);
        }
        for (int x = 0; x < width; x++) {
            cell.get(x).add(false);
        }
    }
    public Cell(Cell cell) {
        this.cell = cell.toArrayList();
    }

    public void add(int x, int y, Cell cell, int mode) {
        var bool = Cell.bool.values()[mode + BOOL_DIFFERENCE];
        for (int _y = 0; _y < cell.getHeight(); _y++) {
            for (int _x = 0; _x < cell.getWidth(); _x++) {
                this.cell.get(y).set(x, switch (bool) {
                    case DIFFERENCE ->  this.cell.get(y).get(x);
                    case UNION ->  cell.getState(x, y);
                    case INTERSECT -> false;
                });
            }
        }
    }
    private /*public*/ void addSize(long wigth, long height) {
        for (int y = 0; y < wigth; y++) {
            cell.get(y).add(false);
        }
        for (int y = 0; y < height; y++) {
            List<Boolean> b = cell.get(0);
            cell.add(b);
        }
    }

    public void setBool(boolean[][] data) {
        cell = new ArrayList<>();
        List<Boolean> _cell = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            cell.add(_cell);
        }
        for (int x = 0; x < data[0].length; x++) {
            cell.get(x).add(false);
        }

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                setState(x,y,data[y][x]);
            }
        }
    }
    public void Reversal(int xLocation, int yLocation) {
        this.setState(xLocation, yLocation,
                !this.getState(xLocation, yLocation));
    }
    public void setState(int xLocation, int yLocation, boolean state) {
        cell.get(yLocation).set(xLocation, state);
    }

    public boolean getState(int xLocation, int yLocation) {
        return cell.get(yLocation).get(xLocation);
    }
    public int getWidth() {
        return cell.get(0).size();
    }
    public int getHeight() {
        return cell.size();
    }
    public List<Boolean> getXLine(int line) {
        return cell.get(line);
    }
    public List<Boolean> getYLine(int line) {
        List<Boolean> l = new ArrayList<>();
        for (int i = 0; i < this.getWidth(); i++) {
            l.add(this.getState(i, line));
        }
        return l;
    }

    public boolean[][] toArray() {
        boolean[][] b = new boolean[this.getWidth()][this.getWidth()];
        for (int y = 0; y < this.getHeight(); y++) {
            for(int x = 0; x < this.getWidth(); x++) {
                b[x][y] = this.getState(x,y);
            }
        }
        return b;
    }
    public List<List<Boolean>> toArrayList() {
        return cell;
    }
}
