package GameAPI.screen.screenObjects;

import GameAPI.graphics.Image;

public class Tile
{
	public final static int SIZE = 64;
	protected int id;
	protected int colorID;
	protected String name;
	protected Image image;

	protected boolean isSelected = false;
	
	protected boolean isVisible = true;
	
	public Tile(Image img, String n, int id, int hex)
	{
		image = img;
		name = n;
		this.id = id;
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
}
