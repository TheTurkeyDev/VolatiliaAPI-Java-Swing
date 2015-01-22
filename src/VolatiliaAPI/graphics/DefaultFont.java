package VolatiliaAPI.graphics;

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

}
