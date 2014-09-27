package VolatiliaAPI.main;

import javax.swing.JFrame;

public class Display extends JFrame
{
	private static final long serialVersionUID = 1L;

	public Display(int width, int height)
	{
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(width, height);
		super.setLocationRelativeTo(null);
		super.setVisible(true);
	}
}
