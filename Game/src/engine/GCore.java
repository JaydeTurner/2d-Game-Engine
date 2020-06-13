package engine;

public class GCore implements Runnable {
	
	GGraphics curGraphics = new GGraphics();
	
	public int tickCount = 0;
	public long fps = 0;

	
	public void run() {
		
		System.out.println("Core entered...");
		
		long lastTime = System.nanoTime(); // Sets the time in Ns at the start of the run

		double nsPerTick = 100000000D / 60D;  // How many Ns are going to be in the 60 updates

		int frames = 0;
		int ticks = 0;

		long lastTimer = System.currentTimeMillis(); // The time when to reset the data 
		
		double delta = 0; //How many unprocessed NS have gone by so far 

		boolean running = true;

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick; //Thi
			lastTime = now;

			boolean shouldRender = false;

			while (delta >= 1) {
				ticks++;
				tick();
				delta -= 1;
				shouldRender = true;
			}



			if (shouldRender) {

				frames++;
				//render();
				curGraphics.renderMenu();
				
				
			}

			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 100;
				fps = frames;
				System.out.println("FPS: " + frames + ", " + "Ticks/s: " + ticks);
				frames = 0;
				ticks = 0;
			}
		}

	}

	private void tick() {
		tickCount++;

		
	}
	public int getTickCount() {
		return tickCount;
	}
	
	public long getFps() {
		return fps;
	}


}
