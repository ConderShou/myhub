/* Conder Shou
 * cs3544
 * P71.java
 *
 * Generates a sequence of 20 random die tosses in an array
 *   and prints the die values, marking the runs by including 
 *   them in parentheses
 */

public class P71 {

	public static void main(String[] args) {
		
		Die newDie = new Die(6);
		int[] dieArray = new int[20];
		
		// generates array of 20 random die rolls
		
		for(int i = 0; i < dieArray.length; i++) {
			dieArray[i] = newDie.rollDie();
		}
		
		// following the pseudocode provided in the problem itself
		boolean inRun = false;
		
		for (int i = 0; i < dieArray.length; i++) {
			
			if (inRun) {
				
				if (dieArray[i] != dieArray[i-1]) {
					System.out.print(") ");
					inRun = false;
				}
			}
			
			if (!inRun && i < dieArray.length - 1) {
				
				if (dieArray[i] == dieArray[i+1]) {
					System.out.print("( ");
					inRun = true;
				}
			}
			
			System.out.print(dieArray[i] + " ");
		}
		
		if (inRun)
			System.out.print(" ) ");
	}
}
