package VolatiliaAPI.map;

import VolatiliaAPI.main.APIMain;
import VolatiliaAPI.screen.ScreenManager;
import VolatiliaAPI.screen.screenObjects.Tile;
import VolatiliaAPI.util.Location;

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
		tiles = new int[(width/Tile.SIZE) * (height/Tile.SIZE)];
	}

	public int[] render(int xOffset, int yOffset, int w, int h)
	{
		if(isBlankTiles)
		{
			return null;
		}
		if(!APIMain.getAPI().renderMapOnce || pix == null)
		{
			pix = new int[w * h];
			ScreenManager sm = ScreenManager.getInstance();
			Tile tilevoid = sm.getTileFromID(0);
			Tile currentTile = tilevoid;
			int[] currentPixels = currentTile.getPixels();
			for(int x = xOffset; x < w + xOffset; x++)
			{
				for(int y = yOffset; y < h + yOffset; y++)
				{
					int xx = (x - xOffset);
					int yy = (y - yOffset);
					if(currentTile != sm.getTileFromID(tiles[(width/Tile.SIZE) * (int)(yy / Tile.SIZE) + (int)(xx / Tile.SIZE)]))
					{
						currentTile = sm.getTileFromID(tiles[(width/Tile.SIZE) * (int)(yy / Tile.SIZE) + (int)(xx / Tile.SIZE)]);
						currentPixels = currentTile.getPixels();
					}
					if(xx > width || yy > height)
					{
						pix[w * yy  + xx] = tilevoid.getPixelAt(Tile.SIZE, (int)(yy / Tile.SIZE), (int)(xx / Tile.SIZE));
					}
					else
					{
						pix[w * yy + xx] = currentPixels[Tile.SIZE * (yy % Tile.SIZE) + (int)(xx % Tile.SIZE)];
					}
				}
			}
		}
		return pix.clone();
	}
	
	public void update()
	{
		
	}

	public void setTileAt(Location loc, Tile tile)
	{
		tiles[(width/Tile.SIZE) * loc.getY() + loc.getX()] = tile.getID();
	}

	public Tile getTileAt(Location loc)
	{
		return ScreenManager.getInstance().getTileFromID(tiles[(width/Tile.SIZE) * loc.getY() + loc.getX()]);
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
