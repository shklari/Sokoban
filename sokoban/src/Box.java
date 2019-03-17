public class Box {
	
	 private Cell c;
	 
	 public Box(Cell c)
	 {
		 this.c = c;
	 }
	 
	 public boolean pushedRight(Board b)
	 {
		 Cell[][] table = b.c;
		 if(table[c._x+1][c._y].isFloor() && (table[c._x +1][c._y].isEmptyFloor()|| table[c._x +1][c._y].isStorage()) && !table[c._x +1][c._y].hasBox()){
			c.set_hasBox(false);
			c.setImage();
			c = table[c._x +1][c._y];
			c.set_hasBox(true);

			c.setImage();
			return true;
		 }
		 return false;
	 }
	 public boolean pushedLeft(Board b)
	 {
		 Cell[][] table = b.c;
			if(table[c._x-1][c._y].isFloor() && (table[c._x -1][c._y].isEmptyFloor()||table[c._x -1][c._y].isStorage()) && !table[c._x -1][c._y].hasBox()){
				c.set_hasBox(false);
				c.setImage();
				c = table[c._x -1][c._y];
				c.set_hasBox(true);

				c.setImage();
				return true;
			}
			return false;
	 }
	 public boolean pushedUp(Board b)
	 {
		 Cell[][] table = b.c;
			if(table[c._x][c._y+1].isFloor() && (table[c._x][c._y+1].isEmptyFloor()||table[c._x][c._y+1].isStorage()) && !table[c._x ][c._y+1].hasBox()){
				c.set_hasBox(false);
				c.setImage();
				c = table[c._x][c._y+1];
				c.set_hasBox(true);

				c.setImage();
				return true;
			}
			return false;
	 }
	 public boolean pushedDown(Board b)
	 {
		 Cell[][] table = b.c;
			if(table[c._x][c._y-1].isFloor() && (table[c._x][c._y-1].isEmptyFloor()||table[c._x][c._y-1].isStorage()) && !table[c._x ][c._y-1].hasBox()){
				c.set_hasBox(false);
				c.setImage();
				c = table[c._x][c._y-1];
				c.set_hasBox(true);

				c.setImage();
				return true;
			}
			return false;
	 }


}