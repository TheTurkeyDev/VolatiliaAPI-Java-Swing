package GameAPI.main;

import javax.swing.JApplet;

public class TestRun extends JApplet
	{
		private static final long serialVersionUID = 1L;

		public void init()
		{
			super.setSize(800, 600);
			GameAPI game = new GameAPI("GameAPI", 800, 600, 1);
			super.add(game);
			game.start();
		}
	}