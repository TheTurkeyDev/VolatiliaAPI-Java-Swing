package GameAPI.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyListener extends KeyAdapter
{
	private static boolean[] keys = new boolean[65883];

	private static ArrayList<Key> keyevent = new ArrayList<Key>();

	public static int lastPressed = -1;

	public static boolean firstloop = true;

	public void keyReleased(KeyEvent e)
	{
		keys[e.getKeyCode()] = false;
		keyevent.add(new Key(e, false));
	}
	public void keyPressed(KeyEvent e)
	{
		if(!keys[e.getKeyCode()])
		{
			keys[e.getKeyCode()] = true;
			lastPressed = e.getKeyCode();
			keyevent.add(new Key(e, true));
		}
	}

	public static boolean isKeyPressed(int key)
	{
		return keys[key];
	}

	public static boolean hasnext()
	{
		if(keyevent.size() == 0 )
			return false;
		else
			return true;
	}
	
	public static void removelast()
	{
		keyevent.remove(0);
	}

	public static KeyEvent getCurrentEvent()
	{
		if(keyevent.size() == 0)
			return null;
		return keyevent.get(0).getKeyEvent();
	}

	public static boolean getCurrentState()
	{
		return keyevent.get(0).wasPressed();
	}
}