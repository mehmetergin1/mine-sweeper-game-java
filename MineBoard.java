package com.erdem;
import java.util.Random;

class MineBoard extends GameBoard {
    private int totalMines;

    public MineBoard(int rows, int cols, int totalMines) {
        super(rows, cols);
        this.totalMines = totalMines;
    }

    @Override
    public void setupBoard() {
        Random random = new Random();
        int minesPlaced = 0;
        while (minesPlaced < totalMines) {
            int r = random.nextInt(rows);
            int c = random.nextInt(cols);
            if (board[r][c] != MineSweeperGame.MINE) {
                board[r][c] = MineSweeperGame.MINE;
                incrementNeighbors(r, c);
                minesPlaced++;
            }
        }
    }

    private void incrementNeighbors(int row, int col) {
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                int nr = row + dr;
                int nc = col + dc;

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && board[nr][nc] != MineSweeperGame.MINE) {
                    board[nr][nc]++;
                }
            }
        }
    }
}



