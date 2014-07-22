package GameAPI.map;

import GameAPI.screen.ScreenManager;
import GameAPI.screen.screenObjects.Tile;
import GameAPI.util.Location;

public class Map
{
	private int[] tiles;
	
	private int width, height;
	
	public Map(int xs, int ys)
	{
		width = xs;
		height = ys;
		tiles = new int[width * height];
	}
	
	public int[] render(int xOffset, int yOffset, int w, int h)
	{
		int[] pixels = new int[w * h];
		for(int x = xOffset; x < w + xOffset; x++)
		{
			for(int y = yOffset; y < h + yOffset; y++)
			{
				int xx = (x - xOffset);
				int yy = (y - yOffset);
				if(xx > (width * Tile.SIZE) || yy > (height * Tile.SIZE))
				{
					pixels[w * yy  + xx] = ScreenManager.getInstance().getTileFromID(0).getPixelArray()[Tile.SIZE * (int)(yy / Tile.SIZE) + (int)(xx / Tile.SIZE)];
				}
				else
				{
					pixels[w * yy + xx] = ScreenManager.getInstance().getTileFromID(tiles[width * (int)(yy / Tile.SIZE) + (int)(xx / Tile.SIZE)]).getPixelArray()[Tile.SIZE * (int)(yy / Tile.SIZE) + (int)(xx / Tile.SIZE)];
				}
			}
		}
		return pixels;
	}
	
	public void setTileAt(Location loc, Tile tile)
	{
		tiles[width * loc.getY() + loc.getX()] = tile.getID();
	}
	
	public Tile getTileAt(Location loc)
	{
		return ScreenManager.getInstance().getTileFromID(tiles[width * loc.getY() + loc.getX()]);
	}
	
	public void generate()
	{
		
	}
}
