package Snake;


import java.awt.EventQueue;
import javax.swing.JFrame;


public class SnakeGame extends JFrame {

   	public static void main(String[] args){
   		
   		EventQueue.invokeLater(new Runnable(){
   			
   	        public void run(){
   	        	
   	        	SnakeGame snake = new SnakeGame();
   	        	snake.add(new Board());
   	        	snake.setResizable(false);
   	        	snake.pack();
   	        	snake.setTitle("Snake Game");
   	        	snake.setLocationRelativeTo(null);
   	        	snake.setDefaultCloseOperation(EXIT_ON_CLOSE);
   	        	snake.setVisible(true);
   			
   	        }
   			
   		});
   		
   	}
   	
   	
	 
}
