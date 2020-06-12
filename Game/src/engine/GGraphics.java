package engine;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


public class GGraphics extends Canvas {

	private static final long serialVersionUID = 1L;

	private JFrame frame;

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

	public static final String NAME = "Game Name :D :D :D";
	public static final int WIDTH = 720;
	public static final int HEIGHT = WIDTH / 16 * 9;
	public static final int SCALE = 1;
	public long fps = 0;
	
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

	public void render() {

		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3); // Triple Buffering
			return;
		}

		Graphics g = bs.getDrawGraphics(); // Creates our graphics object that will fill the screen

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.drawLine(100, 100, 20, 20);
		g.dispose();
		bs.show();

	}

	public long getFps() {
		return this.fps;
	}
	
	
}
