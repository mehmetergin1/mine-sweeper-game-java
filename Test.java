package com.erdem;
import java.util.Scanner;

public class Test {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print(" Mayın tarlanız kaç satır olsun? ");
	        int rows = scanner.nextInt();

	        System.out.print(" Mayın tarlanız kaç sütun olsun? ");
	        int cols = scanner.nextInt();

	        System.out.print(" Tarlanızda kaç mayın olsun? ");
	        int totalMines = scanner.nextInt();

	        MineSweeperGame game = new MineSweeperGame(rows, cols, totalMines);
	        game.play();

	        scanner.close();
	    }

}
