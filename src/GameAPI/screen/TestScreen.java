package GameAPI.screen;

import GameAPI.graphics.Image;
import GameAPI.graphics.ImageSheet;
import GameAPI.screen.screenObjects.Button;
import GameAPI.util.Maze;

public class TestScreen extends Screen
{

	private Maze maze;

	public TestScreen(String n)
	{
		super(n);
		maze = new Maze();
		maze.generate(false, 40, 30, 20, 20);
		ImageSheet test = new ImageSheet(TestScreen.class, "/Images/testSheet.png", 800, 600);
		Image selected = new Image(test,0,0,250,75);
		Image unselected = new Image(test,250,0,250,75);
		Button button = new Button(100, 200, 250, 75, selected, unselected, "test Button");
		addInteractable(button);
		setOffset(0, 0);
	}

	public void render()
	{
		super.render();
	}

	public void update()
	{

	}

}
