package yan;

import javax.swing.*;
import java.awt.*;


public class HelloWorld2{
	  JFrame frame;

 
	public void go(){
		                 
		  frame = new JFrame();
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		         
		   
		   MyDrawPanel panel = new MyDrawPanel();      
           
	       frame.getContentPane().add(BorderLayout.CENTER,panel);	

           frame.setSize(400, 400);
		   frame.setVisible(true);
		   
	}

   }
   class MyDrawPanel extends JPanel{

		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g){
		 
	         g.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
			
	         g.fillRect((int)(Math.random()*200),(int)(Math.random()*200),(int)(Math.random()*100),(int)(Math.random()*100));

		 }
	}


