package GameAPI.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import GameAPI.Images.Image;
import GameAPI.Images.StandAloneImage;
import GameAPI.listeners.ScreenKeyListener;
import GameAPI.listeners.ScreenMouseListener;
import GameAPI.listeners.ScreenMouseMotionListener;
import GameAPI.screen.Screen;
import GameAPI.screen.ScreenManager;
import GameAPI.screen.util.Button;

public class GameAPI extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;
	
	private static GameAPI api;

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

	public GameAPI(String name, int w, int h, int s)
	{
		width = w;
		height = h;
		scale = s;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		frameName = name;
		super.setName(frameName);
		super.setFocusable(true);
		super.requestFocusInWindow();
		super.addKeyListener(new ScreenKeyListener());
		super.addMouseListener(new ScreenMouseListener());
		super.addMouseMotionListener(new ScreenMouseMotionListener());
		sm = new ScreenManager();
		api = this;
		
		test();
	}
	
	private void test()
	{
		sm.addScreen(new Screen("test"));
		sm.setCurrentScreen("test");
		Image testImage = new Image(Image.getImage("/Images/BeginSelectedButton.png"));
		Image testImageTwo = new Image(Image.getImage("/Images/BeginUnSelectedButton.png"));
		Button testButton = new Button(100, 100, 250, 75, testImage, testImageTwo);
		testButton.setHover(true);
		StandAloneImage sai = new StandAloneImage(testImage, 200, 200);
		sm.getCurrentScreen().addInteractable(testButton);
		sm.getCurrentScreen().addStandAloneImage(sai);
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
	
	public ScreenManager getScreenManager()
	{
		return sm;
	}
	
	public static GameAPI getAPI()
	{
		return api;
	}
}