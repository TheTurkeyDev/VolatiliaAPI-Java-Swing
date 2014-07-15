package GameAPI.screen;

import java.util.ArrayList;

import GameAPI.main.GameAPI;
import GameAPI.screen.screenObjects.Interactable;
import GameAPI.screen.screenObjects.Tile;
import GameAPI.screen.subscreen.SubScreen;

public class Screen
{

	private String name;
	public int height, width;

	public int[] pixels;

	private ArrayList<SubScreen> subScreens = new ArrayList<SubScreen>();
	private ArrayList<Interactable> interactables = new ArrayList<Interactable>();
	private ArrayList<Tile> tiles = new ArrayList<Tile>();

	private int xOffset = 0, yOffset = 0;

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
		renderInteractables(xOffset, yOffset);
		renderTiles(xOffset, yOffset);
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

	public void renderTiles(int xOffset, int yOffset)
	{
		for (Tile t : tiles)
		{
			if ((t.getY() + t.getHeight()) >= yOffset || (t.getY() + t.getHeight()) < (height + yOffset) || (t.getX() + t.getWidth()) >= xOffset || (t.getX() + t.getWidth()) < (width + xOffset))
			{
				int[] image = t.getPixelArray();
				for (int y = 0; y < t.getHeight(); y++)
				{
					int ya = y + t.getY();
					for (int x = 0; x < t.getWidth(); x++)
					{
						int xa = x + t.getX();
						if(xa < xOffset || xa > width + xOffset || ya < yOffset || ya >= height + yOffset)break;
						if (image[x + y * t.getWidth()] != 16777215)
							pixels[width * (ya - yOffset) + (xa - xOffset)] = image[x + y * t.getWidth()];
					}
				}
			}
		}
	}

	public void renderInteractables(int offsetX, int offsetY)
	{
		for (Interactable i : interactables)
		{
			int ix = i.getX() - offsetX;
			int iy = i.getY() - offsetY;
			int[] image = i.getCurrentPixelArray();
			for (int y = 0; y < i.getHeight(); y++)
			{
				int ya = y + iy;
				for (int x = 0; x < i.getWidth(); x++)
				{
					int xa = x + ix;
					if(xa < offsetX || xa > width + offsetX || ya < offsetY || ya >= height + offsetY)break;					
					if (image[x + y * i.getWidth()] != 16777215)
						pixels[width * (ya - offsetY) + (xa - offsetX)] = image[x + y * i.getWidth()];
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

	public void setOffset(int xoff, int yoff)
	{
		xOffset = xoff;
		yOffset = yoff;
	}
}
