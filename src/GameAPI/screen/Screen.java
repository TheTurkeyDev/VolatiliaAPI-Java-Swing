package GameAPI.screen;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import GameAPI.graphics.Background;
import GameAPI.graphics.Image;
import GameAPI.graphics.Text;
import GameAPI.listeners.KeyListener;
import GameAPI.main.VolatiliaAPI;
import GameAPI.screen.screenObjects.Interactable;
import GameAPI.screen.subscreen.SubScreen;

public class Screen
{

	private String name;
	public int height, width;

	public int[] pixels;

	private Background bg;

	private ArrayList<SubScreen> subScreens = new ArrayList<SubScreen>();
	private ArrayList<Interactable> interactables = new ArrayList<Interactable>();
	private ArrayList<Text> text = new ArrayList<Text>();

	public Screen(String n)
	{
		name = n;
		height = VolatiliaAPI.height;
		width = VolatiliaAPI.width;
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

	}

	public void onHover(Interactable clicked)
	{

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
							if (image[x + y * ss.getWidth()] != -65316) 
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
			try{
				int[] image = i.getCurrentPixelArray();

				for (int y = 0; y < i.getHeight(); y++)
				{
					for (int x = 0; x < i.getWidth(); x++)
					{
						if(x < 0 || x > width || y < 0 || y >= height )break;					
						if (image[x + y * i.getWidth()] != -65316)
							pixels[width * (y + i .getY()) + (x + i.getX())] = image[x + y * i.getWidth()];
					}
				}
			}catch(NullPointerException e){continue;}
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
						if (pix[w * yLoc + xLoc] != -65316)
							pixels[width * (t.getLocation().getY() + yLoc) + (t.getLocation().getX() + (xLoc + (w * i)))] = pix[w * yLoc + xLoc];
					}
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
}
