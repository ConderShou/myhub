/** 
 * @author Conder Shou
 * cs3544
 * RomanNumeralTester.java
 * 
 * Tests the RomanNumeral.java class to see if it converts numbers up to 3999 into Roman numerals
 */

import java.util.Scanner;

public class RomanNumeralTester {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int number;
		
		do {
		System.out.println("Please enter an integer: ");
		number = in.nextInt();
		}
		while (number > 3999);
		
		RomanNumeral testNumber = new RomanNumeral(number);
		
		System.out.println("The roman numeral of " + number 
							+ " is: " + testNumber.getNumeral());

	}

}
