package GameAPI.screen.screenObjects;

import GameAPI.Images.Image;

public class ScreenObject
{
	protected int x;
	protected int y;
	protected int xSize;
	protected int ySize;
	protected Image image;
	protected Image image2;

	protected boolean isSelected = false;
	
	protected boolean isVisible = true;

	
	protected String name;

	public ScreenObject(int Bx, int By, int BxSize, int BySize, Image img, Image img2, String n)
	{
		x = Bx;
		y = By;
		xSize = BxSize;
		ySize = BySize;
		image = img;
		image2 = img2;
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

	public Image getImage()
	{
		return image;
	}

	public Image getSecondaryImage()
	{
		return image2;
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

	public int[] getPixelArray()
	{
		return image.getPixels();
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
	
	public void setImage(Image img)
	{
		image = img;
	}
	
	public String getName()
	{
		return name;
	}
}
