package xtraLogical;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


class SlidingPuzzle extends Frame implements ActionListener{
    Panel board;
    Button[] button;
    Random r;
    int count;
    int bLabel;
    Button shuffle;
    Button exit;
    Label moves;
    int moveNo;
    int buttonPos;
    
    public SlidingPuzzle(){
        
        setSize(500, 550);
        setLocation(20, 30);
        setLayout(null);
        setBackground(Color.gray);
        
        button = new Button[16];
        moves = new Label("Moves: ");
        shuffle = new Button("Shuffle");
        exit = new Button("exit");
        
        moves.setBackground(Color.GRAY);
        moves.setLocation(200, 40);
        moves.setSize(70, 40);
        
        board = new Panel(new GridLayout(4, 4));
        board.setSize(300, 300);
        board.setLocation(100, 100);
        
        shuffle.setBounds(150, 450, 50, 30);
        exit.setBounds(300, 450, 50, 30);
        
        shuffle.addActionListener(this);
        exit.addActionListener(this);
        
        add(moves);
        add(shuffle);
        add(exit);
        
        for (int i=0;i<16;i++){
            button[i] = new Button();
            board.add(button[i]);
            buttonPos = i;
            button[i].addActionListener(this);
        }
        
        initButton();
        shuffleTiles();
        
        add(board);
                        
        setVisible(true);
        
    }
    
    void initButton()
    {
        for (int i=0;i<15;i++){
            button[i].setLabel("0");
            button[i].setVisible(true);
        }
        button[15].setLabel("");
        button[15].setVisible(false);
    }
    
    public void check()
    {
        boolean flag=false;
        for (int i=0;i<15;i++)
        {
            if (button[i].getLabel().equals(Integer.toString(i+1)))
            {
                flag=true;
            }
            else
            {
                flag=false;
                break;        
            }
        }
        if (flag)
        {
            System.out.println("congrats you made it");
        }
    }
    
    public void shuffleTiles()  {
         
        r = new Random();
        moveNo=0;
        moves.setText("Moves: ".concat(Integer.toString(moveNo)));
        
        for (int i=0;i<15;)
        {
            int j=r.nextInt(15);
            if (button[j].getLabel().equals("0"))
            {
                button[j].setLabel(Integer.toString(i+1));                
                i++;
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        for (int i = 0; i < button.length; i++) { 
            
            if(e.getSource()==button[i]){
                
                if(i<15){
                    if(button[i+1].getLabel().equals("")){
                        button[i+1].setLabel(button[i].getLabel());
                        button[i+1].setVisible(true);
                        button[i].setLabel("");
                        button[i].setVisible(false);
                        moves.setText("Moves: ".concat(Integer.toString(++moveNo)));
                        check();
                        
                        return;
                        
                    }
                }
                
                if(i<12){
                    if(button[i+4].getLabel().equals("")){
                        button[i+4].setLabel(button[i].getLabel());
                        button[i+4].setVisible(true);
                        button[i].setLabel("");
                        button[i].setVisible(false);
                        moves.setText("Moves: ".concat(Integer.toString(++moveNo)));
                        check();
                        
                         return;
                    }
                }
                
                if(i>0){
                    if(button[i-1].getLabel().equals("")){
                        button[i-1].setLabel(button[i].getLabel());
                        button[i-1].setVisible(true);
                        button[i].setLabel("");
                        button[i].setVisible(false);
                        moves.setText("Moves: ".concat(Integer.toString(++moveNo)));
                        check();
                        
                         return;
                    }
                }
                
                if(i>3){
                    if(button[i-4].getLabel().equals("")){
                        button[i-4].setLabel(button[i].getLabel());
                        button[i-4].setVisible(true);
                        button[i].setLabel("");
                        button[i].setVisible(false);
                        moves.setText("Moves: ".concat(Integer.toString(++moveNo)));
                        check();  
                        
                         return;
                    }
                }
            }
            
        }
        
        if(e.getSource()==shuffle){
            initButton();
            shuffleTiles();
            return;
            
        }
        else if(e.getSource()==exit){
            System.exit(0);
        }
        
        
        
    }
    
    public static void main(String[] args)  {
        
        SlidingPuzzle obj = new SlidingPuzzle();
        
    }

}