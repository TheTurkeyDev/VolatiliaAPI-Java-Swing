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

	// private int offsetX = 0, offsetY = 0;

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
		renderInteractables();
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

	public void onHover(Interactable clicked)
	{

	}

	public void renderSubScreens()
	{
		for (SubScreen ss : subScreens)
		{
			ss.render();
			int[] image = ss.pixels;
			for (int x = 0; x < ss.getWidth(); x++)
			{
				for (int y = 0; y < ss.getHeight(); y++)
				{
					if (ss.getY() + y >= 0 && ss.getY() + y < height && ss.getX() + x >= 0 && ss.getX() + x < width)
					{
						if (image[x + y * ss.getWidth()] != 16777215) 
							pixels[width * (ss.getY() + y) + (ss.getX() + x)] = image[x + y * ss.getWidth()];
					}
				}
			}
		}
	}

	public void renderInteractables()
	{
		for (Interactable i : interactables)
		{
			int[] image = i.getCurrentPixelArray();
			for (int x = 0; x < i.getWidth(); x++)
			{
				for (int y = 0; y < i.getHeight(); y++)
				{
					if (i.getY() + y >= 0 && i.getY() + y < height && i.getX() + x >= 0 && i.getX() + x < width)
					{
						if (image[x + y * i.getWidth()] != 16777215)
							pixels[width * (i.getY() + y) + (i.getX() + x)] = image[x + y * i.getWidth()];
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
