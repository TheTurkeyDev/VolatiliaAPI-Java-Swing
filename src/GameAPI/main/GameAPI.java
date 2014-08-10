package GameAPI.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import GameAPI.screen.ScreenManager;
import GameAPI.graphics.DefaultFont;
import GameAPI.listeners.ScreenKeyListener;
import GameAPI.listeners.ScreenMouseListener;
import GameAPI.listeners.ScreenMouseMotionListener;

public class GameAPI extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;

	private static GameAPI api;
	
	private JFrame frame;

	public static int width, height, scale;

	private Thread thread;

	private String frameName;

	private boolean running = false;

	public static boolean displayInfo = false;

	private BufferedImage image;
	private int[] pixels;

	private ScreenManager sm;

	private int gFrames = 0;
	private int gUpdates = 0;

	public GameAPI(String name, int w, int h, int s, JFrame f)
	{
		width = w;
		height = h;
		scale = s;
		frame = f;
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		frameName = name;
		setFocusable(true);
		requestFocusInWindow();
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		sm = new ScreenManager();
		new DefaultFont();
		addKeyListener(new ScreenKeyListener());
		addMouseListener(new ScreenMouseListener());
		addMouseMotionListener(new ScreenMouseMotionListener());
		api = this;
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
				frame.setTitle(frameName + " FPS: " + gFrames + " UPS: " + gUpdates);
				timer += 1000;
				updates = 0;
				frames = 0;
				
			}
		}
	}

	public void update()
	{
		try
		{
		sm.getCurrentScreen().update();
		}catch(NullPointerException e){if(sm.getCurrentScreen()== null)return; else e.printStackTrace();}
	}

	public void render()
	{
		BufferStrategy strat = getBufferStrategy();
		if(strat == null)
		{
			createBufferStrategy(3);
			return;
		}
		try
		{
			// As long as the full size of the screen is being rendered out this isn't needed
			//sm.getCurrentScreen().clear();
			sm.getCurrentScreen().render();
		}catch(NullPointerException e){if(sm.getCurrentScreen()== null){System.out.println("Screen is null!!"); return; }else e.printStackTrace();}

		int[] pix = sm.getCurrentScreen().pixels;
		for(int y = 0; y < sm.getCurrentScreen().height; y++)
		{
			for(int x = 0; x < sm.getCurrentScreen().width; x++)
			{
				pixels[width * y + x] = pix[width * y + x];
			}
		}

		Graphics g = strat.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		if(displayInfo)
		{
			g.drawString(gUpdates + " ups, " + gFrames + " Frames", 0, 10);
		}
		g.dispose();
		strat.show();
	}

	public ScreenManager getScreenManager()
	{
		return sm;
	}

	public static GameAPI getAPI()
	{
		return api;
	}
}