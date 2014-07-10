package GameAPI.main;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestRun extends JFrame
{
	private static final long serialVersionUID = 1L;

	public static void main(String[] args)
	{
		TestRun run = new TestRun();
		run.start();
	}

	public void start()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		JPanel game = new GameAPI("GameAPI", 800, 600, 1);
		game.setLayout(null);
		setTitle("Maze Sweeper");
		add(game);
		setVisible(true);
		((GameAPI) game).start();
	}

}