package engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Key Pressed!");
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Key Released!");
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("Key Typed!");
	}

}
