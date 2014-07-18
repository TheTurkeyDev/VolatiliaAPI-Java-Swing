package GameAPI.screen.screenObjects;


import GameAPI.graphics.Image;

public class Interactable extends ScreenObject
{

	public Interactable(int Bx, int By, int BxSize, int BySize, Image SelectedImage, Image UnSelectedImage, String n)
	{
		super(Bx,By,BxSize,BySize,SelectedImage, UnSelectedImage,n);
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
		
	}
	public void onHover()
	{
		
	}
	public void onUnHover()
	{
		
	}

	public void setSelected(boolean toggle)
	{
		isSelected = toggle;
	}
	public boolean isSelected()
	{
		return isSelected;
	}

	public Image getCurrentImage()
	{
		return (isSelected) ? image : image2;
	}

	public int getHeight()
	{
		return ySize;
	}
	public int getWidth()
	{
		return xSize;
	}

	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}

	public int[] getCurrentPixelArray()
	{
		if(isSelected)
			return image.getPixels();
		else
			return image2.getPixels();
	}
	
	public void show()
	{
		isVisible = true;
	}
	public void hide()
	{
		isVisible = false;
	}
	public boolean isVisible()
	{
		return isVisible;
	}
	
	public String getName()
	{
		return name;
	}
}
