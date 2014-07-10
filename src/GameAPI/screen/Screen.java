package GameAPI.screen;

import java.util.ArrayList;

import GameAPI.main.GameAPI;
import GameAPI.screen.subscreen.SubScreen;
import GameAPI.screen.util.Interactable;


public class Screen
{

	private String name;
	public int height, width;

	public int[] pixels;

	private ArrayList<SubScreen> subScreens = new ArrayList<SubScreen>();
	private ArrayList<Interactable> interactables = new ArrayList<Interactable>();

	//private int offsetX = 0, offsetY = 0;


	public Screen(String n)
	{
		name = n;
		height = GameAPI.height;
		width = GameAPI.width;
		pixels = new int[width * height];
	}

	public void update()
	{

	}
	public void render()
	{
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
					if(ss.getY()+yy>=0 && ss.getY()+yy<height && ss.getX()+xx>=0 && ss.getX()+xx<width)
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

	public void addSubScreen(SubScreen ss)
	{
		subScreens.add(ss);
	}
	public ArrayList<SubScreen> getSubScreens()
	{
		return subScreens;
	}
	public void addInteractable(Interactable i)
	{
		interactables.add(i);
	}
	public ArrayList<Interactable> getInteractables()
	{
		return interactables;
	}
}
