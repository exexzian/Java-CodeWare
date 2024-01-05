package com.soft.dev.leetcode;


public class FunInt {

}

@FunctionalInterface
interface Square
{
    int calculate(int x);
    
    default void test(int a)
    {
    	
    }
}

@FunctionalInterface
interface Rect extends Square
{
    int calculate(int x);
    
    default void test(int a)
    {
    	
    }
}


