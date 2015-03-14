package VolatiliaAPI.screen.screenObjects;

import VolatiliaAPI.graphics.Image;
import VolatiliaAPI.map.Map;
import VolatiliaAPI.util.Location;

public class Tile
{
	public static int SIZE = 32;
	protected int id;
	protected short meta = 0;
	protected String colorID;
	protected String name;
	protected Image image;

	protected boolean isSelected = false;
	
	protected boolean isVisible = true;
	
	public Tile(String n, int id, String hex)
	{
		name = n;
		this.id = id;
		colorID = hex;
	}
	
	public void setImage(Image image)
	{
		this.image = image;
	}
	
	public void render(int x, int y)
	{
		
	}
	
	public void update(Map map, Location loc)
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
	
	public int[] getPixels()
	{
		return image.getPixels();
	}
	
	public int getPixelAt(int width, int y, int x)
	{
		return image.getPixels()[width * y + x];
	}
	
	public int getID()
	{
		return id;
	}
	
	public void setMeta(short m)
	{
		meta = m;
	}
	public int getMeta()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String getColorCode()
	{
		return colorID;
	}
	
	public static void setTileSize(int s)
	{
		SIZE = s;
	}
}
