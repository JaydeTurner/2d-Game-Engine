package engine;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


public class GGraphics extends Canvas {

	private static final long serialVersionUID = 1L;

	private JFrame frame;

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

	public static final String NAME = "Game Name :D :D :D";
	public static final int WIDTH = 1280;
	public static final int HEIGHT = WIDTH / 16 * 9;
	public static final int SCALE = 1;
	public long fps = 0;
	
	
	Font menuFont = new Font ("Prestige Elite Std", 1, 48);

	
	public GGraphics() {

		setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE)); // Declaring what the sizeof the JFrame is

		frame = new JFrame(NAME); // Initialising the JFrame

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // This ensures clicking the X closes the whole
																// application
		frame.setLayout(new BorderLayout()); // Sets the layout, Makes sure frame stays centered within the window

		frame.add(this, BorderLayout.CENTER); // Adds the game/canvas to the Jframe (In the center of the Jframe)
		frame.pack(); // This will set the frame to keep everything sized correctly

		frame.setResizable(false); // Frame not resizable
		frame.setLocationRelativeTo(null); // Not relative to any location, keep centered on the display
		frame.setVisible(true);
	}

	public void renderMenu() {

		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3); // Triple Buffering
			return;
		}

	
		
		//initialise graphics object for border
		Graphics gRedBorder = bs.getDrawGraphics(); // Creates our graphics object that will fill the screen
		//Set up border
		gRedBorder.setColor(Color.RED);
		gRedBorder.fillRect(0, 0, getWidth(), getHeight());
		gRedBorder.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		gRedBorder.drawLine(20, 20, 1260, 20);
		gRedBorder.drawLine(20, 700, 20, 20);
		gRedBorder.drawLine(1260, 20, 1260, 700);
		gRedBorder.drawLine(1260, 700, 20, 700);
		gRedBorder.dispose();
		
		
		//Drawing our games title
		Graphics gTitle = bs.getDrawGraphics();
		gTitle.setFont(menuFont);
		gTitle.drawString("Jayde's totes hot legit game 4 real ", 120, 120);
		gTitle.dispose();
		
		// Box surrounding title
		Graphics gTitlebox = bs.getDrawGraphics();
		gTitlebox.setColor(Color.RED);
		gTitlebox.drawRect(80, 60, 1090, 100);
		
		
		bs.show();// This needs to be on the last item or we get flashing. Only need to show the lot once.

	}
	// In order to show highlighted menu selection, border will change to blue.
	public void menuSelect(Graphics g) {
		g.setColor(Color.BLUE);
	}
	public long getFps() {
		return this.fps;
	}
	
	
}
