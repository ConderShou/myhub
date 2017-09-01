/** 
 * @author Conder Shou
 * cs3544
 * RomanNumeral.java
 * 
 * Converts numbers up to 3999 into Roman numerals
 */

public class RomanNumeral {

	private int number;
	private String romanNumeral = "";
	
	public RomanNumeral(int number) {
		this.number = number;
		numToRoman();
	}
	
	public void numToRoman() {
		
		// finding number of 1000s (M's) in number
		
		int numofM = number/1000;		// will ignore remainder
		number = number - numofM*1000;	// updates number for further conversion
		
		// finding number of 500s (D's) 
		
		int numofD = number/500;
		
		// finding number of 100s (C's)
		
		int numofC = number/100;
	
		number = number - (numofC*100);	/* updated only after checking D
														   in case number is 900*/
		// finding number of 50s (L'a)
		
		int numofL = number/50;
		
		// finding number of 10s (X's)
		
		int numofX = number/10;
		
		number = number - (numofX*10);
		
		// finding number of 5s (V's)
		
		int numofV = number/5;
		
		// remaining number is the number of I
		int numofI = number;
		
		// converting to Roman Numerals
	
		boolean addedCM = false;		// these booleans are used to accommodate for X = 9, C = 9, I = 9, etc...
		boolean addedD = false;
		boolean addedXC = false;
		boolean addedL = false;
		boolean addedIX = false;
		boolean addedV = false;
		
		// converting M
		for (int i = 0; i <= numofM-1; i++) {
			addNumeral("M");
		}
		
		if (numofC == 9) {
			
			addNumeral("CM");
			
			addedCM = true;
		}
		
		
		
		// converting D
		if (numofD > 0 && !addedCM) {
			
			addNumeral("D");	// no need for a loop cause D can only be 1 at max
			
			addedD = true;
		}
		 
		
		// converting C
		if (numofC == 4) {
			
			addNumeral("CD");
			
		} else if (numofC != 9 && addedD) {
			
			for (int i = 0; i<= numofC-6; i++) {
			addNumeral("C");
			}
			
		} else if (numofC != 9 && !addedD) {
			
			for (int i = 0; i<= numofC-1; i++) {
				addNumeral("C");
			}
		}
		
		if (numofX == 9) {
			
			addNumeral("XC");
			
			addedXC = true;
		}
		
		//converting L
		if (numofL > 0 && !addedXC) {
			
			addNumeral("L");
			
			addedL = true;
		}
		
		//converting X
		if (numofX == 4) {
			
			addNumeral("XL");
			
		} else if (numofX != 9 && addedL) {
			
			for (int i = 0; i <= numofX-6; i++) {
				addNumeral("X");
			}
			
		} else if (numofX != 9 && !addedL) {
			
			for (int i = 0; i <= numofX-1; i++) {
				addNumeral("X");
			}
		}
		

		if (numofI == 9) {
			
			addNumeral("IX");
			
			addedIX = true;
		}
		
		
		
		//converting V
		if (numofV > 0 && !addedIX) {
			
			addNumeral("V");
			
			addedV = true;
		}
		

		
		//converting I
		if (numofI == 4) {
			
			addNumeral("IV");
			
		} else if (numofI != 9 && addedV) {
			
			for (int i = 0; i <= numofI - 6; i++) {
				addNumeral("I");
			}
			
		} else if (numofI != 9  && !addedV) {
			
			for (int i = 0; i <=numofI - 1; i++) {
				addNumeral("I");
			}
		}
	}
	
	public void addNumeral(String letter) {
		romanNumeral = romanNumeral.concat(letter);
	}
	
	public String getNumeral() {
		return romanNumeral;
	}
		
}
