package GameAPI.entity;

import GameAPI.game.Game;
import GameAPI.graphics.Image;
import GameAPI.util.Location;
import GameAPI.util.Location.Direction;

public abstract class Entity
{
	
	protected int x, y;
	protected int size;
	protected boolean isAlive = true;
	protected Image image;
	protected Direction facing = Direction.North;
	protected boolean isMoving = false;
	protected boolean canMove = true;
	protected Game game;
	
	public Entity(Image i, int s, Game g)
	{
		image = i;
		size = s;
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
		return image.getPixels();
	}
	
	public int getSize()
	{
		return size;
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
