package com.soft.dev;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_2DArray {
	
	public static void main(String[] args) {
		 int [][] grid = new int[][] {
             {1, 2, 3, 4},
             {5, 6, 7, 8},
             {9, 10, 11, 12},
             {13, 14, 15, 16}
     };
     
     BFS_2DArray obj = new BFS_2DArray();
     
     System.out.println("BFS - 2D Array - Queue:");
     
     obj.bfs2dArrayUsingQueue(grid);
     
	}

	public void bfs2dArrayUsingQueue(int[][] grid) {

		int m = grid.length;
		if(m==0) {
			return;
		}
		
		int n = grid[0].length;
		
		boolean[][] visited = new boolean[m][n];
		
		Queue<String> queue = new LinkedList<String>();
		
		//insert first pos
		queue.add(0+","+0);
		
		while(!queue.isEmpty()) {
			
			String rowColPair = queue.remove();
			int row = Integer.parseInt(rowColPair.split(",")[0]);
			int col = Integer.parseInt(rowColPair.split(",")[1]);
			
			if(row<0 || col<0 || row>=m || col>=n || visited[row][col]) {
				continue;
			}
			
			visited[row][col] = true;
			
			System.out.print(grid[row][col] + "  ");
			
			//BFS
			queue.add(row + "," + (col - 1)); //go left
            queue.add(row + "," + (col + 1)); //go right
            queue.add((row - 1) + "," + col); //go up
            queue.add((row + 1) + "," + col); //go down
		}
		
		
	}

}
