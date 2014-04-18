package GameAPI.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import GameAPI.screen.ScreenManager;
import GameAPI.screen.util.Interactable;


public class ScreenMouseMotionListener extends MouseMotionAdapter
{
	int x = 0, y = 0;
	public void mouseMoved(MouseEvent e) 
	{
		System.out.println("here");
		x = e.getX();
		y = e.getY();
		for(Interactable i: ScreenManager.getInstance().getCurrentScreen().getInteractables())
		{
			if(i.contains(x, y))
			{
				if(i.isHover())
					i.setSelected(true);
			}
			else
			{
				if(i.isHover())
					i.setSelected(false);
			}
		}
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
}
