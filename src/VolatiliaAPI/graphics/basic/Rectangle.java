package VolatiliaAPI.graphics.basic;

import java.awt.Color;

import VolatiliaAPI.util.Location;

public class Rectangle extends BasicObject
{

	public Rectangle(int x, int y, int w, int h, Color c)
	{
		super(x, y, w, h, c);
		setPixels();
	}

	public Rectangle(Location loc, int w, int h, Color c)
	{
		super(loc, w, h, c);
		setPixels();
	}

	private void setPixels()
	{
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				pixels[width * y + x] = color.getRGB();
			}
		}
	}
}