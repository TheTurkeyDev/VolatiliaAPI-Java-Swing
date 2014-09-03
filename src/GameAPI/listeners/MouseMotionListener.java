package GameAPI.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import GameAPI.screen.ScreenManager;
import GameAPI.screen.screenObjects.Interactable;


public class MouseMotionListener extends MouseMotionAdapter
{
	public static Interactable currentHover;

	private static int x = 0, y = 0;
	public void mouseMoved(MouseEvent e)
	{
		x = e.getX();
		y = e.getY();
		
		if(ScreenManager.getInstance().getCurrentScreen() == null)
		{
			return;
		}
		for(Interactable i: ScreenManager.getInstance().getCurrentScreen().getInteractables())
		{
			if(i.contains(x, y))
			{
					currentHover = i;
					currentHover.onHover();
					ScreenManager.getInstance().getCurrentScreen().onHover(i);
			}
			else
			{
				try{
					currentHover.onUnHover();
				}catch(NullPointerException ex){}
			}
		}
	}

	public static int getX()
	{
		return x;
	}
	public static int getY()
	{
		return y;
	}
}
