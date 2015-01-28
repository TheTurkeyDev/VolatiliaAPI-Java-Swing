package VolatiliaAPI.screen.screenObjects;

import VolatiliaAPI.graphics.DefaultFont;
import VolatiliaAPI.graphics.Image;
import VolatiliaAPI.screen.ScreenManager;

public class TextBox extends InputInteractable
{
	private boolean isOneLine = true;
	private boolean isEnterAsReturn = true;

	private int maxchars = 0;

	public TextBox(int x, int y, int width, int height, Image image, String name)
	{
		super(x, y, width, height, image, image, name);
		maxchars = (image.getWidth() - indent)/DefaultFont.getDefaultFont().GetCurrentSize() - 1;
	}
	public TextBox(int x, int y, int width, int height, Image sImage, Image usImage, String name)
	{
		super(x, y, width, height, sImage, usImage, name);
		maxchars = (sImage.getWidth() - indent)/DefaultFont.getDefaultFont().GetCurrentSize() - 1;
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

	public Image getCurrentImage()
	{
		DefaultFont font = DefaultFont.getDefaultFont();
		Image[] charecters = font.getStringImage(currentInput);
		Image currentImage = (isSelected) ? selectedImage : unSelectedImage;
		int[] pixels = currentImage.getPixels();
		int IWidth = currentImage.getWidth();
		int IHeight = currentImage.getHeight();
		for(int i  = 0; i < charecters.length; i++)
		{
			Image image = charecters[i];
			int[] pix = image.getPixels();
			int w = image.getWidth();
			int h = image.getHeight();

			for(int yLoc = 0; yLoc < h; yLoc++)
			{
				for(int xLoc = 0; xLoc < w; xLoc++)
				{
					if (pix[w * yLoc + xLoc] != ScreenManager.getInstance().getOmmitColor())
						pixels[currentImage.getWidth() * ((yLoc + IHeight/2) - (image.getHeight()/2)) + (indent + (i*w + xLoc))] = pix[w * yLoc + xLoc];
				}
			}
		}
		return new Image(pixels, IWidth, IHeight);
	}

	public void addletter(String letter)
	{
		if(currentInput.length() < maxchars)
		{
			currentInput = currentInput + "" + letter;
		}
	}
	public void removeletter()
	{
		if(currentInput.length() > 0)
			currentInput = currentInput.substring(0, currentInput.length()-1);
	}
	public void setText(String text)
	{
		if(text.length() > maxchars)
		{
			text = text.substring(0, maxchars);
		}
		currentInput = text;
	}
}
