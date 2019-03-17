import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JPanel {
	
	//fields
	public Cell[][] c;
	public JLabel[][] show;
	public Player p;
	public Game m;
	ImageIcon image = new ImageIcon("win.png");
    int x = 250;
    int y = 250;
    public Stack moves;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        image.paintIcon(this, g, x, y);
    }
    public void findPlayer(Cell[][] luah){
    	for(int i=0; i<c.length; i++)
		{
			for(int j=0; j< c[i].length; j++)
			{
				c[i][j] = new Cell(luah[i][j]);
				if(c[i][j].hasPlayer())
				{
					if(p == null)
						throw new RuntimeException("more than one player in the board");
					p = new Player(c[i][j]);
					break;
				}
			}
		}
    }
	public Board(Game m,Cell[][] luah)
	{	
		moves = new Stack<Object>();
		this.m = m;
		if(luah == null || luah.length == 0)
			throw new IllegalArgumentException();
		c = new Cell[luah.length][luah[0].length];
		for(int i=0; i<c.length; i++)
		{
			for(int j=0; j< c[i].length; j++)
			{
				c[i][j] = new Cell(luah[i][j]);
				if(c[i][j].hasPlayer())
				{
					if(p != null)
						throw new RuntimeException("more than one player in the board");
					p = new Player(c[i][j]);
				}
			}
		}
		
		if(p == null)
			throw new RuntimeException("no player in the board");
		setPreferredSize(new Dimension(c.length, c[0].length));
		m.addKeyListener(new TAdapter(this));
		setFocusable(true);
		
	}

	@Override
	public void paint(Graphics gr){
		super.paint(gr);
		if(isWin()){
			
			paintComponent(gr);
		}else{
			for (int i = 0; i < c.length; i++) {
				for (int j = 0; j < c[i].length; j++) {
					
					Cell cc = c[i][j];
					gr.drawImage(cc.getImage().getImage(), i * 70, j * 70, this);
				}
			}
		}
		
	}
	private Boolean isWin(){
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				
				Cell thisCell = c[i][j];
			
				if(thisCell.isStorage()&&!thisCell.hasBox()){
					return false;
				}
			}
			
		}
		return true;
		
	}
}