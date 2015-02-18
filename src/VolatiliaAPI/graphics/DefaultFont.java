package VolatiliaAPI.graphics;

import VolatiliaAPI.screen.ScreenManager;

public class DefaultFont extends Font
{

	private static DefaultFont defaultFont;
	
	public DefaultFont()
	{
		super(new ImageSheet(DefaultFont.class, "/Images/Font/font.png"), 8);
		defaultFont = this;
	}
	
	public static DefaultFont getDefaultFont()
	{
		return defaultFont;
	}
	
	
	protected void loadCharacters()
	{
		for(int y = 0; y < (fontSheet.getHeight()/size); y++)
		{
			for(int x = 0; x < (fontSheet.getWidth()/size); x++)
			{
				Image image = new Image(fontSheet, x * size, y * size, size, size);
				image = image.scale(incSize);
				image.switchColor(-65316, ScreenManager.getInstance().getOmmitColor());
				letters[(fontSheet.getWidth() / size) * y + x] = image;
			}
		}
	}
}