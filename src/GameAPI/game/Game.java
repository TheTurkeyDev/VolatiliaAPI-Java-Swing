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
	
	public void render()
	{
		renderMap();
		renderEntities();
	}
	
	public void update()
	{
		for(Entity ent: entities)
		{
			ent.update();
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
			for(int x = 0; x < ent.getSize(); x++)
			{
				for(int y = 0; y < ent.getSize(); y++)
				{
					if(ent.getPixels()[ent.getSize() * y + x] != -65316)
					pixels[width * ((y + ent.getLocation().getY()) - yOffset) + ((x + ent.getLocation().getX()) - xOffset)] = ent.getPixels()[ent.getSize() * y + x];
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
	
	public boolean canMoveTo(Location loc)
	{
		return map.getTileAt(new Location(loc.getX() / Tile.SIZE, loc.getY() / Tile.SIZE)).solid();
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
