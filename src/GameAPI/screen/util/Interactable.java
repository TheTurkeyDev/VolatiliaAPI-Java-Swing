package GameAPI.screen.util;

import GameAPI.sprite.Sprite;

public class Interactable
{
	private int x;
	private int y;
	private int xSize;
	private int ySize;
	private Sprite selected, unselected;
	
	private boolean isSelected = false;
	
	public Interactable(int Bx, int By, int BxSize, int BySize, Sprite SelectedImage, Sprite UnSelectedImage)
	{
		x = Bx;
		y = By;
		xSize = BxSize;
		ySize = BySize;
		selected = SelectedImage;
		unselected = UnSelectedImage;
	}
	
	public boolean contains(int mX, int mY)
	{
		if((mX > x && mX < x+xSize) && (mY > y && mY < y+ySize))
		{
			return true;
		}
		return false;
	}
	
	public Sprite getSelectedImage()
	{
		return selected;
	}
	
	public Sprite getUnSelectedImage()
	{
		return unselected;
	}
	
	public void isSelected(boolean toggle)
	{
		isSelected = toggle;
	}
	
	public Sprite getCurrentImage()
	{
		return (isSelected) ? selected : unselected;
	}
	
	public int getHeight()
	{
		return ySize;
	}
	public int getWidth()
	{
		return xSize;
	}
	
	public int getX()
	{
		return y;
	}
	public int getY()
	{
		return x;
	}
}
