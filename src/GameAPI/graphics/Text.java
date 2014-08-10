package GameAPI.graphics;

import GameAPI.util.Location;

public class Text
{

	Image[] string;
	int x, y;
	
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
}
