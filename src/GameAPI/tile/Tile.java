package GameAPI.tile;

import GameAPI.Images.Image;
import GameAPI.screen.Screen;

public class Tile
{

	public int x, y;
	public Image sprite;
	
	public Tile(Image tileSprite)
	{
		sprite = tileSprite;
	}
	
	public void render(int x, int y, Screen screen)
	{
		
	}
	
	public boolean isSolid()
	{
		return false;
	}
}
