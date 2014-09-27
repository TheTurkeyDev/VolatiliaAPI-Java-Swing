package VolatiliaAPI.map;

import VolatiliaAPI.graphics.Image;
import VolatiliaAPI.screen.ScreenManager;
import VolatiliaAPI.screen.screenObjects.Tile;
import VolatiliaAPI.util.Location;

public class MapLoader
{
	private Image mapImage;
	
	public MapLoader(Image map)
	{
		mapImage = map;
	}
	
	public Map loadMap()
	{
		int w = mapImage.getWidth();
		int h = mapImage.getHeight();
		
		Map map = new Map(w*Tile.SIZE, h*Tile.SIZE);
		ScreenManager sm = ScreenManager.getInstance();
		
		int[] pix = mapImage.getPixels();
		
		for(int x = 0; x < w; x++)
			for(int y = 0; y < h; y++)
			{
				map.setTileAt(new Location(x,y), sm.getTileFromColorCode(Integer.toHexString(pix[w * y + x]).substring(2)));
			}
		return map;
	}
	
	public Image getMapImage()
	{
		return mapImage;
	}
}
