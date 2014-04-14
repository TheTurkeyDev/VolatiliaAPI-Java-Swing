package GameAPI.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import GameAPI.listeners.ScreenKeyListener;
import GameAPI.listeners.ScreenMouseListener;
import GameAPI.listeners.ScreenMouseMotionListener;
import GameAPI.screen.Screen;
import GameAPI.screen.ScreenManager;

public class GameAPI extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;

	//width = 900, height = 506
	public static int width = 800, height = 600, scale = 1;

	private Thread thread;
	private JFrame frame;

	private String frameName;

	private boolean running = false;

	public static boolean displayInfo = false;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

	private ScreenManager sm;

	private int gFrames = 0;
	private int gUpdates = 0;

	public GameAPI(String name)
	{
		frame = new JFrame();
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		frameName = name;
		frame.setFocusable(true);
		frame.requestFocus();
		frame.requestFocusInWindow();
		frame.setResizable(false);
		frame.setTitle(frameName);
		frame.add(this);
		frame.addKeyListener(new ScreenKeyListener());
		frame.addMouseListener(new ScreenMouseListener());
		frame.addMouseMotionListener(new ScreenMouseMotionListener());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		sm = new ScreenManager();
		sm.setCurrentScreen(new Screen(width, height));
	}

	public static void main(String args[])
	{
		GameAPI game = new GameAPI("GameAPI");
		game.start();

	}

	public synchronized void start()
	{
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop()
	{
		running = false;
		try
		{
			thread.join();
		} catch (InterruptedException e){e.printStackTrace();}
	}

	public void run()
	{
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1)
			{
				update();
				updates++;
				delta--;
			}
			render();
			frames++;

			if(System.currentTimeMillis() - timer > 1000)
			{
				gFrames = frames;
				gUpdates = updates;
				timer += 1000;
				updates = 0;
				frames = 0;
			}
		}
	}

	public void update()
	{

	}

	public void render()
	{
		BufferStrategy bfs = getBufferStrategy();

		if(bfs == null)
		{
			createBufferStrategy(3);
			return;
		}

		try
		{
			sm.getCurrentScreen().clear();
			sm.getCurrentScreen().render();
		}catch(NullPointerException e){System.out.println("Screen is null!!");}

		for(int y = 0; y < sm.getCurrentScreen().height; y++)
		{
			for(int x = 0; x < sm.getCurrentScreen().width; x++)
			{
				pixels[width * y + x] = sm.getCurrentScreen().pixels[width * y + x];
			}
		}


		Graphics g = bfs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		if(displayInfo)
		{
			g.drawString(gUpdates + " ups, " + gFrames + " Frames", 0, 10);
		}
		g.dispose();
		bfs.show();
	}
}