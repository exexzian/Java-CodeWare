/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cdacLab;

/**
 *
 * @author hacker
 */
public class Pattern6
{
    public static void main(String args[])
    {
        int a=0;
        int j;
        int count=0;
        for(int i=0;i<=7;i++)
        {
            for(j=0;j<=i-1;j++)
            {
                a=i*j;
                System.out.print(" "+a);
                if(a==0){
                    count++;
                }
            }
            System.out.println();
        }
        System.out.println("count = "+count);
    }
}

