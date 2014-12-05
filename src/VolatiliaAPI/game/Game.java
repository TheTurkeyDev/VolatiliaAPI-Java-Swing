package VolatiliaAPI.game;

import java.util.ArrayList;

import VolatiliaAPI.entity.Entity;
import VolatiliaAPI.map.Map;
import VolatiliaAPI.screen.ScreenManager;
import VolatiliaAPI.screen.screenObjects.Tile;
import VolatiliaAPI.util.Location;

public class Game
{
	private ArrayList<Entity> entities = new ArrayList<Entity>();

	private Map map = null;

	private int width, height;

	protected int[] pixels;

	private int xOffset = 0, yOffset = 0;

	public Game(int w, int h)
	{
		width = w;
		height = h;
		pixels = new int[width * height];
	}

	public void clearGame()
	{
		entities.clear();
	}

	public void render()
	{
		renderMap();
		renderEntities();
	}

	public void update()
	{
		for(int i = 0; i < entities.size(); i++)
		{
			Entity ent = entities.get(i);
			if(ent==null)
				continue;
			ent.update();
			if(!ent.isAlive())
			{
				entities.remove(i);
				i--;
			}
		}
	}

	private void renderMap()
	{
		if(map != null)
			pixels = map.render(xOffset, yOffset, width, height);
	}

	private void renderEntities()
	{
		for(Entity ent: entities)
		{
			if(ent==null)
				continue;
			ent.render();
			int[] pix = ent.getPixels();
			for(int x = 0; x < ent.getWidth(); x++)
			{
				for(int y = 0; y < ent.getHeight(); y++)
				{
					int yy = ((y + ent.getLocation().getY()) - yOffset);
					int xx = ((x + ent.getLocation().getX()) - xOffset);
					if(pix[ent.getWidth() * y + x] != ScreenManager.getInstance().getOmmitColor() && yy < height && xx < width)
					{
						pixels[width * yy  + xx] = pix[ent.getWidth() * y + x];
					}
				}
			}
		}
	}

	public ArrayList<Entity> getEntities()
	{
		return entities;
	}

	public void addEntity(Entity ent)
	{
		entities.add(ent);
	}

	public boolean canMoveTo(Location loc, int size)
	{
		if(map.getTileAt(new Location(loc.getX() / Tile.SIZE, loc.getY() / Tile.SIZE)).solid())
		{
			return false;
		}
		else if(map.getTileAt(new Location((loc.getX() + size) / Tile.SIZE, loc.getY() / Tile.SIZE)).solid())
		{
			return false;
		}
		else if(map.getTileAt(new Location(loc.getX() / Tile.SIZE, (loc.getY() + size) / Tile.SIZE)).solid())
		{
			return false;
		}
		else if(map.getTileAt(new Location((loc.getX() + size) / Tile.SIZE, (loc.getY() + size) / Tile.SIZE)).solid())
		{
			return false;
		}
		return true;
	}

	public void setOffset(int xoff, int yoff)
	{
		xOffset = xoff;
		yOffset = yoff;
	}

	public Map getCurrentMap()
	{
		return map;
	}
	public void setCurrentMap(Map nextmap)
	{
		map = nextmap;
		map.generate();
	}

	public int[] getPixels()
	{
		return pixels.clone();
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}
}
