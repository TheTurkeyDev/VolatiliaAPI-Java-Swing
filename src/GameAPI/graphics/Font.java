package GameAPI.graphics;

public class Font
{

	private ImageSheet fontSheet;
	private int size;
	private Image[] letters = new Image[96];
	
	public Font(ImageSheet fs, int s)
	{
		fontSheet = fs;
		size = s;
		loadCharecters();
	}
	
	private void loadCharecters()
	{
		for(int y = 0; y < (fontSheet.getHeight() / size) ; y++)
		{
			for(int x = 0; x < (fontSheet.getWidth() / size); x++)
			{
				Image image = new Image(fontSheet, x * size, y * size, size, size);
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
	
}
