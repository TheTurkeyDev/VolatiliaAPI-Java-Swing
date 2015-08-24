package VolatiliaAPI.map;

import VolatiliaAPI.main.APIMain;
import VolatiliaAPI.util.Location;

public class Map
{
	private int[] map;
	
	private boolean update = false;

	private int[] pix;

	private int width, height;

	private boolean isBlankTiles = false;

	public Map(int xs, int ys)
	{
		width = xs;
		height = ys;
		map = new int[(width/Tile.SIZE) * (height/Tile.SIZE)];
	}

	public int[] render(int xOffset, int yOffset, int w, int h)
	{
		if(isBlankTiles)
		{
			return null;
		}
		if(!APIMain.getAPI().renderMapOnce || pix == null || update)
		{
			pix = new int[w * h];
			MapManager mm = MapManager.instance;
			Tile tilevoid = mm.getTileFromID(0);
			Tile currentTile = tilevoid;
			int[] currentPixels = currentTile.getPixels();
			for(int x = xOffset; x < w + xOffset; x++)
			{
				for(int y = yOffset; y < h + yOffset; y++)
				{
					int xx = (x - xOffset);
					int yy = (y - yOffset);
					if(currentTile != mm.getTileFromID(map[(width/Tile.SIZE) * (int)(yy / Tile.SIZE) + (int)(xx / Tile.SIZE)]))
					{
						currentTile = mm.getTileFromID(map[(width/Tile.SIZE) * (int)(yy / Tile.SIZE) + (int)(xx / Tile.SIZE)]);
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
			update = false;
		}
		return pix.clone();
	}
	
	public void update()
	{
		
	}

	public void setTileAt(Location loc, Tile tile)
	{
		map[(width/Tile.SIZE) * loc.getY() + loc.getX()] = tile.getID();
		update = true;
	}

	public Tile getTileAt(Location loc)
	{
		return MapManager.instance.getTileFromID(map[(width/Tile.SIZE) * loc.getY() + loc.getX()]);
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
