package GameAPI.screen.util;

import GameAPI.Images.Image;

public class Button extends Interactable
{
	
	public Button(int Bx, int By, int BxSize, int BySize, Image SelectedImage, Image UnSelectedImage, String n)
	{
		super(Bx,By,BxSize,BySize,SelectedImage,UnSelectedImage, n);
	}
	public Button(int Bx, int By, int BxSize, int BySize, Image SelectedImage, String name)
	{
		super(Bx,By,BxSize,BySize,SelectedImage,SelectedImage, name);
	}
	
	public boolean contains(int mX, int mY)
	{
		if((mX > x && mX < x+xSize) && (mY > y && mY < y+ySize))
		{
			return true;
		}
		return false;
	}
}
