package com.fr.application;

public class FirstRound {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Check");
		int after[][] = { { 1, 2, 3, 4, 5 }, 
                { 2, 4, 6, 8, 10 }, 
                { 3, 6, 9, 12, 15 }, 
                { 4, 8, 12, 16, 20 } };
		
		//int[][] after = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
		int row = after.length;
		int col = after[0].length;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(after[i][j]+" ");
			}
			System.out.println();
		}
		int result[][] = new int[row][col];
		result[0][0] = after[0][0]; 
		for(int i=row-1;i>0;i--) {
			result[i][0] = after[i][0] - after[i-1][0];
		}
		for(int i=col-1;i>0;i--) {
			result[0][i] = after[0][i] - after[0][i-1];
		}
		for(int i=row-1;i>0;i--) {
			for(int j=col-1;j>0;j--) {
				result[i][j] = after[i][j] - after[i-1][j] - after[i][j-1] + after[i-1][j-1];
			}
		}
		System.out.println("Check");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}

}
