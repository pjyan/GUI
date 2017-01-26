package yan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HelloWorld2 implements ActionListener{
	  JFrame frame;
	  
	public static void main(String[] args){
         HelloWorld2 gui = new HelloWorld2();
         gui.go();
	}
     
	public void go(){
		                 
		  frame = new JFrame();
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		  
		   JButton button = new JButton("Click to change color");
		   button.addActionListener(this);            //Add listener
		   
		   MyDrawPanel panel = new MyDrawPanel();      
           
	       frame.getContentPane().add(BorderLayout.CENTER,panel);	
	       frame.getContentPane().add(BorderLayout.SOUTH,button);	

	       frame.setSize(400, 400);
		   frame.setVisible(true);
		   
	}
   public void actionPerformed(ActionEvent event){
	   frame.repaint();
   }
	
}
class MyDrawPanel extends JPanel{
	 public void paintComponent(Graphics g){
	 
         g.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
		 g.fillOval(100,80,200,180);
		 
	 }
}
