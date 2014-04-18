package GameAPI.screen;

import java.util.ArrayList;

import GameAPI.screen.util.Interactable;

public class Screen
{

	public int height, width;

	public int[] pixels;

	private ArrayList<Interactable> addons = new ArrayList<Interactable>();

	//private int offsetX = 0, offsetY = 0;


	public Screen()
	{
		height = GameAPI.main.GameAPI.height;
		width = GameAPI.main.GameAPI.width;
		pixels = new int[width * height];
	}

	public void onMouseMove(int x, int y)
	{

	}

	public void render()
	{
		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++)
				pixels[width * y + x] = 0xF703CF;
		renderAddonsTile();
	}

	public void clear()
	{
		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++)
				pixels[width * y + x] = 0xfffff;
	}

	public void onClicked(Interactable clicked)
	{

	}

	public void onType(String Letter)
	{

	}

	public void onPress(String Letter)
	{

	}

	public void onDePress(String Letter)
	{

	}

	public void addInteractable(Interactable i)
	{
		addons.add(i);
	}

	public ArrayList<Interactable> getInteractables()
	{
		return addons;
	}

	public void renderAddonsTile()
	{

		for(Interactable i: addons)
		{
			int [] image = i.getCurrentPixelArray();
			for(int xx=0;xx<i.getWidth();xx++)
			{
				for(int yy=0;yy<i.getHeight();yy++)
				{
					if(i.getX()+yy>=0 && i.getY()+yy<height && i.getX()+xx>=0 && i.getX()+xx<width)
					{
						if(image[xx + yy* i.getWidth()]!=16777215)
						pixels[(i.getX()+xx)+(i.getY()+yy)*width]= image[xx + yy* i.getWidth()];
					}
				}
			}
		}
	}
}
