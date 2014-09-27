package VolatiliaAPI.listeners;

import java.awt.event.KeyEvent;

public class Key
{
	private boolean pressed;
	
	private KeyEvent event;
	
	public Key(KeyEvent e, boolean p)
	{
		event = e;
		pressed = p;
	}
	
	public boolean wasPressed()
	{
		return pressed;
	}
	
	public KeyEvent getKeyEvent()
	{
		return event;
	}
}
