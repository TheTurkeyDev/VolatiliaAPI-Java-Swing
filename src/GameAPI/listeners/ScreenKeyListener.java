package GameAPI.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import GameAPI.screen.ScreenManager;


public class ScreenKeyListener implements KeyListener
{
	String key;
	public void keyReleased(KeyEvent e)
	{
		char keychar = e.getKeyChar();
		String typedletter = Character.toString(keychar);
		if((int)e.getKeyChar() == KeyEvent.VK_BACK_SPACE)
	    {
			typedletter = "delete";
	    }
		else if((int)e.getKeyChar() == KeyEvent.VK_ENTER)
	    {
			typedletter = "Enter";
	    }
		else if((int)e.getKeyChar() == KeyEvent.VK_1)
	    {
			GameAPI.main.GameAPI.displayInfo = !GameAPI.main.GameAPI.displayInfo;
	    }
		ScreenManager.getInstance().getCurrentScreen().onPress(typedletter);
	}
	public void keyPressed(KeyEvent e)
	{ 
		char keychar = e.getKeyChar();
		String typedletter = Character.toString(keychar);
		if((int)e.getKeyChar() == KeyEvent.VK_BACK_SPACE)
	    {  
			typedletter = "delete";
	    }
		else if((int)e.getKeyChar() == KeyEvent.VK_ENTER)
	    {  
			typedletter = "Enter";
	    }
		else if((int)e.getKeyChar() == KeyEvent.VK_1)
	    {
			GameAPI.main.GameAPI.displayInfo = !GameAPI.main.GameAPI.displayInfo;
	    }
		ScreenManager.getInstance().getCurrentScreen().onDePress(typedletter);
	}
	
	public void keyTyped(KeyEvent e)
	{
		char keychar = e.getKeyChar();
		String typedletter = Character.toString(keychar);
		if((int)e.getKeyChar() == KeyEvent.VK_BACK_SPACE)
	    {  
			typedletter = "delete";
	    }
		else if((int)e.getKeyChar() == KeyEvent.VK_ENTER)
	    {  
			typedletter = "Enter";
	    }
		else if((int)e.getKeyChar() == KeyEvent.VK_1)
	    {
			GameAPI.main.GameAPI.displayInfo = !GameAPI.main.GameAPI.displayInfo;
	    }
		ScreenManager.getInstance().getCurrentScreen().onType(typedletter);
	}
}