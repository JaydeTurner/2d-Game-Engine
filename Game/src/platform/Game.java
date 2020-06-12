package platform;

import java.awt.Canvas;

import engine.GCore;

public class Game extends Canvas implements Runnable {

	
	private static final long serialVersionUID = 1L;

	boolean running = true;
	
	GCore curCore = new GCore();


	
	public static void main(String[] args) {
		System.out.println("Starting new game");
		new Game().start();
		
	}

	private void start() {
		System.out.println("Creating Thread...");
		new Thread(this).start(); // This creates the cpu thread the game will run on
	}

	public void run() {
		System.out.println("Runing core...");
	curCore.run();

	}

}
