package VolatiliaAPI.screen.screenObjects;

import VolatiliaAPI.graphics.Image;

public class TextBox extends InputInteractable
{
	private boolean isOneLine = false;
	private boolean isEnterAsReturn = true;
	
	public TextBox(int x, int y, int width, int height, Image image, String name)
	{
		super(x, y, width, height, image, image, name);
	}
	public TextBox(int x, int y, int width, int height, Image sImage, Image usImage, String name)
	{
		super(x, y, width, height, sImage, usImage, name);
	}
	
	public void setEnterAsReturn(boolean toggle)
	{
		isEnterAsReturn = toggle;
	}
	public boolean isEnterAsReturn()
	{
		return isEnterAsReturn;
	}
	
	public void setOneLine(boolean toggle)
	{
		isOneLine = toggle;
	}
	public boolean isOneLine()
	{
		return isOneLine;
	}
}
