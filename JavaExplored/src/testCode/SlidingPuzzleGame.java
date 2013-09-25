/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testCode;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class SlidingPuzzleGame implements ActionListener
{
    Frame f;
    Button b[],b1,b2;
    Panel p;
    Random r;
    SlidingPuzzleGame()
    {
        f=new Frame("Slide Puzzle");
        f.setVisible(true);
        f.setSize(500, 700);
        f.setBackground(Color.white);
        f.setLayout(null);
        b=new Button[15];
        b1=new Button("Shuffle");
        b2=new Button("Exit");
        b1.setBounds(150, 550, 60, 50);
        b2.setBounds(250, 550, 60, 50);
        p=new Panel(new GridLayout(4,4));
        p.setBounds(100, 100, 300, 400);
        Integer num=1;
        for(int i=0;i<b.length;i++)
        {            
            b[i]=new Button(num.toString());
            p.add(b[i]);
            num++;
        }
        f.add(p);
        f.add(b1);
        f.add(b2);
        b2.addActionListener(this);
        b1.addActionListener(this);
    }
    public void shuffle()
    {
        int n=0;
        r= new Random();
        for(int i=0;i<b.length;i++)
        {
            
            n=r.nextInt(15)+1;
            b[i].setLabel(String.valueOf(n));
        
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            System.out.println("suff;e");
            shuffle();
        }
        else
            System.exit(0);
    }
    public static void main(String args[]) {
        new SlidingPuzzleGame();
    
    }
}