package yan;

import javax.swing.*;
import java.awt.event.*;

public class HelloWorld2 implements ActionListener{
	JButton button;
	public static void main(String[] args){
          HelloWorld2 gui = new HelloWorld2();
          gui.go();
    }
	public void go(){
		   JFrame frame = new JFrame();
	       button = new JButton("click me");
	     
	       button.addActionListener(this);                 // Add listener
	       

	       frame.getContentPane().add(button);	
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       frame.setSize(300, 500);
		   frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent event){
		     button.setText("I've been clicked");
	}
}