import java.util.Scanner;

public class P410 {
	
	public static void main(String[] args) {
		
		// Reading the initial balance and annual interest rate from user
		
	
		Scanner userInputBalance = new Scanner(System.in);
		Scanner userInputInterest = new Scanner(System.in);
		
		System.out.println("Please enter your starting balance: ");
		double initBalance = userInputBalance.nextDouble();
		
		System.out.println("Please enter the percentage of your annual interest rate: ");
		double annualInterest = userInputInterest.nextDouble();
		
		double annualInterestPercent = annualInterest/100;	// Converting percent to the actual value that will be multiplied to the initial balance
		int compoundperYear = 12;							// Compounded monthly means that the deposite is compounded 12 times a year
		
		// Now we calculate how the deposits will grow in 3 months
		
		double newBalance;
		String month[] = {"first", "second", "third"};
		System.out.println();								// Leaving a blank line in between for aesthetics
		
		System.out.printf("Initial Balance: %.0f", initBalance);	/* Simply just adhering to the sample given in textbook, 
																	*where there were no decimals given for initial balance */
		System.out.println();
		System.out.println("Annual Interest Rate in Percent: " + annualInterest);
		
		for(int i=1; i<=3; i++) {
			newBalance = initBalance + initBalance * (annualInterestPercent/compoundperYear);
			initBalance = newBalance;
			
			if (i==2) {
				System.out.printf("After " + month[i-1] + " month: %9.2f ", newBalance);	// This is to keep the printing of the balance in a neat, strict column
			} else {
				System.out.printf("After " + month[i-1] + " month: %10.2f", newBalance);
			}
			
			System.out.println();
		}
	}
}
