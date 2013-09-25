/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testCode;


import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author hacker
 */
public class DialogPass extends Frame implements ActionListener{
    
    Button pass;
    TextField status;
    Button check;
    TextField input;
    Label msg;
    Dialog dial;

    public DialogPass()  {
        
        super("Dialog Password");
        setSize(500, 500);
        setLocation(40, 50);
        
        pass = new Button("Dialog Pass");
        status = new TextField();
        
        add(pass,BorderLayout.NORTH);
        add(status,BorderLayout.SOUTH);
        
        pass.addActionListener(this);
        
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==pass){
            
            MiniDialog md = new MiniDialog(this,"Dialog check",true);
        }
    }
    
    public static void main(String[] args) {
        new DialogPass();
    }
    
    class MiniDialog extends Dialog implements ActionListener{

        public MiniDialog(Frame owner, String title, boolean modal) {
            super(owner, title, modal);
            
            setSize(200, 200);
            setLayout(null);
            
            check = new Button("check Pass");
            msg = new Label("Enter password");
            input = new TextField();
            msg.setBounds(50, 10, 40, 30);
            input.setBounds(30, 60, 90, 30);
            check.setBounds(100, 60, 90, 30);
            
            add(check);
            add(msg);
            add(input);
            
            
            check.addActionListener(this);
            
            setVisible(true);
            
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==check){
                if(input.getText().equals("pass")){
                    status.setText("Correct");
                }
                else{
                    status.setText("incorrect");
                }
            }
        }

        
        
        
    }
    
    
    
}
