package GameAPI.screen;

import GameAPI.util.Maze;

public class TestScreen extends Screen
{
	
	private Maze maze;

	public TestScreen(String n)
	{
		super(n);
		maze = new Maze();
		maze.generate(false, 40, 30, 20, 20);
	}
	
	public void render()
	{
		pixels = maze.getPixels();
	}
	
	public void update()
	{
		
	}

}
