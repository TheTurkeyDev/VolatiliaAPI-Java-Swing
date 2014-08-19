package GameAPI.map;

import GameAPI.main.GameAPI;
import GameAPI.screen.ScreenManager;
import GameAPI.screen.screenObjects.Tile;
import GameAPI.util.Location;

public class Map
{
	private int[] tiles;

	private int[] pix;

	private int width, height;

	private boolean isBlankTiles = false;

	public Map(int xs, int ys)
	{
		width = xs;
		height = ys;
		tiles = new int[width * height];
	}

	public int[] render(int xOffset, int yOffset, int w, int h)
	{
		if(isBlankTiles)
		{
			return null;
		}
		if(!GameAPI.getAPI().renderMapOnce || pix == null)
		{
			pix = new int[w * h];
			ScreenManager sm = ScreenManager.getInstance();
			Tile tilevoid = sm.getTileFromID(0);
			for(int x = xOffset; x < w + xOffset; x++)
			{
				for(int y = yOffset; y < h + yOffset; y++)
				{
					int xx = (x - xOffset);
					int yy = (y - yOffset);
					if(xx > (width * Tile.SIZE) || yy > (height * Tile.SIZE))
					{
						pix[w * yy  + xx] = tilevoid.getPixelAt(Tile.SIZE, (int)(yy / Tile.SIZE), (int)(xx / Tile.SIZE));
					}
					else
					{
						pix[w * yy + xx] = sm.getTileFromID(tiles[width * (int)(yy / Tile.SIZE) + (int)(xx / Tile.SIZE)]).getPixelAt(Tile.SIZE, (int)(yy / Tile.SIZE), (int)(xx / Tile.SIZE));
					}
				}
			}
		}
		return pix.clone();
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

	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}

	public void setBlankTiles()
	{
		isBlankTiles = true;
	}
}
