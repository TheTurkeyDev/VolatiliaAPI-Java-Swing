package GameAPI.graphics;

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
}
