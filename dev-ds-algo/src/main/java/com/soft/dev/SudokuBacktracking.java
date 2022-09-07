package com.soft.dev;

public class SudokuBacktracking {

	public static int N = 9;
	
	public static void main(String[] args) {
		int board[][] = { 
				{ 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } 
                };
		
		System.out.println("Recursive Backtrack Solution: ");
		if (solveSudokuRecusiveBacktrack(board, N))
            print(board);
        else
            System.out.println("No Solution exists");
		
		System.out.println("--------------------------------");
		System.out.println("For Loop Backtrack Solution: ");
		if (solveSudokuForLoop(board))
			print(board);
		else
			System.out.println("No Solution exists");
		
		
	}

	//A utility function to print grid
    static void print(int[][] grid)
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }
    
    /**
     * Recursive Backtrack
     * @param board
     * @param N
     * @return
     */
	private static boolean solveSudokuRecusiveBacktrack(int[][] board, int N) {

		int row=0,col=0;
		boolean isEmpty = true;
		
		//check if any cell is not empty
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				if(board[i][j] == 0) {
					// store value of cells to start checking 1-9 combinations
					row = i;
					col = j;
					isEmpty = false;
					break;
				}
			}
			
			// if found any non-empty cell break and start checking 1-9 combination in that cell
			if(!isEmpty) {
				break;
			}
		}
		
		// No empty space left
		// Sudoku Solved
        if (isEmpty)
        {
            return true;
        }
		
        //start filling 1-9 numbers on empty cell and check if current placement solved the sudoku else backtrack
		for (int num = 1; num <= N; num++) {
			
			//check if num is safe for the placement
			if(isSafe(board,row,col,num)) {
				board[row][col] = num;
				//check sudo solution with this number placement
				if(solveSudokuRecusiveBacktrack(board, N)) {
					return true;
				}else {
					// unmark and backtrack and try with next number
					board[row][col] = 0;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Simple nested for loop - recursive check
	 * @return
	 */
	public static boolean solveSudokuForLoop(int[][] board) {
		
		// find empty cell
		// start filling 1-9
			// let x = 1-9
			// check if x is safe for placement or not
				// if true 
					// place x at current pos
					// recursive check if sudoku is solved 
						// sudoku is solved if no Empty cell
				//else mark 0 
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {

				if (board[i][j] == 0) {
					for (int num = 1; num <= N; num++) {
						if (isSafe(board, i, j, num)) {
							board[i][j] = num;
							if (solveSudokuForLoop(board)) {
								return true;
							} else {
								board[i][j] = 0;
							}
						}
					}
					// return false as board still has empty spaces
					return false;
				}
			}
		}
		
		//sudoku solved if No empty cells
		return true;
	}

	private static boolean isSafe(int[][] board, int row, int col, int num) {

		//check row if same num exists
		for (int i = 0; i < board.length; i++) {
			if(board[row][i] == num) {
				return false;
			}
		}
		
		//check if same num exists in column
		for (int i = 0; i < board.length; i++) {
			if(board[i][col] == num) {
				return false;
			}
		}
		
		//check row/col specific 3x3 box
		int startRow = row - row % 3;
		int startCol = col - col % 3;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(board[i+startRow][j+startCol] == num) {
					return false;
				}
			}
		}
		
		return true;
	}
}
