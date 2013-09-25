/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xtraLogical;

/**
 *
 * @author hacker
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingPaint extends JPanel {
    
    Color color;
    
    public SwingPaint(Color color) {
        System.out.println("in const");
        this.color = color;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("in paint");
        int width = getWidth();
        int height = getHeight();
        g.setColor(color);
        g.drawOval(0, 0, width, height);
    }
    
    public static void main(String args[]) {
        System.out.println("in main");
        JFrame frame = new JFrame("Oval Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLayout(new GridLayout(2, 2));
        
        Color colors[] = { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW };
        for (int i = 0; i < 4; i++) {
            SwingPaint panel = new SwingPaint(colors[i]);
            frame.add(panel);
        }
        
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
