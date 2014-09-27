package VolatiliaAPI.util;

public class Location 
{
	int x;
	int y;

	public Location(int xloc, int yloc)
	{
		x = xloc;
		y = yloc;
	}

	public enum Direction
	{
		North,
		South,
		East, 
		West;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public Location add(int xa, int ya)
	{
		return new Location(x+xa,y+ya);
	}

	public Location subtract(int xa, int ya)
	{
		return new Location(x-xa, y-ya);
	}

	public Location multiply(int xa, int ya)
	{
		return new Location(x*xa, y*ya);
	}

	public Location divide(int xa, int ya)
	{
		return new Location(x/xa, y/ya);
	}
	
	public boolean equals(Location loc)
	{
		if(x == loc.getX() && y == loc.getY())
			return true;
		return false;
	}
}
