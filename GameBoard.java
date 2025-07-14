package com.erdem;

interface Board {
    void setupBoard(); 
    void printBoard(boolean[][] revealed); 
}
 
 abstract class GameBoard implements Board {
    protected int rows;
    protected int cols;
    protected int[][] board;

    public GameBoard(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new int[rows][cols];
    }

    public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}
    
    
    public abstract  void setupBoard();

    public void printBoard(boolean[][] revealed) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!revealed[r][c]) {
                    System.out.print(" ? ");
                } else if (board[r][c] == MineSweeperGame.MINE) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" " + board[r][c] + " ");
                }
            }
            System.out.println();
        }
    }

	
}