public class Player {

	private Cell c;
	public Player(Cell c){
		this.c = c;
	}
	
	public void moveRight(Board b){
		Cell[][] table = b.c;
		if(table[c._x +1][c._y].isFloor() && (table[c._x +1][c._y].isEmptyFloor()||table[c._x +1][c._y].isStorage()) && !table[c._x +1][c._y]._hasBox){
			c.set_hasPlayer(false);
			c.setImage();
			c = table[c._x +1][c._y];
			c.set_hasPlayer(true);
			c.setImage();
			b.moves.push(new String("playerleft"));
			b.m.reclac();
		}
		else
		{
			if(table[c._x +1][c._y].hasBox())
			{
				Cell s = table[c._x +1][c._y];
				Box box = s.getBox();
				if(box.pushedRight(b))
				{
					this.moveRight(b);
					c.setImage();
					b.moves.push(box);
					b.moves.push("boxleft");
				}
			}
		}
		c.setImage();
	}
	
	public void moveLeftt(Board b){
		Cell[][] table = b.c;
		if(table[c._x -1][c._y].isFloor() && (table[c._x -1][c._y].isEmptyFloor()||table[c._x -1][c._y].isStorage()) && !table[c._x -1][c._y]._hasBox){
			c.set_hasPlayer(false);
			c.setImage();
			c = table[c._x -1][c._y];
			c.set_hasPlayer(true);
			c.setImage();
			b.moves.push(new String("playerright"));
			b.m.reclac();
		}
		else
		{
			if(table[c._x -1][c._y].hasBox())
			{
				Cell s = table[c._x -1][c._y];
				Box box = s.getBox();
				if(box.pushedLeft(b))
				{
					this.moveLeftt(b);
					c.setImage();
					b.moves.push(box);
					b.moves.push("boxright");
				}
			}
		}
		c.setImage();
	}
	
	public void moveUp(Board b){
		Cell[][] table = b.c;
		if(table[c._x ][c._y+1].isFloor() && (table[c._x ][c._y+1].isEmptyFloor()||table[c._x ][c._y+1].isStorage()) && !table[c._x ][c._y+1]._hasBox){
			c.set_hasPlayer(false);
			c.setImage();
			c = table[c._x ][c._y+1];
			c.set_hasPlayer(true);
			c.setImage();
			b.moves.push(new String("playerdown"));
			b.m.reclac();
		}
		else
		{
			if(table[c._x ][c._y+1].hasBox())
			{
				Cell s = table[c._x ][c._y+1];
				Box box = s.getBox();
				if(box.pushedUp(b))
				{
					this.moveUp(b);
					c.setImage();
					b.moves.push(box);
					b.moves.push("boxdown");
				}
			}
		}
		c.setImage();
	}
	
	public void moveDown(Board b){
		Cell[][] table = b.c;
		if(table[c._x ][c._y-1].isFloor() && (table[c._x ][c._y-1].isEmptyFloor()||table[c._x ][c._y-1].isStorage() && !table[c._x ][c._y-1].hasBox()) && !table[c._x ][c._y-1]._hasBox){
			c.set_hasPlayer(false);
			c.setImage();
			c = table[c._x ][c._y-1];
			c.set_hasPlayer(true);
			c.setImage();
			b.moves.push(new String("playerup"));
			b.m.reclac();
		}
		else
		{
			if(table[c._x ][c._y-1].hasBox())
			{
				Cell s = table[c._x ][c._y-1];
				Box box = s.getBox();
				if(box.pushedDown(b))
				{
					this.moveDown(b);
					c.setImage();
					b.moves.push(box);
					b.moves.push("boxup");
				}
			}
		}
		c.setImage();
	}
}