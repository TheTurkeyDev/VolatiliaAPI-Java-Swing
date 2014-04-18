package GameAPI.screen;

import java.util.ArrayList;

import GameAPI.screen.subscreen.SubScreen;
import GameAPI.screen.util.Interactable;

public class Screen
{
	
	private String name;
	public int height, width;

	public int[] pixels;

	private ArrayList<Interactable> addons = new ArrayList<Interactable>();
	private ArrayList<SubScreen> subScreens = new ArrayList<SubScreen>();

	//private int offsetX = 0, offsetY = 0;


	public Screen(String n)
	{
		name = n;
		height = GameAPI.main.GameAPI.height;
		width = GameAPI.main.GameAPI.width;
		pixels = new int[width * height];
	}

	public void render()
	{
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
	
	public void renderSubScreens()
	{
		
		for(SubScreen ss: subScreens)
		{
			ss.render();
			int [] image = ss.pixels;
			for(int xx=0;xx<ss.getWidth();xx++)
			{
				for(int yy=0;yy<ss.getHeight();yy++)
				{
					if(ss.getX()+yy>=0 && ss.getY()+yy<height && ss.getX()+xx>=0 && ss.getX()+xx<width)
					{
						if(image[xx + yy* ss.getWidth()]!=16777215)
						pixels[(ss.getX()+xx)+(ss.getY()+yy)*width]= image[xx + yy* ss.getWidth()];
					}
				}
			}
		}
	}
	
	public String getName()
	{
		return name;
	}
}
