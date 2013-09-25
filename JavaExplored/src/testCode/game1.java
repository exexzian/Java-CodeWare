/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testCode;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class game1 extends WindowAdapter implements ActionListener
{
    JFrame f;
    JPanel p,q,t;  // changed
    JButton b[]=new JButton[4];
    JLabel l;
    Random r;
    Font ft;
    CardLayout cl;
    int j;
    
    game1(){
        f=new JFrame("Button game");
        f.setSize(300,200);
        cl=new CardLayout();
        f.setLayout(null); // changed
        
        /******** changed *****/
        t=new JPanel();
        t.setLayout(cl);
        t.setSize(300,200);
        f.add(t);
        /******/
        
        p=new JPanel();
        q=new JPanel();
        r=new Random();
        j=r.nextInt(3);
        p.setSize(100,100);
        for(int i=0;i<3;i++)
            b[i]=new JButton("click me!");
        for(int i=0;i<3;i++)
            p.add(b[i]);
        
        b[3]=new JButton("Play");
        for(int i=0;i<4;i++)
        b[i].addActionListener(this);
        
        l=new JLabel("          YOU WON!!!");
        ft=new Font("calibri",Font.BOLD,24);
        l.setFont(ft);
        q.setBackground(Color.GREEN);
        q.setSize(100,100);
        q.setLayout(new BorderLayout());
        
        q.add(l, BorderLayout.CENTER);  // changed
        q.add(b[3],BorderLayout.SOUTH);  // changed
        
        
        t.add(p,0);  // changed
        t.add(q,1);  // changed
        
        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }});
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == b[j]){
            System.out.println(" random button clcked=" + j);
            cl.next(t);  // changed
            
        }
        if(e.getSource() == b[3])
        {
            System.out.println("play");
            cl.previous(t);  // changed
            j=r.nextInt(3);
        }
        // else
    // System.exit(0);
    }
    public static void main(String args[])
    {
        game1 obj=new game1();
    }
}