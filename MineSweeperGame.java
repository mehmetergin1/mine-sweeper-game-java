package com.erdem;
import java.util.Scanner;

public class MineSweeperGame {
    public static final int MINE = -1;
    private boolean[][] revealed;
    private int rows;
    private int cols;
    private MineBoard mineBoard;
    private int cellsToReveal;

    public MineSweeperGame(int rows, int cols, int totalMines) {
        this.rows = rows;
        this.cols = cols;
        this.mineBoard = new MineBoard(rows, cols, totalMines);
        this.revealed = new boolean[rows][cols];
        this.cellsToReveal = rows * cols - totalMines;
        mineBoard.setupBoard();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver && cellsToReveal > 0) {
            mineBoard.printBoard(revealed);

            System.out.print("Satır girin: ");
            int r = scanner.nextInt();
            System.out.print("Sütun girin: ");
            int c = scanner.nextInt();

            if (r < 0 || r >= rows || c < 0 || c >= cols) {
                System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
                continue;
            }

            if (revealed[r][c]) {
                System.out.println("Bu hücre zaten açıldı! Lütfen başka bir hücre seçin.");
                continue;
            }

            if (mineBoard.board[r][c] == MINE) {
                gameOver = true;
                System.out.println(" Ne yazık ki mayına bastınız! Oyun bitti.");
                revealAll();
                mineBoard.printBoard(revealed);
            } else {
                reveal(r, c);
            }
        }

        if (cellsToReveal == 0) {
            System.out.println("Tebrikler! Tüm hücreleri açtınız ve kazandınız!");
        }

        scanner.close();
    }

    private void reveal(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || revealed[row][col]) {
            return;
        }

        revealed[row][col] = true;
        cellsToReveal--;

        if (mineBoard.board[row][col] == 0) {
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    reveal(row + dr, col + dc);
                }
            }
        }
    }

    private void revealAll() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                revealed[r][c] = true;
            }
        }
    }
    
}   

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Kaç satır olsun? ");
//        int rows = scanner.nextInt();
//
//        System.out.print("Kaç sütun olsun? ");
//        int cols = scanner.nextInt();
//
//        System.out.print("Kaç mayın olsun? ");
//        int totalMines = scanner.nextInt();
//
//        MineSweeperGame game = new MineSweeperGame(rows, cols, totalMines);
//        game.play();
//
//        scanner.close();
//    }



