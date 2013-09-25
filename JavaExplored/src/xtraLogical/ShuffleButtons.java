package xtraLogical;

import testCode.*;
import java.awt.*;
import java.util.Random;


class ShuffleButtons extends Frame {
    
    public ShuffleButtons(){
        
        setSize(300, 400);
        setLocation(20, 30);
        
        setLayout(null);
        Panel board = new Panel(new GridLayout(2, 2));
        board.setSize(300, 300);
             
        Button[] b = new Button[4];
        int i=0;
        int count = 0;
       
        Random r = new Random();
        while(count<4){
            
            i = r.nextInt(4)+1;
            
            System.out.println("i = "+i + " count = " +count);
            
            if(count==0){
                System.out.println("if 0");
                b[count]  = new Button(String.valueOf(i));
                board.add(b[count]);
                System.out.println("********** added " + i + " at " + count);
                count++;
            }
            else{
                
                boolean flag = false;
                for(int j=0;j<count;j++){
                    
                    System.out.println("in for  "+i);
                    if(!(String.valueOf(i).equals(b[j].getLabel()))){
                        flag = true;
                        System.out.println(j+ " true i = "+i);
                    }
                    else{
                        flag = false;
                        System.out.println("-------------label exist------------");
                        break;
                    }
                }
                if(flag==true){
                    System.out.println("flag i = "+i);
                    b[count]  = new Button(String.valueOf(i));
                    board.add(b[count]);
                    System.out.println("********** added " + i + " at " + count);
                    count++;
                    
                }
                
            }
            
        }
        
        add(board);
        setVisible(true);
        
        
    }
    
    
    
    public static void main(String[] args)  {
        
        ShuffleButtons obj = new ShuffleButtons();
        
        
    }

}