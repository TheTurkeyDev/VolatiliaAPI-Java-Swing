package GameAPI.util;

public class Location 
{
	int x;
	int y;
	
	public Location(int xloc, int yloc)
	{
		x = xloc;
		y = yloc;
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
}
