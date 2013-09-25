package xtraLogical;

/*<html><applet code = "swing.class" height = 500 width = 400>
</applet></html>*/
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class swing extends JApplet{
    
    JButton b1;
    public void init()
    {
        setLayout(null);
        setSize(300,300);
       Icon i = new ImageIcon("close.png");
        Container c = getContentPane();

        
        b1 = new JButton("BULLO");
        b1.setBounds(20,20,100,100);
      b1.setIcon(i);
        c.add(b1);
    }

}