package com.soft.dev.leetcode;

class JumpGame {
    public boolean canJump(int[] nums) {
    	 int currPosition = nums.length-1;
         
         for(int i=nums.length-1;i>=0;i--){
             if(i+nums[i] >=currPosition){
                 currPosition = i;
                 System.out.println("i: "+ i +" | currPosition: " +currPosition);
             }
         }
         return currPosition == 0;
    }
    
    public static void main(String[] args) {
		//int[] nums = {2,3,1,1,4};
		int[] nums = {3,2,5,0,4};
		System.out.println(new JumpGame().canJump(nums));
	}
}