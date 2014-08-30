package GameAPI.graphics;

public class Image 
{
	private ImageSheet image;
	private int width, height, x, y;
	private int[] pixels;
	
	public Image(ImageSheet img,int x, int y, int w, int h)
	{
		image = img;
		width = w;
		height = h;
		this.x = x;
		this.y = y;
		pixels = new int[width * height];
		loadPixels();
	}
	
	private void loadPixels()
	{
		int[] imagePix = image.getPixels();
		for(int xx = 0; xx < width; xx++)
			for(int yy = 0; yy < height; yy++)
				pixels[width*yy+xx] = imagePix[(y+yy)*image.getWidth() + (x+xx)];
	}
	
	public int[] getPixels()
	{
		return pixels.clone();
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
