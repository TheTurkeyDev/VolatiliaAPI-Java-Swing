package VolatiliaAPI.map;

import java.util.ArrayList;

public class MapManager
{
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	public static MapManager instance;
	
	public MapManager()
	{
		instance = this;
	}
	
	public void addTile(Tile tile)
	{
		tiles.add(tile);
	}
	
	public Tile getTileFromID(int id)
	{
		for(Tile t: tiles)
			if(t.getID() == id)
				return t;
		return null;
	}
	
	public Tile getTileFromColorCode(String code)
	{
		for(Tile t: tiles)
			if(t.getColorCode().equalsIgnoreCase(code))
				return t;
		return null;
	}
}