package GameAPI.screen;


public class ScreenManager
{
	private Screen currentScreen;
	public static ScreenManager sm;
	
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
		currentScreen = newScreen;
	}
	
	public static ScreenManager getInstance()
	{
		return sm;
	}
}
