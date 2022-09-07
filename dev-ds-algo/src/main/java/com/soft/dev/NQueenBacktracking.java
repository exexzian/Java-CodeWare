package com.soft.dev;

public class NQueenBacktracking {
	
	public static final int N = 4;
	
	public static void main(String[] args) {
		
		int[][] board = {
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0}
		};
		
		if(!solveNQueen(board,0)) {
			System.out.println("Solution Doesn't Exist");
			
			return;
		}
		
		System.out.println("Print Solution Board");
		
		printSolution(board);
		//System.out.println(Arrays.deepToString(board));
		
		
	}

	private static boolean solveNQueen(int[][] board, int col) {
		// base case
		if (col == N) {
			return true;
		}
		for (int i = 0; i < N; i++) {
			// check if current pos is safe for placement
			if (isSafePos(board, i,col)) {
				board[i][col] = 1;
				// move to next column
				if (solveNQueen(board, col + 1)) {
					return true;
				} else {
					System.out.println("check failed at i:"+i+" | col:"+(col+1));
					// above placement failed - backtrack
					board[i][col] = 0;
				}

			}

		}

		return false;
	}

	private static boolean isSafePos(int[][] board, int row,int col) {
		
		int i,j;
		//System.out.println("-----------------------------");
		//System.out.println("row: "+row +" | col: " + col);
		//System.out.println("-----------------------------");

		//check all columns
		for (i = 0; i < col; i++) {
			if(board[row][i]==1) {
				return false;
			}
		}
		
		//System.out.println("######## Check R->L Diagonal########");
		//check bottom right to top left diagonal 
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			//System.out.println("i: "+i +" | j: " + j);
			 if (board[i][j] == 1)
	                return false;
		}
           
		//System.out.println("######## Check L->R Diagonal########");
		//check top left to bottom right diagonal
        for (i = row, j = col; j >= 0 && i < N; i++, j--) {
        	//System.out.println("i: "+i +" | j: " + j);
            if (board[i][j] == 1)
                return false;
        }
			
		
		return true;
	}
	
	// print the final solution matrix 
    static void printSolution(int board[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }

}
