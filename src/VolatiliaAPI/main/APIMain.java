package VolatiliaAPI.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import VolatiliaAPI.graphics.DefaultFont;
import VolatiliaAPI.listeners.KeyListener;
import VolatiliaAPI.listeners.MouseListener;
import VolatiliaAPI.listeners.MouseMotionListener;
import VolatiliaAPI.map.MapManager;
import VolatiliaAPI.screen.ScreenManager;

public class APIMain extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;

	private static APIMain api;

	private JFrame frame;

	public static int width, height;
	private int scale = 1;

	private Thread thread;

	private String frameName;

	private boolean running = false;
	private boolean loading = true;

	public boolean rendercheck = false;
	public long renderStart;
	public long lastrenderLength = 0;

	public boolean renderMapOnce = false;

	private BufferedImage image;
	private int[] pixels;

	private ScreenManager sm;
	private MapManager mm;

	private int gFrames = 0;
	private int gUpdates = 0;

	private boolean displayFPS = false;

	public APIMain(String name)
	{
		frameName = name;
		sm = new ScreenManager();
		mm = new MapManager();
		new DefaultFont();
		addKeyListener(new KeyListener());
		addMouseListener(new MouseListener());
		addMouseMotionListener(new MouseMotionListener());
		api = this;
	}

	public void setDisplay(Display display)
	{
		frame = display;
		width = display.getWidth();
		height = display.getHeight();

		Dimension size = new Dimension(width, height);
		setPreferredSize(size);
		setFocusable(true);
		requestFocusInWindow();
		display.add(this);

		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
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
			try{
				render();
			}catch(IllegalStateException e){System.err.println("No Display is Set!!");}
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
		try
		{
			sm.getCurrentScreen().update();
		}catch(NullPointerException e){if(sm.getCurrentScreen()== null)return; else e.printStackTrace();}
	}

	public void render()
	{
		renderStart = System.nanoTime();
		BufferStrategy strat = getBufferStrategy();
		if(strat == null)
		{
			createBufferStrategy(3);
			return;
		}
		try
		{
			sm.getCurrentScreen().clear();
			sm.getCurrentScreen().render();
			if(loading)
				loading = false;
		}catch(NullPointerException e)
		{
			if(sm.getCurrentScreen()== null)
			{
				System.err.println("Screen is null!!"); 
				return;
			}
			else
				e.printStackTrace();
		}

		int[] pix = sm.getCurrentScreen().pixels;
		for(int y = 0; y < sm.getCurrentScreen().height; y++)
		{
			for(int x = 0; x < sm.getCurrentScreen().width; x++)
			{
				pixels[width * y + x] = pix[width * y + x];
			}
		}

		if(displayFPS)
			frame.setTitle(frameName + ":" + this.getFPS());
		else
			frame.setTitle(frameName);
		Graphics g = strat.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		strat.show();
		lastrenderLength = System.nanoTime() - renderStart;
	}

	public ScreenManager getScreenManager()
	{
		return sm;
	}
	
	public MapManager getMapManager()
	{
		return mm;
	}

	public static APIMain getAPI()
	{
		return api;
	}

	public void doRenderCheck()
	{
		rendercheck = true;
	}

	public void renderMapOnce()
	{
		renderMapOnce = true;
	}

	public int getFPS()
	{
		return gFrames;
	}
	public int getUPS()
	{
		return gUpdates;
	}

	public void setTitle(String title)
	{
		frameName = title;
	}

	public void displayFPS()
	{
		displayFPS = true;
	}

	public int getScale()
	{
		return scale;
	}

	public void setScale(int scale)
	{
		this.scale = scale;
	}
}