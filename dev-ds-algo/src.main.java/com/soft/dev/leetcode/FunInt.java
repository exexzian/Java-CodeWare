package com.soft.dev.leetcode;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

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


