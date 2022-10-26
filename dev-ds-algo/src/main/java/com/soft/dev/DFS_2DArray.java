package com.soft.dev;

import java.util.Stack;

public class DFS_2DArray {

	
	public static void main(String[] args) {
		 int [][] grid = new int[][] {
             {1, 2, 3, 4},
             {5, 6, 7, 8},
             {9, 10, 11, 12},
             {13, 14, 15, 16}
     };
     
     DFS_2DArray obj = new DFS_2DArray();
     
     System.out.println("DFS - 2D Array - Recursion:");
     obj.dfsUsingRecursion(grid);
     System.out.println("\n--------------------------------------------------------------");
     System.out.println("DFS - 2D Array - Stack:");
     obj.dfsUsingStack(grid);
     
	}

	public void dfsUsingRecursion(int[][] grid) {

		int m = grid.length;
		//empty grid
		if(m == 0) {
			return;
		}
		
		int n = grid[0].length;
		
		boolean visited[][] = new boolean[m][n];
		
		dfsUtilRecurive(grid,0,0,visited);
		
	}

	public void dfsUtilRecurive(int[][] grid, int row, int col, boolean[][] visited) {

		int m = grid.length;
		int n = grid[0].length;
		
		//return or skip if out of bound or position already VISITED
		if(row<0 || col<0 || row>=m || col>=n||visited[row][col]) {
			return;
		}
		
		//mark current position as VISITED true
		visited[row][col] = true;

		//print visited index
		System.out.print(grid[row][col] +"  ");
		
		//perform recursive DFS
		dfsUtilRecurive(grid, row+1, col, visited);
		dfsUtilRecurive(grid, row-1, col, visited);
		dfsUtilRecurive(grid, row, col+1, visited);
		dfsUtilRecurive(grid, row, col-1, visited);
		
	}
	
	/************** DFS 2D Array using Stack *******************/
	
	public void dfsUsingStack(int[][] grid) {
		int m = grid.length;
		if(m == 0) {
			return;
		}
		int n = grid[0].length;
		
		boolean[][] visited = new boolean[m][n];
		
		Stack<String> stack = new Stack<String>();
		
		// push initial pair in form of comma splitted
		//0,0
		stack.push(0 + "," + 0);
		
		while(!stack.isEmpty()) {
			
			String rowColPair = stack.pop();
			int row = Integer.parseInt(rowColPair.split(",")[0]);
			int col = Integer.parseInt(rowColPair.split(",")[1]);
			
			//skip if out of bounds or already visited
			if(row<0 || col<0 || row>=m || col>=n || visited[row][col]) {
				continue;
			}
			
			visited[row][col] = true;
			System.out.print(grid[row][col] + "  ");
			
			//push all adjacent pairs to stack for DFS
			stack.push((row+1) +"," + col);
			stack.push((row-1) +"," + col);
			stack.push(row +"," + (col+1));
			stack.push(row +"," + (col-1));
			
		}
		
	}
}
