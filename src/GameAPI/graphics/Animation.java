package GameAPI.graphics;

public class Animation
{
	Image[] images;
	int currentState = 0;
	
	boolean loops;
	boolean up = true;
	
	public Animation(Image[] imgs, boolean loop)
	{
		images = imgs;
		loops = loop;
	}
	
	public Image getCurrentImage()
	{
		return images[currentState];
	}
	
	public void nextImage()
	{
		if(loops)
			currentState++;
		else
			currentState--;
		
		if(currentState == images.length)
		{
			if(loops)
				currentState = 0;
			else
			{
				up = false;
				currentState--;
			}
		}
	}
	
	public void reset()
	{
		currentState = 0;
	}
	
	public void setState(int state)
	{
		currentState = state;
	}
	
	public int getState()
	{
		return currentState;
	}

}
