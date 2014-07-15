package GameAPI.screen.screenObjects;

import GameAPI.Images.Image;
import GameAPI.screen.Screen;

public class Tile extends ScreenObject
{
	public Tile(int Bx, int By, int BxSize, int BySize, Image img, String n)
	{
		super(Bx,By,BxSize,BySize,img, null,n);
	}
	
	public void render(int xLoc, int yLoc, Screen screen)
	{
		
	}
	
	public boolean solid()
	{
		return false;
	}
}
