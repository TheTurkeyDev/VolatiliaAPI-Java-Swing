package GameAPI.screen.util;

import GameAPI.Images.Image;

public class Button extends Interactable
{
	
	private boolean isHover = true;
	private boolean isClick = false;
	private boolean isClicked = false;
	
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
	
	public void onClick()
	{
		if(isClick && !isHover)
			isSelected = !isSelected;
		else if(isClick)
			isClicked = !isClicked;
	}
	public void onHover()
	{
		if(isHover)
			isSelected = true;
	}
	public void onUnHover()
	{
		if(isHover && !isClicked)
			isSelected = false;
	}
	
	public void setHover(boolean b)
	{
		isHover = b;
	}
	public void setClick(boolean b)
	{
		isClick = b;
	}
	public boolean isHover()
	{
		return isHover;
	}
	public boolean isClick()
	{
		return isClick;
	}
}
