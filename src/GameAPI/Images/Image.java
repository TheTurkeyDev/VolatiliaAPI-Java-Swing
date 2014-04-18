package GameAPI.Images;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image 
{
	public static Image BeginS = new Image(Image.getImage("BeginSelectedButton.png"));
	public static Image BeginUS = new Image(Image.getImage("BeginUnSelectedButton.png"));
	BufferedImage image;
	
	public Image(BufferedImage img)
	{
		image = img;
	}
	
	public static BufferedImage getImage(String name){
		try {
			return ImageIO.read(Image.class.getResource("/images/"+name));
		} catch (IOException e) {
			return null;
		}
	}
	
	public int[] getPixels()
	{
		int w = image.getWidth(), h=image.getHeight();
		return image.getRGB(0, 0, w, h, new int[w*h], 0, w);
	}
	
	public int[] getSubPixels(int x, int y, int xsize, int ysize)
	{
		int w = image.getWidth(), h=image.getHeight();
		return image.getRGB(x, y, xsize, ysize, new int[w*h], 0, xsize);
	}
	
	public BufferedImage getSubImage(int x, int y, int xsize, int ysize)
	{
		return image.getSubimage(x, y, xsize, ysize);
	}
	
}
