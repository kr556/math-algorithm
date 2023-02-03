package com.algorithm.lifegame;

import java.util.List;

public class LifeGame {
    private final Cell cell;

    public LifeGame(int width, int height) {
        cell = new Cell(width,height);
    }
    public LifeGame(Cell cell) {
        this.cell = cell;
    }

    public Cell next() {
        return cell;
    }

    public Cell getCell() {
        return cell;
    }
}
