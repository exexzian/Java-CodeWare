package com.soft.dev.leetcode.mincost;

/**
 * 
 * find minimum path from top-left -> bottom-right
 * allowed path: Right,Bottom,Diagonal(increasing side)
 * 
 * https://www.geeksforgeeks.org/min-cost-path-dp-6/
 * 
 * @author Vinod
 *
 */
public class MinCost_Path_RBD {
	
	public static void main(String[] args) {
		/*
		int[][] cost =
	        {
	            { 4, 7, 8, 6, 4 },
	            { 6, 7, 3, 9, 2 },
	            { 3, 8, 1, 2, 4 },
	            { 7, 1, 7, 3, 7 },
	            { 2, 9, 8, 9, 3 }
	        };
		*/

		int cost[][] = { {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };
		
	        System.out.print("The minimum cost is " + findMinCost(cost));
	}

	private static String findMinCost(int[][] cost) {
		
		if(cost == null || cost.length == 0) {
			return "0";
		}
		
		int[][] dp = new int[cost.length][cost[0].length];
		
		for (int i = cost.length-1; i >= 0; i--) {
			int min = 0;
			for (int j = cost[i].length-1; j >=0; j--) {
				
				if(i == cost.length-1 && j == cost[i].length-1 ) {
					dp[i][j] = cost[i][j];
				}
				// bottom row
				else if(i == cost.length-1) {
					dp[i][j] = dp[i][j+1] + cost[i][j];
				}
				// right column
				else if(j == cost[0].length-1) {
					dp[i][j] = dp[i+1][j] + cost[i][j];
				}
				//rest of the elements
				else {
					min = Math.min(Math.min(dp[i+1][j], dp[i][j+1]), dp[i+1][j+1]);
					dp[i][j] = min + cost[i][j];
				}
			}
		}
		
		return dp[0][0]+"";
	}

}
