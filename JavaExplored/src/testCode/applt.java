/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testCode;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;

import java.applet.*;

public class applt extends Applet implements ActionListener {
    
    Font f;
    MenuBar menubar;
    Menu menu1,menu2,menu3,menu4,submenu1,submenu2;
    MenuItem item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17;
    private String s1 = "DEVENDRA";
    int flag=0;
    
    
    public void init() {
        
        menubar = new MenuBar();
        menu1 = new Menu("Font");
        submenu1 = new Menu("Font name ");
                      item1 = new MenuItem("Times New Roman");
        item2 = new MenuItem("Arial");
        item3 = new MenuItem("Normal");
        
        submenu1.add(item1);
        submenu1.add(item2);
        submenu1.add(item3);
        
        menu1.add(submenu1);
        
        submenu2 = new Menu("Font Size");
        item4 = new MenuItem("10");
        item5 = new MenuItem("12");
        item6 = new MenuItem("15");
        item7 = new MenuItem("20");
        
        submenu2.add(item4);
        submenu2.add(item5);
        submenu2.add(item6);
        submenu2.add(item7);
        menu1.add(submenu2);
        
        menubar.add(menu1);
        
        menu2 = new Menu("Style");
        item8 = new MenuItem("Bold");
        item9 = new MenuItem("Italic");
        item10 = new MenuItem("Underline");
        menu2.add(item8);
        menu2.add(item9);
        menu2.add(item10);
        
        menubar.add(menu2);
        
        menu3 = new Menu("Shape");
        item11 = new MenuItem("Oval");
        item12 = new MenuItem("Rectangle");
        item13 = new MenuItem("Line");
        menu3.add(item11);
        menu3.add(item12);
        menu3.add(item13);
        
        menubar.add(menu3);
        
        menu4 = new Menu("Color");
        item14 = new MenuItem("Red");
        item15 = new MenuItem("Green");
        item16 = new MenuItem("Blue");
        item17 = new MenuItem("Black");
        menu4.add(item14);
        menu4.add(item15);
        menu4.add(item16);
        menu4.add(item17);
        
        menubar.add(menu4);
        
        f= new Font("DEVENDRA",Font.BOLD,12);
        setFont(f);
        
        
        Component c = this;
        while (c != null && !(c instanceof Frame)) {
            c = c.getParent();
        }
        ((Frame)c).setMenuBar(menubar);
        item9.addActionListener(this);
        item10.addActionListener(this);
        item8.addActionListener(this);
        
        item12.addActionListener(this);
    
    }

    Graphics gr;
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==item12){
            flag = 1;
            System.out.println("calling repaint---------");
        repaint();
        }
    }
    
    public void update(Graphics g){
        System.out.println("called update");
        if(flag == 1){
         g.drawRect(300,100,50,50);    
        }
        System.out.println("*** caling paint from update**");
        paint(g);
    }
    
    
    public void paint(Graphics g)
    {
        System.out.println("paint called");
        s1="DEVENDRA";
        g.drawString(s1,100,100);
        g.drawOval(300,100,50,50);
    }

}

