package VolatiliaAPI.graphics.basic;

import java.awt.Color;

import VolatiliaAPI.util.Location;

public class BasicObject
{
	protected int x, y, width, height;
	protected Color color;
	protected int[] pixels;
	
	public BasicObject(int x, int y, int w, int h, Color c)
	{
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		color = c;
		pixels = new int[width * height];
	}
	
	public BasicObject(Location loc, int w, int h, Color c)
	{
		x =loc.getX();
		y = loc.getY();
		width = w;
		height = h;
		color = c;
		pixels = new int[width * height];
	}
	
	public Location getLocation()
	{
		return new Location(x,y);
	}
	
	public int[] getPixles()
	{
		return pixels.clone();
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
}
