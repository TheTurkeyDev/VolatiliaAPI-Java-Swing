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
				if(x > (width * Tile.SIZE) || y > (height * Tile.SIZE) || x < 0 || y < 0)
				{
					pixels[w * yy  + xx] = ScreenManager.getInstance().getTileFromID(0).getPixelArray()[Tile.SIZE * (yy / Tile.SIZE) +(xx / Tile.SIZE)];
				}
				else
				{
					pixels[w * yy + xx] = ScreenManager.getInstance().getTileFromID(tiles[width * (yy / Tile.SIZE) + (xx / Tile.SIZE)]).getPixelArray()[Tile.SIZE * (yy / Tile.SIZE) +(xx / Tile.SIZE)];
				}
			}
		}
		return pixels;
	}
	
	public void setTileAt(Location loc, Tile tile)
	{
		tiles[width * loc.getY() + loc.getX()] = tile.getID();
	}
	
	public void generate()
	{
		
	}
}
