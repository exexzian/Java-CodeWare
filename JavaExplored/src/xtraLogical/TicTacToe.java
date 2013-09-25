package xtraLogical;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;

/**
 * 
 * @author hacker
 */
public class TicTacToe extends Frame implements ActionListener{
    
    Panel board;
    Button[] tile;
    Label winner;
    Button exit;
    Button restart;
    Label player1;
    Label player2;
    Dialog won;
    
    int turn=1;
    
    public TicTacToe() {
        
        setLayout(null);
        setSize(500,500);
        setLocation(50,50);
        setTitle("Tic-Tac-Toe");
        
        exit = new Button("exit");
        restart = new Button("Restart");
        
        player1 = new Label("Player 1 - X");
        player2 = new Label("Player 2 - 0");
        
        board = new Panel(new GridLayout(3, 3));
        board.setSize(300,300);
        board.setLocation(130,100);
        winner = new Label("Winners is");
        winner.setBackground(Color.gray);
        
        player1.setBounds(30,50,80,40);
        player2.setBounds(390,50,80,40);
        
        winner.setBounds(20,250,100,40);
        
        tile = new Button[9];
        
        exit.setBounds(200,450,50,40);
        restart.setBounds(280, 450, 50, 40);
        
        add(board);
        add(exit);
        add(restart);
        add(player1);
        add(player2);
        add(winner);
        
        exit.addActionListener(this);
        restart.addActionListener(this);
        
        for (int i = 0; i < tile.length; i++) {
            tile[i] = new Button("");
            board.add(tile[i]);
            tile[i].addActionListener(this);
        }
        setVisible(true);
    }
    
    public void initButtons(){
        for (int i = 0; i < tile.length; i++) {
            tile[i].setLabel("");
        }
    }
    
    public String getPlayer1(){
        return "X";
    }
    
    public String getPlayer2(){
        return "0";
    }
    
    Button ok = new Button("OK");
    
    public void callDialog(){
        won = new Dialog(this, "WON", true);
        won.setSize(100,100);
        won.setLocation(300,300);
        won.add(new Label(((turn%2==0)?("Player 2"):("Player 1")).concat("-- WON")),BorderLayout.NORTH);
        won.add(ok,BorderLayout.CENTER);
        ok.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        won.setVisible(true);
    }
    
    public void winLogic(){
       
        for (int i = 0,j=0; i <=6; i=i+3,j++) {
            if((tile[i].getLabel().equals(tile[i+1].getLabel()))&&(tile[i+1].getLabel().equals(tile[i+2].getLabel())) && !(tile[i].getLabel().isEmpty())){
                
                winner.setText(((turn%2==0)?"Player 2":"Player 1") + "--winssss!!!");
                winner.setBackground(Color.red);
                callDialog();
                
                break;                
            }
            if((tile[j].getLabel().equals(tile[j+3].getLabel()))&&(tile[j+3].getLabel().equals(tile[j+6].getLabel())) && !(tile[j].getLabel().isEmpty())){
                winner.setText(((turn%2==0)?("Player 2"):("Player 1")) + "--winssss!!!");
                winner.setBackground(Color.red);
                
                callDialog();
                break;
            }
        }
        
        if(((tile[0].getLabel().equals(tile[4].getLabel()))&&(tile[4].getLabel().equals(tile[8].getLabel())) && !(tile[0].getLabel().isEmpty()))||
             ((tile[2].getLabel().equals(tile[4].getLabel()))&&(tile[4].getLabel().equals(tile[6].getLabel())) && !(tile[2].getLabel().isEmpty()))){
            winner.setText(((turn%2==0)?("Player 2"):("Player 1")) + "--winssss!!!");
            winner.setBackground(Color.red);
            callDialog();
        }
    }
    
    
    public static void main(String[] args) {
        new TicTacToe();
    }
    /**
     * 
     * @param e 
     */
    public void actionPerformed(ActionEvent e) {
        
        for (int i = 0; i < tile.length; i++) {
            if(e.getSource()==tile[i]){
                if (tile[i].getLabel().isEmpty()) {
                    if (turn % 2 != 0) {
                        player1.setBackground(Color.gray);
                        player2.setBackground(Color.green);
                        tile[i].setLabel(getPlayer1());
                        
                        winLogic();
                        
                        turn++;
                        return;
                    } else {
                        player1.setBackground(Color.green);
                        player2.setBackground(Color.gray);
                        tile[i].setLabel(getPlayer2());
                        
                        winLogic();
                        
                        turn++;
                        return;
                    }
                }
                
            }
            
        }
        
        if(e.getSource()==exit){
            System.exit(0);
        }
        if(e.getSource()==restart){
            initButtons();
            winner.setBackground(Color.gray);
            return;
        }
        
        
        
    }
}
