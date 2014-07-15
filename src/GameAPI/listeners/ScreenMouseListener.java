package GameAPI.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import GameAPI.screen.ScreenManager;
import GameAPI.screen.screenObjects.Interactable;
import GameAPI.util.Location;


public class ScreenMouseListener extends MouseAdapter
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
	}
	
	public Location getLastClick()
	{
		return new Location(x ,y);
	}
}
