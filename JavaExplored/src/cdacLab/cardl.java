package cdacLab;

import java.awt.*;
import java.awt.event.*;

public class cardl extends Frame implements ActionListener
{
    Panel p;
    Panel p1[];
    Panel result;
    Label l[];
    Checkbox cb[][];
    CheckboxGroup cbg[];
    CardLayout cl;
    Button b1,b2;
    int rightans=0;
    Label printResult;
    Button exit;
    Label status;
    
    cardl()
    {
        init1();
        
        for(int i=0;i<5;i++)
        {
            p1[i]=new Panel();
            p1[i].setLayout(null);
            p.add(p1[i],String.valueOf(i));
            p1[i].setLocation(0,0);
            p1[i].setSize(400,450);
            l[i]=new Label();
            l[i].setBounds(0,0,350,20);
            p1[i].setBackground(Color.red);
            p1[i].add(l[i]);
            
            cbg[i]= new CheckboxGroup();
        }
        
        p.add(result, 5);
        result.add(printResult);
        result.add(status);
        
        for(int i=0;i<5;i++)
            for(int j=0;j<4;j++)
            {
                cb[i][j]= new Checkbox("",cbg[i],false);
                
                p1[i].add(cb[i][j]);
                cb[i][j].setLocation(100,100);
            }
        p.setSize(350,200);
        setSize(500,500);
        add(p);
        setLayout(null);
        
        add(b2=new Button("Next"));
        b2.setBounds(100,350,50,20);
        b2.addActionListener(this);
        
        add(exit);
        exit.addActionListener(this);
        
        add(b1=new Button("Prev."));
        b1.setBounds(250,350,50,20);
        b1.addActionListener(this);
        
        quiz();
    }    
    
    //questions n options
    public void quiz()
    {
        l[0].setText("Q.1. C language Developed by :");
        
        cb[0][0].setBounds(10, 30, 200, 20);
        cb[0][1].setBounds(10, 70, 200, 20);
        cb[0][2].setBounds(10, 110, 200, 20);
        cb[0][3].setBounds(10, 150, 200, 20);
        
        cb[0][0].setLabel("Dennis d mennis");
        cb[0][1].setLabel("Dennis richie");
        cb[0][2].setLabel("Santosh");
        cb[0][3].setLabel("Danish bhai");
        
        l[1].setText("Q.2. The capacity of 3.5 inch floppy disk is :");
        cb[1][0].setBounds(10, 30, 200, 20);
        cb[1][1].setBounds(10, 70, 200, 20);
        cb[1][2].setBounds(10, 110,200, 20);
        cb[1][3].setBounds(10, 150,200, 20);
        
        cb[1][0].setLabel("1.40 MB");
        cb[1][1].setLabel("1.44 GB");
        cb[1][2].setLabel("1.40 GB");
        cb[1][3].setLabel("1.44 MB");
        
        l[2].setText("Q.3. The first computer introduced in Nepal was:");
        cb[2][0].setBounds(10, 30, 200, 20);
        cb[2][1].setBounds(10, 70, 200, 20);
        cb[2][2].setBounds(10, 110, 200, 20);
        cb[2][3].setBounds(10, 150, 200, 20);
        
        cb[2][0].setLabel("IBM 1400");
        cb[2][1].setLabel("IBM 1401");
        cb[2][2].setLabel("IBM 1402");
        cb[2][3].setLabel("IBM 1403");
        
        l[3].setText("Q.4. MICR stands for:");
        cb[3][0].setBounds(10, 30, 200, 20);
        cb[3][1].setBounds(10, 70, 200, 20);
        cb[3][2].setBounds(10, 110,200, 20);
        cb[3][3].setBounds(10, 150, 200, 20);
        
        cb[3][0].setLabel("Magnetic Ink Character Reader");
        cb[3][1].setLabel("Magnetic Ink Code Reader");
        cb[3][2].setLabel("Magnetic Ink Cases Reader");
        cb[3][3].setLabel("None");
        
        l[4].setText("Q.5. VGA is:");
        cb[4][0].setBounds(10, 30, 200, 20);
        cb[4][1].setBounds(10, 70, 200, 20);
        cb[4][2].setBounds(10, 110,200, 20);
        cb[4][3].setBounds(10, 150, 200, 20);
        
        cb[4][0].setLabel("Video Graphics Array");
        cb[4][1].setLabel("Visual Graphics Array");
        cb[4][2].setLabel("Volatile Graphics Array");
        cb[4][3].setLabel("Video Graphics Adapter");      
        }
    
    
    public void init1()
    {
        cl = new CardLayout();
        p = new Panel();
        result = new Panel();
        result.setBackground(Color.red);
        result.setSize(200,200);
        result.setLayout(null);
        result.setLocation(50,50);
        printResult = new Label();
        printResult.setBackground(Color.white);
        printResult.setBounds(10, 100, 150, 50);        
        status = new Label("RESULT STATUS");
        status.setBounds(50,50,50,50);
        status.setBackground(Color.gray);        
        p.setSize(200,200);
        p.setLocation(50,50);
        p.setLayout(cl);
        p1 = new Panel[5];
        l = new Label[5];
        cbg = new CheckboxGroup[5];
        cb = new Checkbox[5][4];
        exit = new Button("EXIT");
        exit.setBounds(150, 380, 30, 30);
    }    
    //event handler
    @Override
    public void actionPerformed(ActionEvent ae)
    {        
        if(b2==ae.getSource())
        {
            cl.next(p);
        }
        if(b1==ae.getSource())
        {
            cl.previous(p);
        }
        if(ae.getSource()==exit){
            System.exit(0);
        }
        result();
        printResult.setText(Integer.toString(rightans) + " were correct out of 5");
    }
    
    boolean[] f = new boolean[5];
    
    void result()
    {
        if(f[0]==false)
            if(cb[0][1].getState() == true)
            {
                f[0]=true;
                rightans++;
            }        
        if(f[1]==false)
            if(cb[1][2].getState() == true)
            {
                f[1]=true;
                rightans++;
            }        
        if(f[2]==false)
            if(cb[2][1].getState() == true)
            {
                f[2]=true;
                rightans++;
            }        
        if(f[3]==false)
            if(cb[3][0].getState() == true)
            {
                f[3]=true;
                rightans++;
            }
        
        if(f[4]==false)
            if(cb[4][0].getState() == true)
            {
                f[4]=true;
                rightans++;
            }        
        System.out.println(rightans);
   }
        
    public static void main(String args[])
    {
        cardl c= new cardl();
        c.setVisible(true);
        c.setLocation(100,100);
    }
}

