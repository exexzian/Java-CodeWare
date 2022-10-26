package com.soft.dev.leetcode;

import java.util.Arrays;

public class LC_122_BuySellStockMultipleTransactions {

	public static void main(String[] args) {
		LC_122_BuySellStockMultipleTransactions obj = new LC_122_BuySellStockMultipleTransactions();
		int[] prices = {1,3};
		//int[] prices = {7,1,5,3,6,4};
		
		//System.out.println("BruteForce solution: ");
		//System.out.println(obj.maxProfitBruteForce(prices));
		
		//System.out.println("DP recursion memoization:");
		//System.out.println(obj.maxProfitRecursionMemo(prices));
		
		System.out.println("DP tabulation:");
		System.out.println(obj.maxProfitTabulation(prices));
		
		
	}

	// approach 1
	private int calculateMaxProfitRecursion(int[] prices, int index, boolean buyFlag) {

		if (index == prices.length) {
			return 0;
		}

		int profit = 0;
		if (buyFlag) {
			profit = Math.max(-prices[index] + calculateMaxProfitRecursion(prices, index + 1, false),
					0 + calculateMaxProfitRecursion(prices, index + 1, true));
		} else {
			profit = Math.max(prices[index] + calculateMaxProfitRecursion(prices, index + 1, true),
					0 + calculateMaxProfitRecursion(prices, index + 1, false));
		}
		System.out.println("profit: "+profit);
		return profit;

	}

	public int maxProfitBruteForce(int[] prices) {
		return calculateMaxProfitRecursion(prices, 0, true);
		//return calculateMaxProfitIterativeTabulation(prices, 0, true);
	}
	
	//approach 2
	public int maxProfitRecursionMemo(int[] prices) {
		//return calculateMaxProfitRecursion(prices, 0, true);
		
		int[][] dp = new int[prices.length][2];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		int max =  calculateMaxProfitRecursionMemoization(prices, 0, true, dp);
		System.out.println("dp: " + Arrays.deepToString(dp));
		return max;
	}

	private int calculateMaxProfitRecursionMemoization(int[] prices, int index, boolean buyFlag, int[][] dp) {
		
		if (index == prices.length) {
			return 0;
		}
		int col = buyFlag ? 1 : 0;
		if(dp[index][col] != -1) {
			return dp[index][col];
		}
		int profit = 0;
		if (buyFlag) {
			profit = Math.max(-prices[index] + calculateMaxProfitRecursionMemoization(prices, index + 1, false,dp),
					0 + calculateMaxProfitRecursionMemoization(prices, index + 1, true,dp));
		} else {
			profit = Math.max(prices[index] + calculateMaxProfitRecursionMemoization(prices, index + 1, true,dp),
					0 + calculateMaxProfitRecursionMemoization(prices, index + 1, false,dp));
		}
		
		System.out.println("index: " + index + " | col: "+col + " | Profit: " + profit);
		return dp[index][col] = profit;
	}
	
	
	//approach 3
	public int maxProfitTabulation(int[] prices) {		
		int[][] dp = new int[prices.length+1][2];

		//dp[prices.length][0] = dp[prices.length][1] = 0;
		
		for (int i = prices.length-1; i >=0; i--) {
			for (int buy = 0; buy <=1; buy++) {
				int profit = 0;
				if (buy == 1) {
					profit = Math.max(-prices[i] + dp[i+1][0],
							0 + dp[i+1][1]);
				} else {
					profit = Math.max(prices[i] + dp[i+1][0],
							0 + dp[i+1][1]);
				}
				dp[i][buy] = profit;
			}
		}
		
		System.out.println("dp: " + Arrays.deepToString(dp));
		return dp[0][1] ;
	}

}
