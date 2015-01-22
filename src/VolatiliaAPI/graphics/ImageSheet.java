package VolatiliaAPI.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageSheet
{
	private int[] pixels;
	private int width, height;
	
	private Class<?> c;
	private String path;
	
	public ImageSheet(Class<?> cl,String p)
	{
		c = cl;
		path = p;
		load();
	}
	
	private void load()
	{
		try
		{
			BufferedImage image = ImageIO.read(c.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			pixels = new int[width * height];
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public int[] getPixels()
	{
		return pixels;
	}
	
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
}
