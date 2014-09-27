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
	
	public ImageSheet(Class<?> cl,String p, int w, int h)
	{
		c = cl;
		path = p;
		width = w;
		height = h;
		pixels = new int[width * height];
		load();
	}
	
	private void load()
	{
		try
		{
			BufferedImage image = ImageIO.read(c.getResource(path));
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
