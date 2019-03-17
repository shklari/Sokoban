import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.*;

public class MainWIndow extends JFrame implements ActionListener{
	
	
	private Board b;
	private int num;
	int numberOfStage;
	JButton[] buttons;
	LevelLoader l;
	
	
	
	public MainWIndow(LevelLoader l)  throws IOException {
		super("Sokoban");
		this.l = l;

		
		numberOfStage = l.getLevelsCount();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		JPanel aj = new JPanel();
		aj.setPreferredSize(new Dimension(2000, 1800));
		buttons  = new JButton[numberOfStage];
		for(int i = 0; i < buttons.length; i++)
	    {
	        // make new button name 
	        JButton btn = new JButton("Stage:  " + i);
	        buttons[i]  = btn;
	        btn.setFont(new Font("Serif", Font.PLAIN, 54));
	        btn.addActionListener(this);
	        btn.setPreferredSize(new Dimension(500, 380));
	        // add button to panel
	        aj.add(btn);
	    }
		this.getContentPane().add(aj,BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(2000, 1800));
		this.pack();
		this.setVisible(true);
		setFocusable(true);
	}
	
	//@Override
	  public void actionPerformed(ActionEvent evt) {
		  Object src = evt.getSource();
		  for (int i = 0; i < numberOfStage; i++) {
			  
			   if (src == buttons[i]) {
				   try {
						Game m = new Game(i, l);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			     //First button actions
			   } 
		} 
		
	
	}
	  
	
}