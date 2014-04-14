package GameAPI.screen;

import java.util.ArrayList;

import GameAPI.screen.util.Interactable;
import GameAPI.tile.Tile;
import GameAPI.util.Maze;

public class Screen
{

	public int height, width;

	public int[] pixels;

	private ArrayList<Interactable> addons = new ArrayList<Interactable>();
	
	Maze maze;

	public Screen(int w, int h)
	{
		height = h;
		width = w;
		pixels = new int[width * height];
		maze = new Maze();
		maze.generate(true, 20, 15, 800, 600);
	}

	public void onMouseMove(int x, int y)
	{

	}

	public void render()
	{
		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++)
				pixels[width * y + x] = maze.getPixels()[width * y + x];
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

	public void renderTile(int xp, int yp, Tile tile)
	{
		for (int y = 0; y < tile.sprite.getSize(); y++)
		{
			int ya = yp + y;
			for (int x = 0; x < tile.sprite.getSize(); x++)
			{
				int xa = xp + x;
				if (xa < 0 || xa >= width || ya < 0 || ya >= width) break;
				pixels[width * ya + xa] = tile.sprite.pixels[x][y];
			}
		}
	}
}
