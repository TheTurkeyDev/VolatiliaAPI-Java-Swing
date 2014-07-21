package GameAPI.screen.screenObjects;

import GameAPI.graphics.Image;

public class Tile
{
	public final static int SIZE = 32;
	protected int id;
	protected String colorID;
	protected String name;
	protected Image image;

	protected boolean isSelected = false;
	
	protected boolean isVisible = true;
	
	public Tile(Image img, String n, int id, String hex)
	{
		image = img;
		name = n;
		this.id = id;
		colorID = hex;
	}
	
	public void render(int x, int y)
	{
		
	}
	
	public void update()
	{
		
	}
	
	public boolean solid()
	{
		return false;
	}
	
	public int getSize()
	{
		return SIZE;
	}
	
	public int[] getPixelArray()
	{
		return image.getPixels();
	}
	
	public int getID()
	{
		return id;
	}
	public String getColorCode()
	{
		return colorID;
	}
}
