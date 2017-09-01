import java.util.Scanner;

public class E62 {
	
	public static void main(String[] args) {
		
		// part a: The sum of all even numbers between 2 and 100 (inclusive)
		
		int totalA = 0;
		for(int i = 2; i <= 100; i++) {
			if (i%2 == 0) {
				totalA = totalA + i;
			}
		}
		System.out.println("a. The sum of all even numbers between 2 and 100 (inclusive) is: " + totalA);
	
		// part b: The sum of all squares between 1 and 100 (inclusive)
		
		int totalB = 0;
		int square = 0;
		for (int i = 1; i<=10; i++) {
				square = i*i;
				totalB = totalB + square;
		}
		System.out.println("b. The sum of all squares between 1 and 100 (inclusive) is: " + totalB);
	
		// part c: All powers of 2 from 2^0 up to 2^20
		
		System.out.println("c. The powers of 2 from 2^0 to 2^20 is: ");
		for (int i = 0; i<=20; i++) {
			System.out.println("2^" + i + " = " + Math.pow(2, i));
		}
	
		// part d: The sum of all odd numbers between a and b (inclusive), where a and b are inputs
		
		Scanner inA = new Scanner(System.in);
		Scanner inB = new Scanner(System.in);
		
		System.out.println("d. Please enter the lower bound: ");
		int lowerBound = inA.nextInt();
		
		System.out.println("Please enter the upper bound: ");
		int upperBound = inB.nextInt();
		
		int totalD = 0;
		while (lowerBound <= upperBound) {
			if (lowerBound%2 != 0) {			// tests for even or odd
				totalD = totalD + lowerBound;
			}
			lowerBound++;
		}
		System.out.println("The sum of all odd numbers between a and b (inclusive) is: " + totalD);
		
		// part e: The sum of all odd digits of an input
		
		Scanner inE = new Scanner(System.in);
		System.out.println("e. Please enter an integer: ");
		
		String numberE = inE.next();
		
		int totalE = 0;
		
		for(int i = 0; i < numberE.length(); i++) {
			
			String stringDigit = numberE.substring(i, i+1);
			int digit = Integer.parseInt(stringDigit);				// converts string to integer to be tested
			
			if (digit%2 != 0) {
				totalE = totalE + digit;
			}
		}
		System.out.println("The sum of all odd digits in the number " + numberE + " is: " + totalE);
		
	}
}
