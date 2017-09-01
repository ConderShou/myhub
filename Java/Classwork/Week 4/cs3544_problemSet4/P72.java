/* Conder Shou
 * cs3544
 * P71.java
 *
 * Generates a sequence of 20 random die tosses in an array
 *   and prints the die values, marking only the longest run
 */

public class P72 {

	public static void main(String[] args) {

		Die newDie = new Die(6);
		int[] dieArray = new int[20];

		// generates array of 20 random die rolls
		for(int i = 0; i < dieArray.length; i++) {
			dieArray[i] = newDie.rollDie();
		}

		boolean inRun = false;
		int tempMax = 1;
		int theMax = 0;
		int tempPos = 0;
		int initMaxPos = 0;
		int finalMaxPos = 0;

		for (int i = 0; i < dieArray.length; i++) {

			if (inRun) {

				if (dieArray[i] != dieArray[i-1]) {
					inRun = false;
					
// keeps track of longest run and stores its starting and ending positions
					if (tempMax > theMax) {
						theMax = tempMax;	
						initMaxPos = tempPos;
						finalMaxPos = i; // stores final position of the run
					}
					
					tempMax = 1;
				}
			}

			if (!inRun && i < dieArray.length - 1) {

				if (dieArray[i] == dieArray[i+1]) {
					inRun = true;
					tempMax++;
					tempPos = i; // stores starting position of the run

				}
			}

			if (inRun) {
				tempMax++;
			}
		}

		if (inRun) {

			if (tempMax > theMax) {
				theMax = tempMax;
				initMaxPos = tempPos;
				finalMaxPos = dieArray.length-1;
			}
		}

		// Marking the longest run and printing it out

		// program only marks run if a run of at least size 2 was found
		if (initMaxPos > 0 || finalMaxPos > 0) {  
			
			for (int i = 0; i < dieArray.length; i++) {

				if (i == initMaxPos) {
					System.out.print("( ");
				} else if (i == finalMaxPos) {
					System.out.print(") ");
				}
				
				System.out.print(dieArray[i] + " ");
			}
		}
	}

}
