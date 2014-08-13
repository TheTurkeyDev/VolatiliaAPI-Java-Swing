package GameAPI.game;

import java.util.ArrayList;

import GameAPI.entity.Entity;
import GameAPI.map.Map;
import GameAPI.screen.screenObjects.Tile;
import GameAPI.util.Location;

public class Game
{
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	
	private Map map;
	
	private int width, height;
	
	private int[] pixels;
	
	private int xOffset = 0, yOffset = 0;
	
	public Game(Map m, int w, int h)
	{
		map = m;
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
		if(map == null)
			return;
		pixels = map.render(xOffset, yOffset, width, height);
	}
	
	private void renderEntities()
	{
		for(Entity ent: entities)
		{
			ent.render();
			int[] pix = ent.getPixels();
			for(int x = 0; x < ent.getSize(); x++)
			{
				for(int y = 0; y < ent.getSize(); y++)
				{
					int yy = ((y + ent.getLocation().getY()) - yOffset);
					int xx = ((x + ent.getLocation().getX()) - xOffset);
					if(pix[ent.getSize() * y + x] != -65316 && yy < height && xx < width)
					pixels[width * yy  + xx] = pix[ent.getSize() * y + x];
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
		return pixels;
	}
}
