package GameAPI.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import GameAPI.screen.ScreenManager;


public class ScreenMouseMotionListener extends MouseMotionAdapter
{
	public void mouseMoved(MouseEvent e) 
	{
		int xloc = e.getX();
		int yloc = e.getY();
		ScreenManager.getInstance().getCurrentScreen().onMouseMove(xloc, yloc);
	}
}
