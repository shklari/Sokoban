import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.undo.UndoManager;

public class TAdapter  extends KeyAdapter{

	private Board b;
	private Player p;
	

	
	
	
	public TAdapter(Board b ){
		p = b.p;
		this.b = b;
		
	}
	public void keyPressed(int e){
			
			//int type  = e.getKeyCode();
			if(e==1){
				p.moveRight(b);
				b.repaint();
				
			}
			if(e==2){
				p.moveLeftt(b);
				b.repaint();
			}
			if(e==3){
				p.moveDown(b);
				b.repaint();
			} 
			if(e==4){
				p.moveUp(b);
				b.repaint();
			} 
			
			
		}
	
	@Override
	public void keyPressed(KeyEvent e){
		
		int type  = e.getKeyCode();
		if(type ==KeyEvent.VK_RIGHT){
			p.moveRight(b);
			b.repaint();
			
		}
		if(type ==KeyEvent.VK_LEFT){
			p.moveLeftt(b);
			b.repaint();
		}
		if(type ==KeyEvent.VK_UP){
			p.moveDown(b);
			b.repaint();
		} 
		if(type ==KeyEvent.VK_DOWN){
			p.moveUp(b);
			b.repaint();
		} 
		
		
	}
	
}