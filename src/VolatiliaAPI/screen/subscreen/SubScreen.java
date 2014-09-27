package VolatiliaAPI.screen.subscreen;

import java.util.ArrayList;

import VolatiliaAPI.graphics.Background;
import VolatiliaAPI.screen.Screen;
import VolatiliaAPI.screen.screenObjects.Interactable;

public class SubScreen
{

	protected int x, y, width, height;
	protected String name;
	protected Screen parent;
	protected boolean isVisible = false;
	
	protected Background bg;
	
	private ArrayList<Interactable> addons = new ArrayList<Interactable>();
	
	public int[] pixels;
	
	public SubScreen(int xloc, int yloc, String n, Screen p, Background bg)
	{
		x = xloc;
		y = yloc;
		width = bg.getWidth();
		height = bg.getHeight();
		name = n;
		parent = p;
		pixels = bg.getPixles();
	}

	public void render()
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
						if(image[xx + yy* i.getWidth()]!= -65316)
						pixels[(i.getX()+xx)+(i.getY()+yy)*width]= image[xx + yy* i.getWidth()];
					}
				}
			}
		}
	}

	public void update()
	{
	}

	public String getName()
	{
		return name;
	}


	public void onClicked(Interactable i)
	{

	}

	public void onMouseMove(int x, int y)
	{

	}
	
	public void setVisible(boolean v)
	{
		isVisible = v;
	}
	public boolean isVisible()
	{
		return isVisible;
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
	
	public void addIneteractable(Interactable i)
	{
		addons.add(i);
	}
	
	public ArrayList<Interactable> getIneteractables()
	{
		return addons;
	}
}