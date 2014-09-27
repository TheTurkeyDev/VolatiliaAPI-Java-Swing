package VolatiliaAPI.graphics;

public class Background
{
	
	private Image image;
	
	public Background(Image img)
	{
		image = img;
	}
	
	public int[] getPixles()
	{
		return image.getPixels().clone();
	}
	
	public int getWidth()
	{
		return image.getWidth();
	}
	
	public int getHeight()
	{
		return image.getHeight();
	}
}
