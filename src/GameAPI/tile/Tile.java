package GameAPI.tile;

import GameAPI.screen.Screen;
import GameAPI.sprite.Sprite;

public class Tile
{

	public int x, y;
	public Sprite sprite;
	
	public Tile(Sprite tileSprite)
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
