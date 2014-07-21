package GameAPI.screen.screenObjects;

import GameAPI.screen.Screen;
import GameAPI.graphics.Image;

public class Tile
{
	protected int x;
	protected int y;
	protected int xSize;
	protected int ySize;
	protected Image image;

	protected boolean isSelected = false;
	
	protected boolean isVisible = true;

	
	protected String name;
	
	public Tile(int Bx, int By, int BxSize, int BySize, Image img, String n)
	{
		x = Bx;
		y = By;
		xSize = BxSize;
		ySize = BySize;
		image = img;
		name = n;
	}
	
	public void render(int xLoc, int yLoc, Screen screen)
	{
		
	}
	
	public boolean solid()
	{
		return false;
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	
	public int getWidth()
	{
		return image.getWidth();
	}
	public int getHeight()
	{
		return image.getHeight();
	}
	
	public int[] getPixelArray()
	{
		return image.getPixels();
	}
}
