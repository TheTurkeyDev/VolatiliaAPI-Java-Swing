package VolatiliaAPI.graphics.basic;

import java.awt.Color;

import VolatiliaAPI.screen.ScreenManager;
import VolatiliaAPI.util.Location;

public class Circle extends BasicObject
{
	private int radius;

	public Circle(int x, int y, int r, Color c)
	{
		super(x, y, r*2, r*2, c);
		radius = r;
		setPixels();
	}

	public Circle(Location loc, int r, Color c)
	{
		super(loc, r*2, r*2, c);
		radius = r;
		setPixels();
	}

	private void setPixels()
	{
		int cx = width/2;
		int cy = height/2;
		for(int yloc = 0; yloc < height; yloc++)
		{
			for(int xloc = 0; xloc < width; xloc++)
			{
				double dist = Math.sqrt(Math.pow(xloc - cx , 2) + Math.pow(yloc - cy , 2));
				System.out.println(dist);
				if(dist <= radius)
					pixels[width * yloc + xloc] = color.getRGB();
				else
					pixels[width * yloc + xloc] = ScreenManager.getInstance().getOmmitColor();
			}
		}
	}
}
