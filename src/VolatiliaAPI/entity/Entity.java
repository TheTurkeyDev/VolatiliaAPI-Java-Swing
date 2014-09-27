package VolatiliaAPI.entity;

import VolatiliaAPI.game.Game;
import VolatiliaAPI.graphics.Image;
import VolatiliaAPI.util.Location;
import VolatiliaAPI.util.Location.Direction;

public abstract class Entity
{
	
	protected int x, y;
	protected int width;
	protected int height;
	protected boolean isAlive = true;
	protected Image image;
	protected Direction facing = Direction.North;
	protected boolean isMoving = false;
	protected boolean canMove = true;
	protected Game game;
	
	public Entity(Image i, int s, Game g)
	{
		image = i;
		width = s;
		height = s;
		game = g;
	}
	public Entity(Image i, int w, int h, Game g)
	{
		image = i;
		width = w;
		height = h;
		game = g;
	}
	
	public void update()
	{
		
	}
	
	public void render()
	{
		
	}
	
	public void kill()
	{
		isAlive = false;
	}
	
	public boolean isAlive()
	{
		return isAlive;
	}
	
	public void setLocation(Location loc)
	{
		x = loc.getX();
		y = loc.getY();
	}
	
	public Location getLocation()
	{
		return new Location(x,y);
	}
	
	public int[] getPixels()
	{
		return image.getPixels().clone();
	}
	
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
	
	public void stop()
	{
		canMove = false;
	}
	
	public void start()
	{
		canMove = true;
	}

}
