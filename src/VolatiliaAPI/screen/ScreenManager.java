package VolatiliaAPI.screen;

import java.util.ArrayList;


public class ScreenManager
{
	private Screen currentScreen;
	private static ScreenManager sm;

	private ArrayList<Screen> screens = new ArrayList<Screen>();

	
	private int ommitColor = 0x000000;

	public ScreenManager()
	{
		sm = this;
	}

	public Screen getCurrentScreen()
	{
		return currentScreen;
	}

	public void setCurrentScreen(Screen newScreen)
	{
		if(currentScreen != null)
			currentScreen.unLoadScreen();
		currentScreen = newScreen;
		currentScreen.loadScreen();
	}
	public boolean setCurrentScreen(String newScreen)
	{
		for(Screen s: screens)
		{
			if(s.getName().equalsIgnoreCase(newScreen))
			{
				if(currentScreen != null)
					currentScreen.unLoadScreen();
				currentScreen = s;
				currentScreen.loadScreen();
				return true;
			}
		}
		return false;
	}

	public static ScreenManager getInstance()
	{
		return sm;
	}

	public void addScreen(Screen screen)
	{
		screens.add(screen);
	}

	public Screen getScreen(String name)
	{
		for(Screen s: screens)
		{
			if(s.getName().equalsIgnoreCase(name))
			{
				return s;
			}
		}
		return null;
	}
	
	public int getOmmitColor()
	{
		return ommitColor;
	}
	public void setOmmitColor(int color)
	{
		ommitColor = color;
	}
}
