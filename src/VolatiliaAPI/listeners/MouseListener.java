package VolatiliaAPI.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import VolatiliaAPI.screen.ScreenManager;
import VolatiliaAPI.screen.screenObjects.Interactable;
import VolatiliaAPI.screen.subscreen.SubScreen;
import VolatiliaAPI.util.Location;


public class MouseListener extends MouseAdapter
{
	int x = 0, y = 0;
	public void mouseClicked(MouseEvent e)
	{
		x = e.getX();
		y = e.getY();
		for(Interactable i: ScreenManager.getInstance().getCurrentScreen().getInteractables())
		{
			if(i.contains(x, y))
			{
				i.onClick();
				ScreenManager.getInstance().getCurrentScreen().onClicked(i);
			}
		}
		
		for(SubScreen ss: ScreenManager.getInstance().getCurrentScreen().getVisibleSubScreens())
		{
			for(Interactable i: ss.getIneteractables())
			{
				if(i.contains(x - ss.getX(), y - ss.getY()))
				{
					i.onClick();
					ss.onClicked(i);
				}
			}
		}
	}
	
	public Location getLastClick()
	{
		return new Location(x ,y);
	}
}
