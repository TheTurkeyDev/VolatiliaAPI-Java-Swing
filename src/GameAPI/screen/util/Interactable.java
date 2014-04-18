package GameAPI.screen.util;


import GameAPI.Images.Image;

public class Interactable
{
	private int x;
	private int y;
	private int xSize;
	private int ySize;
	private Image selected, unselected;

	private boolean isSelected = false;
	private boolean isHover = true;
	private boolean isClick = false;

	public Interactable(int Bx, int By, int BxSize, int BySize, Image SelectedImage, Image UnSelectedImage)
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

	public Image getSelectedImage()
	{
		return selected;
	}

	public Image getUnSelectedImage()
	{
		return unselected;
	}

	public void setSelected(boolean toggle)
	{
		isSelected = toggle;
	}
	public boolean isSelected()
	{
		return isSelected;
	}

	public Image getCurrentImage()
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

	public int[] getCurrentPixelArray()
	{
		if(isSelected)
			return selected.getPixels();
		else
			return unselected.getPixels();
	}
	
	public void setHover(boolean b)
	{
		isHover = b;
	}
	public void setClick(boolean b)
	{
		isClick = b;
	}
	public boolean isHover()
	{
		return isHover;
	}
	public boolean isClick()
	{
		return isClick;
	}
}
