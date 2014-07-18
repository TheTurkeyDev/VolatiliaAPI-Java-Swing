package GameAPI.graphics;

import java.util.ArrayList;

public class Font
{

	private ImageSheet fontSheet;
	private int size;
	
	private ArrayList<Image> characters = new ArrayList<Image>();
	
	public Font(ImageSheet fs, int s)
	{
		fontSheet = fs;
		size = s;
		loadCharecters();
	}
	
	private void loadCharecters()
	{
		
	}
	
}
