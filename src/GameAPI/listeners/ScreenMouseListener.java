package GameAPI.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import GameAPI.screen.ScreenManager;
import GameAPI.screen.util.Interactable;


public class ScreenMouseListener extends MouseAdapter
{
	public void mouseClicked(MouseEvent e)
	{
		int xloc = e.getX();
		int yloc = e.getY();
		for(Interactable i: ScreenManager.getInstance().getCurrentScreen().getInteractables())
		{
			if(i.contains(xloc, yloc))
			{
				ScreenManager.getInstance().getCurrentScreen().onClicked(i);
			}
		}
	}
}
