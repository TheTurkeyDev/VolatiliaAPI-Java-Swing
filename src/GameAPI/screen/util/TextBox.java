package GameAPI.screen.util;

import GameAPI.sprite.Sprite;

public class TextBox 
{
	int x;
	int y;
	int xSize;
	int ySize;
	int indent = 0;
	boolean isSelected = false;
	Sprite Selected, Unselected;
	String text;
	
	public TextBox(int Bx, int By, int BxSize, int BySize, Sprite Image)
	{
		x = Bx;
		y = By;
		xSize = BxSize;
		ySize = BySize;
		Unselected = Image;
	}
	public TextBox(int Bx, int By, int BxSize, int BySize, Sprite SelectedImage, Sprite UnSelectedImage)
	{
		x = Bx;
		y = By;
		xSize = BxSize;
		ySize = BySize;
		Selected = SelectedImage;
		Unselected = UnSelectedImage;
	}
	public TextBox(int Bx, int By, int BxSize, int BySize, int Indent, Sprite SelectedImage, Sprite UnSelectedImage)
	{
		x = Bx;
		y = By;
		xSize = BxSize;
		ySize = BySize;
		Selected = SelectedImage;
		Unselected = UnSelectedImage;
		indent = Indent;
	}
	
	public boolean contains(int xloc, int yloc)
	{
		if((xloc > x && xloc < x + xSize) && (yloc > y && xloc < y + ySize))
		{
			return true;
		}
		return false;
	}
	
	public void addletter(String letter)
	{
		text = text + "" + letter;
	}
	public void removeletter()
	{
		text = text.substring(text.length()-1);
	}
}
