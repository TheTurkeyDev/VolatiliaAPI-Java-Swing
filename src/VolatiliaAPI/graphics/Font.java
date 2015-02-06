package VolatiliaAPI.graphics;

public class Font
{

	private ImageSheet fontSheet;
	private int offset = 32;
	private int size;
	private int incSize;
	private Image[] letters = new Image[96];

	public Font(ImageSheet fs, int s)
	{
		fontSheet = fs;
		size = s;
		incSize = 1;
		loadCharacters();
	}

	/**
	 * Loads each character from the font sheet and assigns them to an array.
	 */
	private void loadCharacters()
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

	
	/**
	 * gets an array list of Images (each image being a character) for the given string.
	 * @param string The string to get the character images for.
	 * @return The array of Images that represent the given string.
	 */
	public Image[] getStringImage(String s)
	{
		Image[] stringImages = new Image[s.length()];
		for(int i = 0; i < s.length(); i++)
		{
			stringImages[i] = letters[s.charAt(i) - offset];
		}
		return stringImages;
	}

	/**
	 * increase the size of the font.
	 * @param size The size to multiply the default font size by.
	 * @return The font with the given multiplied size.
	 */
	public Font setMultiplySize(int s)
	{
		incSize = s;
		loadCharacters();
		return this;
	}

	/**
	 * Gets the base default size of the font.
	 * @return The base size of the font.
	 */
	public int GetBaseSize()
	{
		return size;
	}

	/**
	 * Gets the current size of the font. This factors in the multiplied size that is set.
	 * @return The current size of the font.
	 */
	public int GetCurrentSize()
	{
		return size*incSize;
	}
	
	/**
	 * Sets what the offset of the character sheet is. Default is 32 or to the space key. This is used if the given font's font sheet does not start with the space key.
	 * @param offset The offset that the font sheet starts at.
	 */
	public void setCharStartOffset(int off)
	{
		offset = off;
	}
}
