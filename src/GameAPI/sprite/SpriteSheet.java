package GameAPI.sprite;

import java.awt.image.BufferedImage;

public class SpriteSheet
{

	private BufferedImage image;
	public final int SIZE;
	public int[][] pixels;

	public SpriteSheet(BufferedImage newImage, int size)
	{
		image = newImage;
		SIZE = size;
		pixels = new int[SIZE][SIZE];
		load();
	}

	private void load()
	{
		int width = image.getWidth();
		int height = image.getHeight();
		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < height; y++)
			{
				pixels[x][y] = image.getRGB(0, 0);
			}
		}
	}
}
