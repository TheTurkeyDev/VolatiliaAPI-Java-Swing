package VolatiliaAPI.screen.screenObjects;

import VolatiliaAPI.graphics.DefaultFont;
import VolatiliaAPI.graphics.Image;

public class InputInteractable extends Interactable
{

	protected String currentInput = "";
	protected int indent = 0;

	protected boolean canEdit = true;

	public InputInteractable(int x, int y, int width, int height, Image selectedImage, Image unselectedImage, String name)
	{
		super(x, y, width, height, selectedImage, unselectedImage, name);
	}

	public String getcurrentInput()
	{
		return currentInput;
	}

	public void addletter(String letter)
	{
		currentInput = currentInput + "" + letter;
	}
	public void removeletter()
	{
		if(currentInput.length() > 0)
			currentInput = currentInput.substring(0, currentInput.length()-1);
	}
	public void setText(String text)
	{
		currentInput = text;
	}

	public void setIndent(int i)
	{
		indent = i;
	}
	public int getIndent()
	{
		return indent;
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
					if (pix[w * yLoc + xLoc] != -65316)
						pixels[currentImage.getWidth() * ((yLoc + IHeight/2) - (image.getHeight()/2)) + (indent + (i*w + xLoc))] = pix[w * yLoc + xLoc];
				}
			}
		}
		return new Image(pixels, IWidth, IHeight);
	}

	public int[] getCurrentPixelArray()
	{
		return getCurrentImage().getPixels();
	}
}
