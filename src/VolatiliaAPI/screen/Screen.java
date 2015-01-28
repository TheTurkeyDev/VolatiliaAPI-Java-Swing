package VolatiliaAPI.screen;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import VolatiliaAPI.graphics.Background;
import VolatiliaAPI.graphics.Image;
import VolatiliaAPI.graphics.Text;
import VolatiliaAPI.graphics.basic.BasicObject;
import VolatiliaAPI.graphics.basic.Circle;
import VolatiliaAPI.graphics.basic.Rectangle;
import VolatiliaAPI.listeners.KeyListener;
import VolatiliaAPI.main.APIMain;
import VolatiliaAPI.screen.screenObjects.InputInteractable;
import VolatiliaAPI.screen.screenObjects.Interactable;
import VolatiliaAPI.screen.subscreen.SubScreen;

public class Screen
{

	private String name;
	public int height, width;

	public int[] pixels;

	private Background bg;

	private Interactable selected = null;

	private ArrayList<SubScreen> subScreens = new ArrayList<SubScreen>();
	private ArrayList<Interactable> interactables = new ArrayList<Interactable>();
	private ArrayList<Text> text = new ArrayList<Text>();
	private ArrayList<BasicObject> basic = new ArrayList<BasicObject>();
	public Screen(String n)
	{
		name = n;
		height = APIMain.height;
		width = APIMain.width;
		pixels = new int[width * height];
	}

	public void update()
	{
		pollInput();
	}

	public void render()
	{
		renderInteractables();
		renderText();
		renderBasicObjects();
		renderSubScreens();
	}

	private void pollInput()
	{
		while(KeyListener.hasnext())
		{
			OnKeyEvent(KeyListener.getCurrentEvent(), KeyListener.getCurrentState());
			KeyListener.removelast();
		}
	}

	public void OnKeyEvent(KeyEvent e, boolean pressed)
	{
		if(selected != null && selected instanceof InputInteractable)
		{
			if(pressed)
			{
				InputInteractable ii = ((InputInteractable)selected);
				if(e.getKeyCode() == 8)
				{
					ii.removeletter();
				}
				else if(e.getKeyCode() >= 32 && e.getKeyCode() <= 127)
				{
					ii.addletter("" + e.getKeyChar());
				}
			}
		}
	}

	public void clear()
	{
		if(bg == null)
		{
			for(int x = 0; x < width; x++)
			{
				for(int y = 0; y < height; y++)
				{
					pixels[width * y + x] = 0x000000;
				}
			}
		}
		else
		{
			pixels = bg.getPixles();
		}
	}

	public void loadScreen()
	{

	}

	public void unLoadScreen()
	{

	}

	public void onClicked(Interactable clicked)
	{
		selected = clicked;
	}

	public void onHover(Interactable clicked)
	{
		selected = clicked;
	}

	public void renderSubScreens()
	{
		for (SubScreen ss : subScreens)
		{
			if(ss.isVisible())
			{
				ss.render();
				int[] image = ss.pixels;
				for (int x = 0; x < ss.getWidth(); x++)
				{
					for (int y = 0; y < ss.getHeight(); y++)
					{
						if (ss.getY() + y >= 0 && ss.getY() + y < height && ss.getX() + x >= 0 && ss.getX() + x < width)
						{
							if (image[x + y * ss.getWidth()] != ScreenManager.getInstance().getOmmitColor()) 
								pixels[width * (ss.getY() + y) + (ss.getX() + x)] = image[x + y * ss.getWidth()];
						}
					}
				}
			}
		}
	}

	public void renderInteractables()
	{
		for (Interactable i : interactables)
		{
			if(!i.isVisible())continue;
			int[] image = i.getCurrentPixelArray();

			for (int y = 0; y < i.getHeight(); y++)
			{
				for (int x = 0; x < i.getWidth(); x++)
				{
					if(x < 0 || x > width || y < 0 || y >= height )break;					
					if (image[x + y * i.getWidth()] != ScreenManager.getInstance().getOmmitColor())
						pixels[width * (y + i.getY()) + (x + i.getX())] = image[x + y * i.getWidth()];
				}
			}
		}
	}

	public void renderText()
	{
		for (Text t : text)
		{
			if(!t.isVisible())
				continue;
			for(int i = 0; i < t.getImageAmount(); i++)
			{
				Image image = t.getImageAt(i);
				int[] pix = image.getPixels();
				int w = image.getWidth();
				for(int yLoc = 0; yLoc < w; yLoc++)
				{
					for(int xLoc = 0; xLoc < image.getWidth(); xLoc++)
					{
						if (pix[w * yLoc + xLoc] != ScreenManager.getInstance().getOmmitColor())
							pixels[width * (t.getLocation().getY() + yLoc) + (t.getLocation().getX() + (xLoc + (w * i)))] = pix[w * yLoc + xLoc];
					}
				}
			}
		}
	}

	public void renderBasicObjects()
	{
		for (BasicObject bo : basic)
		{
			int[] image = bo.getPixles();

			for (int y = 0; y < bo.getHeight(); y++)
			{
				for (int x = 0; x < bo.getWidth(); x++)
				{
					if(x < 0 || x > width || y < 0 || y >= height )break;
					if (image[x + y * bo.getWidth()] != ScreenManager.getInstance().getOmmitColor())
						pixels[width * (y + bo.getY()) + (x + bo.getX())] = image[x + y * bo.getWidth()];
				}
			}
		}
	}

	public String getName()
	{
		return name;
	}

	public void addSubScreen(SubScreen ss)
	{
		subScreens.add(ss);
	}

	public ArrayList<SubScreen> getSubScreens()
	{
		return subScreens;
	}

	public void addInteractable(Interactable i)
	{
		interactables.add(i);
	}

	public ArrayList<Interactable> getInteractables()
	{
		return interactables;
	}

	public void addText(Text t)
	{
		text.add(t);
	}

	public ArrayList<Text> getText()
	{
		return text;
	}

	public void setBackground(Background background)
	{
		bg = background;
	}

	public void clearInteractables()
	{
		interactables.clear();
	}

	public ArrayList<SubScreen> getVisibleSubScreens()
	{
		ArrayList<SubScreen> toreturn = new ArrayList<SubScreen>();
		for (SubScreen ss : subScreens)
		{
			if(ss.isVisible())
			{
				toreturn.add(ss);
			}
		}
		return toreturn;
	}

	public Rectangle addRectangle(int x, int y, int w, int h, Color c)
	{
		Rectangle rect = new Rectangle(x, y, w, h, c);
		basic.add(rect);
		return rect;
	}
	
	public void addBasicObejct(BasicObject obj)
	{
		basic.add(obj);
	}
	
	public Circle addCirlce(int x, int y, int r, Color c)
	{
		Circle circ = new Circle(x, y, r, c);
		basic.add(circ);
		return circ;
	}

	public void setSelectedInteractable(Interactable i)
	{
		selected = i;
	}
}
