package GameAPI.screen;

import java.util.ArrayList;

import GameAPI.screen.screenObjects.Tile;


public class ScreenManager
{
	private Screen currentScreen;
	public static ScreenManager sm;

	private ArrayList<Screen> screens = new ArrayList<Screen>();
	private ArrayList<Tile> tiles = new ArrayList<Tile>();

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

	public void addTile(Tile tile)
	{
		tiles.add(tile);
	}
	public Tile getTileFromID(int id)
	{
		for(Tile t: tiles)
			if(t.getID() == id)
				return t;
		return null;
	}
	public Tile getTileFromColorCode(String code)
	{
		for(Tile t: tiles)
			if(t.getColorCode().equalsIgnoreCase(code))
				return t;
		return null;
	}
}
