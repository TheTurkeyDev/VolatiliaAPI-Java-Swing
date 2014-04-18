package GameAPI.screen.util;

import GameAPI.Images.Image;

public class Button extends Interactable
{
	int x;
	int y;
	int xSize;
	int ySize;
	boolean isSelected = false;
	Image Selected, Unselected;
	
	public Button(int Bx, int By, int BxSize, int BySize, Image SelectedImage, Image UnSelectedImage)
	{
		super(Bx,By,BxSize,BySize,SelectedImage,UnSelectedImage);
		x = Bx;
		y = By;
		xSize = BxSize;
		ySize = BySize;
		Selected = SelectedImage;
		Unselected = UnSelectedImage;
	}
	public Button(int Bx, int By, int BxSize, int BySize, Image SelectedImage)
	{
		super(Bx,By,BxSize,BySize,SelectedImage,SelectedImage);
		x = Bx;
		y = By;
		xSize = BxSize;
		ySize = BySize;
		Selected = SelectedImage;
		Unselected = SelectedImage;
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
