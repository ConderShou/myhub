/**
 * @author Conder Shou
 * cs3544
 * Drunkard.java
 * 
 * A class for a randomly stumbling drunkard, 
 * 	moving from one intersection to the next
 * 
 */

import java.util.Random;

public class Drunkard {
	
	// X and Y positions of the drunkard
	private int posX;
	private int posY;
	private final int INIT_POSX;
	private final int INIT_POSY;
	
	public Drunkard (int avenue, int street) {
		
		INIT_POSX = avenue;
		INIT_POSY = street;
		
		posX = avenue;
		posY = street;	
	}
	
	public void step() {
		
		Random stumble = new Random();
		
		int newPos = stumble.nextInt(4);		// gives us a random integer between 0 inclusive and 4 exclusive
	
		switch (newPos) {
		case 0: posX = posX + 1; break;	// west
		case 1: posX = posX - 1; break;	// east
		case 2: posY = posY + 1; break;	// north
		case 3: posY = posY - 1; break;	// south
		}
		
	}
	
	public void fastForward(int steps) {
		
		for (int i = 0; i <= steps-1; i++) {
			step();
		}
	}
	
	public String getLocation() {
		
		String currentPos = "The silly drunkard is currrently at Avenue " + posX 
								+ " and Street " + posY;
		
		return currentPos;
	}
	
	public int howFar() {
		
		// calculating distance using the Manhattan distance metric
		
		int distance = Math.abs(INIT_POSX - posX) + Math.abs(INIT_POSY - posY);
		
		return distance;
	}
}
