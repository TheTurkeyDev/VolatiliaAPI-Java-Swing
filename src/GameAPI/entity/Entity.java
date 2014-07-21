package GameAPI.entity;

import GameAPI.graphics.Image;
import GameAPI.util.Location.Direction;

public abstract class Entity
{
	
	protected int x, y;
	protected boolean isAlive = true;
	protected Image image;
	protected Direction facing = Direction.North;
	protected boolean isMoving = false;
	
	public Entity(Image i, int h)
	{
		image = i;
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

}
