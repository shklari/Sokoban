import java.awt.Image;

import javax.swing.ImageIcon;

public class Cell {

	public final int _x,_y;
	public Boolean _isFloor;
	public Boolean _isStorage;
	public Boolean _hasPlayer;
	public Boolean _hasBox;
	private ImageIcon image;
	
	

	public Cell(int x,int y) {
		_isFloor = false;
		_isStorage = false;
		_hasPlayer = false;
		_hasBox = false;
		_x = x;
		_y = y;
		setImage(new ImageIcon("wall.jpg"));
	}
	
	
	public Cell(int x,int y, Boolean isStorage, Boolean hasPlayer, Boolean hasBox) {
		_isFloor = true;
		_isStorage = isStorage;
		_hasPlayer = hasPlayer;
		_hasBox = hasBox;
		_x = x;
		_y = y;
		setImage();
	}
	public void setImage()
	{
		if(!_isFloor & !_isStorage & !_hasBox & !_hasPlayer){
			setImage(new ImageIcon("wall.jpg"));
		}else if(_isStorage &&!_hasBox&&!_hasPlayer){
			setImage(new ImageIcon("storageA.png"));
		}else if(_hasBox&&!_isStorage){
			setImage(new ImageIcon("BoxBefor.jpg"));
		}else if(_hasPlayer&&!_isStorage){
			setImage(new ImageIcon("PLay.jpg"));
		}else if(_hasBox&&_isStorage){
			setImage(new ImageIcon("Box.jpg"));
		}
		else if(_hasPlayer&&_isStorage){
			setImage(new ImageIcon("‏‏PlayBo.jpg"));
		}
		else{
			setImage(new ImageIcon("wFloorpng.png"));
		}
	}
	
	public Cell(Cell c)
	{
		this(c._x, c._y, c._isStorage, c._hasPlayer, c._hasBox);
		this._isFloor = c._isFloor;
		setImage();
	}
	
	public Box getBox()
	{
		if(_hasBox)
			return new Box(this);
		else
			throw new IllegalArgumentException();
	}
	
	public Boolean isFloor() {
		return _isFloor;
	}
	public Boolean isStorage() {
		return _isStorage;
	}
	public Boolean hasPlayer() {
		return _hasPlayer;
	}
	public Boolean hasBox() {
		return _hasBox;
	}
	
	public void set_isStorage(Boolean _isStorage) {
		if (!_isFloor) return;
		this._isStorage = _isStorage;
	}
	public void set_hasPlayer(Boolean _hasPlayer) {
		if (!_isFloor) return;
		this._hasPlayer = _hasPlayer;
	}
	public void set_hasBox(Boolean _hasBox) {
		if (!_isFloor) return;
		this._hasBox = _hasBox;
	}

	public boolean isEmptyFloor() {
		return isFloor() && !hasBox() && !hasPlayer();
	}
	
	@Override
	public Cell clone() {
		Cell c = new Cell(_x, _y);
		c._hasBox = this._hasBox;
		c._hasPlayer = this._hasPlayer;
		c._isFloor = this._isFloor;
		c._isStorage = this._isStorage;
		return c;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		image.setImage(image.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
		this.image = image;

	}
	
}