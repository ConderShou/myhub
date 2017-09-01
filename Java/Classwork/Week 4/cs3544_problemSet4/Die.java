/*
 * Conder Shou
 * cs3544
 * Die.java
 * 
 * A die class that rolls an any sided die and 
 * 		returns the random value
 */

public class Die {

	private int n;
	private int randSide;
	
	public Die(int numberofSides) {
		n = numberofSides;
		rollDie();
	}
	
	public int rollDie() {
		randSide = (int) (Math.random() * n + 1);
		return randSide;
	}
}
