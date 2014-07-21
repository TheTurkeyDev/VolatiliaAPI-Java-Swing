package GameAPI.screen.screenObjects;


import GameAPI.graphics.Image;

public class Interactable
{
	protected int x;
	protected int y;
	protected int xSize;
	protected int ySize;
	protected Image selectedImage;
	protected Image unSelectedImage;

	protected boolean isSelected = false;
	
	protected boolean isVisible = true;

	protected String name;
	
	public Interactable(int Bx, int By, int BxSize, int BySize, Image si, Image usi, String n)
	{
		x = Bx;
		y = By;
		xSize = BxSize;
		ySize = BySize;
		selectedImage = si;
		unSelectedImage = usi;
		name = n;
	}

	public boolean contains(int mX, int mY)
	{
		if((mX > x && mX < x+xSize) && (mY > y && mY < y+ySize))
		{
			return true;
		}
		return false;
	}
	
	public void onClick()
	{
		
	}
	public void onHover()
	{
		
	}
	public void onUnHover()
	{
		
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
		return (isSelected) ? selectedImage : unSelectedImage;
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
		return x;
	}
	public int getY()
	{
		return y;
	}

	public int[] getCurrentPixelArray()
	{
		if(isSelected)
			return selectedImage.getPixels();
		else
			return unSelectedImage.getPixels();
	}
	
	public void show()
	{
		isVisible = true;
	}
	public void hide()
	{
		isVisible = false;
	}
	public boolean isVisible()
	{
		return isVisible;
	}
	
	public String getName()
	{
		return name;
	}
}
