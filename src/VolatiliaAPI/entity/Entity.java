package VolatiliaAPI.entity;

import VolatiliaAPI.game.GameBase;
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
	protected GameBase game;
	
	public Entity(int s, GameBase g)
	{
		width = s;
		height = s;
		game = g;
	}
	public Entity(int w, int h, GameBase g)
	{
		width = w;
		height = h;
		game = g;
	}
	
	public void setImage(Image image)
	{
		this.image = image;
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
	
	public int getImageWidth()
	{
		return image.getWidth();
	}
	public int getImageHeight()
	{
		return image.getHeight();
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
