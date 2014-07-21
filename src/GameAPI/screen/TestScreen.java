package GameAPI.screen;

import GameAPI.graphics.Image;
import GameAPI.graphics.ImageSheet;
import GameAPI.screen.screenObjects.Button;
import GameAPI.screen.screenObjects.Tile;
import GameAPI.util.Maze;

public class TestScreen extends Screen
{

	private Maze maze;
	
	private ImageSheet test = new ImageSheet(TestScreen.class, "/Images/testSheet.png", 800, 600);
	private ImageSheet tilesheet = new ImageSheet(TestScreen.class, "/Images/TileSheet.png", 640, 640);
	private Image selected = new Image(test,0,0,250,75);
	private Image unselected = new Image(test,250,0,250,75);
	private Image void_Tile_Image = new Image(tilesheet,0,0,64,64);
	private Image grass_Tile_Image = new Image(tilesheet,64,0,64,64);
	private Tile voidTile = new Tile(void_Tile_Image, "Void Tile", 0);
	private Tile grass = new Tile(grass_Tile_Image, "Grass Tile", 1);
	private Button button = new Button(100, 200, 250, 75, selected, unselected, "test Button");

	public TestScreen(String n)
	{
		super(n);
		maze = new Maze();
		maze.generate(false, 40, 30, 20, 20);
		addInteractable(button);
		setOffset(0, 0);
		ScreenManager.getInstance().addTile(grass);
	}

	public void render()
	{
		super.render();
	}

	public void update()
	{

	}

}
