package com.example.findpath;

import java.util.Optional;

public class Maze {
    private final char[][] grid;

    public Maze(char[][] grid) {
        this.grid = grid;

        int countS = 0;
        int countX = 0;

        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == 'S') countS++;
                if (cell == 'X') countX++;
            }
        }

        if (countS != 1 || countX != 1) {
            throw new IllegalArgumentException("The maze must contain exactly one 'S' and one 'X'.");
        }
    }

    public int getHeight() {
        return grid.length;
    }

    public int getWidth() {
        return grid[0].length;
    }

    public char get(Position pos) {
        return grid[pos.row][pos.col];
    }

    public boolean isFree(Position pos) {
        return get(pos) == '.' || get(pos) == 'S' || get(pos) == 'X';
    }

    public boolean isInside(Position pos) {
        return pos.row >= 0 && pos.row < getHeight() && pos.col >= 0 && pos.col < getWidth();
    }

    public Optional<Position> findChar(char target) {
        for (int r = 0; r < getHeight(); r++) {
            for (int c = 0; c < getWidth(); c++) {
                if (grid[r][c] == target) {
                    return Optional.of(new Position(r, c));
                }
            }
        }
        return Optional.empty();
    }
}
