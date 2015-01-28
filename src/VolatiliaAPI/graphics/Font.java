package VolatiliaAPI.graphics;

public class Font
{

	private ImageSheet fontSheet;
	private int size;
	private int incSize;
	private Image[] letters = new Image[96];

	public Font(ImageSheet fs, int s)
	{
		fontSheet = fs;
		size = s;
		incSize = 1;
		loadCharecters();
	}

	private void loadCharecters()
	{
		for(int y = 0; y < (fontSheet.getHeight()/size); y++)
		{
			for(int x = 0; x < (fontSheet.getWidth()/size); x++)
			{
				Image image = new Image(fontSheet, x * size, y * size, size, size);
				image = image.scale(incSize);
				letters[(fontSheet.getWidth() / size) * y + x] = image;
			}
		}
	}

	public Image[] getStringImage(String s)
	{
		Image[] stringImages = new Image[s.length()];
		for(int i = 0; i < s.length(); i++)
		{
			stringImages[i] = letters[s.charAt(i) - 32];
		}
		return stringImages;
	}

	public Font setMultiplySize(int s)
	{
		incSize = s;
		loadCharecters();
		return this;
	}

	public int GetBaseSize()
	{
		return size;
	}

	public int GetCurrentSize()
	{
		return size*incSize;
	}
}
