package Snake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Board extends JPanel implements ActionListener{
	
    private final int Board_Width = 400;                   //width of the board
    private final int Board_Height = 400;                  //height of the board
    private final int Px_Size = 20;                               //size of each pixel
    private final int Number_Of_Dots = 800;            //number of dots
    private final int Speed = 200;                                //Speed of game
    
    private final int[] x = new int[Number_Of_Dots];     //x coordinates of whole snake
    private final int[] y = new int[Number_Of_Dots];     //y coordinates of whole snake

    private int Snake_Size;
    private int Apple_X;
    private int Apple_Y;
    
    private Image Head;
    private Image Body;
    private Image Apple;
    private Timer timer;

    private boolean gameOver = false; 
    
    private boolean left=true;
    private boolean right=false;
    private boolean up=false;
    private boolean down=false;
    
    
    public Board(){
    	
    	addKeyListener(new KeyDetector());
        setBackground(Color.white);
        setFocusable(true);
    	setPreferredSize(new Dimension(Board_Width,Board_Height));
    	imageNeeded(); 
    	startGame();
        
    }     
    
    private void imageNeeded(){                  //get needed images
    	 
    	 Head  =  new  ImageIcon("src//Snake//Head.jpg").getImage( );
    	 Body  =  new  ImageIcon("src//Snake//Body.jpg").getImage( );
    	 Apple =  new  ImageIcon("src//Snake//Apple.jpg").getImage( );
    	 
     }
     private void startGame(){                     //initialize the game 
    	   Snake_Size = 3;    //initialize the size of snake
    	   
    	   for(int i = 0 ; i<Snake_Size ; i++){      //initialize the position of snake
    		   x[i] = 160 + 20*i;
    		   y[i] = 160 ;
    	   }
    	   
    	  setAppleLocation( );    
    	 
    	  timer = new Timer(Speed,this);
    	  timer.start();
     }
   
     private  void setAppleLocation(){              // set the location of apple randomly
    	int i = 0 ;
    	
    	while(true){                                // make sure new apple is not on the snake body
        	Apple_X  = (int)(Math.random()*19);
       	    Apple_Y = (int)(Math.random()*19);
        	Apple_X *= Px_Size;
        	Apple_Y *= Px_Size;
    		
       	    for( i =0 ; i<Snake_Size ; i++){                         
    			if(x[i]==Apple_X&&y[i]==Apple_Y) break;
    		}
    		if(i==Snake_Size) break;
    	} 

    }
    
    @Override
    public void paintComponent(Graphics g){
    	
    	super.paintComponent(g);
    	
        drawImage(g);
        
    }
     
    private void drawImage(Graphics g){

    	if(!gameOver){
    		g.drawImage(Apple, Apple_X, Apple_Y,20,20, this);
    		for(int i=0 ; i<Snake_Size ; i++){
    			if(i==0) g.drawImage(Head, x[i], y[i],20,20, this);
    			else     g.drawImage(Body, x[i], y[i],20,20, this);
    		}
    		
    		Toolkit.getDefaultToolkit().sync();
    		
    	}else{
    		
    		endGame(g);
    	}
    } 
    public void endGame(Graphics g){
    	
    	String over =  "Game Over";
    	Font font = new Font("Helbetica",Font.BOLD,15);
    	FontMetrics  fm =  getFontMetrics(font);
    	
    	g.setColor(Color.RED);
    	g.setFont(font);
    	g.drawString(over, (Board_Width-fm.stringWidth(over))/2, Board_Height/2);
    }
    private void eatApple(){          //When the snake eats the Apple
    	 if(x[0]==Apple_X &&y[0]== Apple_Y ){
    		 Snake_Size++;
    		 setAppleLocation();
    	 }
    }
    
    private class KeyDetector extends KeyAdapter{    //Key listener
    	
    	
    	public void keyPressed(KeyEvent e){
    		
    		int key = e.getKeyCode();
    		
    		if(key==KeyEvent.VK_LEFT&&!right&&!left){
    			
    			left = true;
    			up = false;
    			down = false;
    			
    		}
    		if(key==KeyEvent.VK_RIGHT&&!right&&!left){
    			
    			right = true;
    			up = false;
    			down = false;
    			
    		}    		
    		if(key==KeyEvent.VK_UP&&!up&&!down){
    			
    			up = true;
    			left = false;
    			right = false;
    			
    		}    		
    		if(key==KeyEvent.VK_DOWN&&!up&&!down){
    			
    			down = true;
    			left = false;
    			right = false;
    			
    		}    		
    		
    	}
    	
    }
    public void actionPerformed(ActionEvent e){
    	
    	if(!gameOver){
    		
    		eatApple();
    		checkHit();
    		moveSnake();
    		
    	}
    	repaint(); 	
    }
    
    public void checkHit(){
    	
    	for(int i = 1 ; i<Snake_Size ; i++){
    		if(x[i]==x[0]&&y[i]==y[0]){
    			gameOver = true;
    			timer.stop();
    			return;		
    		}
    	}
    	if(x[0]<0||x[0]>=Board_Width||y[0]<0||y[0]>=Board_Height)  {
    		gameOver = true;
    		timer.stop();
    	}
     }
    public void moveSnake(){
    	
    	for(int i=Snake_Size-1;i>0;i--){
    		
    		x[i] = x[i-1];
    		y[i] = y[i-1];
    		
    	}
    	if(left)  x[0]=  x[1]-20;
    	if(right) x[0] = x[1]+20;
    	if(up)    y[0] = y[1]-20;
    	if(down)  y[0] = y[1]+20;
    }
}

