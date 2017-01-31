package yan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HelloWorld2{
	  JFrame frame;
	  JLabel  label;
	public static void main(String[] args){
         HelloWorld2 gui = new HelloWorld2();
         gui.go();
	}
     
	public void go(){
		                 
		  frame = new JFrame();

		  
		   JButton button1 = new JButton("Change color");
		   button1.addActionListener(new ChangeColor());          
		   
		   JButton button2 = new JButton("Change lable");
		   button2.addActionListener(new ChangeLabel());
		   
		   label = new JLabel("I am Label");
		  
		   MyDrawPanel panel = new MyDrawPanel();      
           
	       frame.getContentPane().add(BorderLayout.CENTER,panel);	
	       frame.getContentPane().add(BorderLayout.SOUTH,button1);	
           frame.getContentPane().add(BorderLayout.WEST, label);
           frame.getContentPane().add(BorderLayout.EAST, button2);
	      
	       frame.setSize(800, 800);
		   frame.setVisible(true);
		   
	}
   class ChangeColor implements ActionListener{
	   public void actionPerformed(ActionEvent event){
		   frame.repaint();
	   }
   }
	
   class ChangeLabel implements ActionListener{
	   public void actionPerformed(ActionEvent event){
		   label.setText("Having changed");
	   }
   }
   
}
class MyDrawPanel extends JPanel{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g){
	 
         g.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
		 g.fillOval(100,80,200,180);
		 
	 }
}
