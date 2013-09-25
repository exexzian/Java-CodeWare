/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cdacLab;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author hacker
 */
public class FileReading extends JFrame{
    JPanel pan, pan2;
    JTextArea text = new JTextArea();
    JTextField fname = new JTextField(18);
    JLabel filename = new JLabel("Filename");
    JButton view = new JButton("View");
    JScrollPane scroll = new JScrollPane(text);
    
    public FileReading() {
        setLayout(new BorderLayout());
        
        pan = new JPanel();
        pan2 = new JPanel();
        
        //scroll.setBounds(400,400,400,400);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        text.setEditable(true);
        scroll.setViewportView(text);
        pan2.add(scroll);
        //scrollpane.setViewportView(text);
        pan2.setLayout(new BorderLayout());
        //pan2.add(scrollpane);
        pan.setLayout(new FlowLayout());
        pan.add(filename, FlowLayout.LEFT);
        pan.add(fname, FlowLayout.CENTER);
        pan.add(view, FlowLayout.RIGHT);
        // view.addActionListener(this);
        // fname.addActionListener(this);
        pan2.add(scroll, BorderLayout.CENTER);
        pan2.add(pan, BorderLayout.SOUTH);
        //BorderLayout.EAST
        //add(pan, BorderLayout.SOUTH);
        add(pan2);//, BorderLayout.CENTER
        setVisible(true);
    }
    
    public static void main(String args[]) {
        FileReading frame = new FileReading();
        frame.setTitle("Enter The Full Path to the File");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400,400,400,400);
    //frame.setSize(400,400);
    }
}
