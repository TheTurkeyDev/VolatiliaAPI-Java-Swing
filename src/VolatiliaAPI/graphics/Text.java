package VolatiliaAPI.graphics;

import VolatiliaAPI.util.Location;

public class Text
{

	private Image[] string;
	private int x, y;
	
	private boolean visible = true;
	
	public Text(Image[] stringImage, int xLoc, int yLoc)
	{
		string = stringImage;
		x = xLoc;
		y = yLoc;
	}
	
	public Location getLocation()
	{
		return new Location(x, y);
	}
	
	public int getImageAmount()
	{
		return string.length;
	}
	
	public Image getImageAt(int index)
	{
		return string[index];
	}
	
	public void setText(Image[] newString)
	{
		string = newString;
	}
	
	public void show()
	{
		visible = true;
	}
	public void hide()
	{
		visible = false;
	}	
	public boolean isVisible()
	{
		return visible;
	}
}
