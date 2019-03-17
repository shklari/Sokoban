import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.*;

public class Game extends JFrame implements ActionListener{
	
	
	private Board b;
	int num;
	private JLabel leb = new JLabel("steps:  "+ num);
	int staage;
	LevelLoader l;
	JPanel buttons = new JPanel();
	
	
	public Game(int stage, LevelLoader l) throws IOException {
		super("Sokoban");
		this.l = l;
		this.staage = stage;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		this.setFocusable(true);
		
		
		JTabbedPane tp = new JTabbedPane();
		int numberOfStage = l.getLevelsCount();
		leb.setPreferredSize(new Dimension(90, 90));
		leb.setFont(new Font("Serif", Font.PLAIN, 45));
	
		
		JButton j = new JButton("Restart this stage ");
		j.addActionListener(this);
		j.setFont(new Font("Serif", Font.PLAIN, 54));
		//j.setPreferredSize(new Dimension(200,10));
		JButton j2 = new JButton( new AbstractAction("Back to main window") { 
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	        	setVis();
	        }
	    });
		j2.addActionListener(this);
		j2.setFont(new Font("Serif", Font.PLAIN, 40));
		j2.setFocusable(false);
		JButton undo = new JButton(new AbstractAction("Undo") {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	        	prevMove();
	        }
		});
		j2.setFocusable(false);
		undo.setFocusable(false);
		buttons.setPreferredSize(new Dimension(400,100));
		buttons.add(j);
		buttons.add(j2);
		buttons.add(undo);
		buttons.setFocusable(false);
		buttons.setRequestFocusEnabled(false);
		b = new Board(this, l.get(stage));
		//j.setPreferredSize(new Dimension(200, 180));

		this.getContentPane().add(buttons,BorderLayout.EAST);
		this.getContentPane().add(leb,BorderLayout.SOUTH);
		this.getContentPane().add(b,BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(2000, 1800));
		this.pack();
		this.setVisible(true);
		this.setFocusable(true);
	}
	public void reclac(){
		num++;
		leb.setText("steps:  "+ num);
	
	}
	
	private void prevMove()
	{
		if(!b.moves.isEmpty())
		{
			Object o = b.moves.pop();
			if(o instanceof String)
			{
				TAdapter t = new TAdapter(b);
				String s = (String)o;
				if (s.equals("playerright")) 
				{
				    b.p.moveRight(b);
					b.moves.pop();
					num= num-2;
					leb.setText("steps:  "+ num);
				}
				if(s.equals("playerleft"))
				{
					b.p.moveLeftt(b);
					b.moves.pop();
					num= num-2;
					leb.setText("steps:  "+ num);
				}
				if(s.equals("playerup"))
				{
					b.p.moveUp(b);
					b.moves.pop();
					num= num-2;
					leb.setText("steps:  "+ num);
				}
				if(s.equals("playerdown"))
				{
					b.p.moveDown(b);
					b.moves.pop();
					num= num-2;
					leb.setText("steps:  "+ num);
				}
				if(s.equals("boxright")) 
				{
					Box tmp = ((Box)b.moves.pop());
					prevMove();
					tmp.pushedRight(b);
				}
				if(s.equals("boxleft")) 
				{
					Box tmp = ((Box)b.moves.pop());
					prevMove();
					tmp.pushedLeft(b);
				}
				if(s.equals("boxup")) 
				{
					Box tmp = ((Box)b.moves.pop());
					prevMove();
					tmp.pushedUp(b);
				}
				if(s.equals("boxdown")) 
				{
					Box tmp = ((Box)b.moves.pop());
					prevMove();
					tmp.pushedDown(b);
				}
				b.repaint();
				this.setFocusable(true);
				b.setFocusable(true);
				buttons.setFocusable(false);
			}
			else
				throw new RuntimeException("something wrong with the stack");
		}
	}

	public void setVis(){
		try {
    		this.setVisible(true);
			MainWIndow m = new MainWIndow(l);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
    public void actionPerformed(ActionEvent evt) {
		
		try {
			this.setVisible(false);
			Game m = new Game(staage, l);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		LevelLoader l = new LevelLoader();
		
		try{
			l.load("level.txt");
		}catch (IOException e) {
			System.out.println("Could not load file!!");
		}
		
		Game game = new Game(0, l);
		
		
		

	}
	
	
	
  
  
}