package com.soft.dev.leetcode;

public class LC1219_MaxGoldAllSidesAnyPos {
	
    public int getMaximumGold(int[][] grid) {
    	int max = 0;
    	
    	for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] != 0) {
					int goldCollected = findMaxGoldInPath(i,j,grid);
					max = Math.max(max, goldCollected);
				}
			}
		}
    	
    	return max;
    }
	
	private int findMaxGoldInPath(int i, int j, int[][] grid) {

		if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == 0) {
			return 0;
		}
		
		int previousState = grid[i][j];
		grid[i][j] = 0;
		
		int left = findMaxGoldInPath(i-1,j,grid);
		int right = findMaxGoldInPath(i+1,j,grid);
		int up = findMaxGoldInPath(i,j-1,grid);
		int down = findMaxGoldInPath(i,j+1,grid);
		
		grid[i][j] = previousState;
		int goldCollected = grid[i][j] + Math.max(left, Math.max(right, Math.max(up, down)));
		
		return goldCollected;
	}

	public static void main(String[] args) {
		LC1219_MaxGoldAllSidesAnyPos obj = new LC1219_MaxGoldAllSidesAnyPos();
		
		int[][] grid = {
				{0,6,0},
				{5,8,7},
				{0,9,0}
		};
		
		System.out.println(obj.getMaximumGold(grid));
	}

}
