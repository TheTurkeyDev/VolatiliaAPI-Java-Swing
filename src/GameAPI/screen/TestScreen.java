package GameAPI.screen;

import java.io.IOException;

import javax.imageio.ImageIO;

import GameAPI.Images.Image;
import GameAPI.screen.util.Button;
import GameAPI.util.Maze;

public class TestScreen extends Screen
{

	private Maze maze;

	public TestScreen(String n)
	{
		super(n);
		maze = new Maze();
		maze.generate(false, 40, 30, 20, 20);
		Image selected = null, unselected = null;
		try
		{
			selected = new Image(ImageIO.read(TestScreen.class.getResource("/Images/BeginSelectedButton.png")));
			unselected = new Image(ImageIO.read(TestScreen.class.getResource("/Images/BeginUnSelectedButton.png")));
		} catch (IOException e){e.printStackTrace();}
		
		Button button = new Button(100, 200, 250, 75, selected, unselected, "test Button");
		addInteractable(button);
	}

	public void render()
	{
		super.render();
	}

	public void update()
	{

	}

}
