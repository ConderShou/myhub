/**
 * @author Conder Shou
 * cs3544
 * SymbolBalance.java
 * Reads a java file as a command line argument and checks to make sure
 * 	all {}'s, ()'s, []'s, ""s, and multi-line comment operators, 
 * 	are properly balanced.
 *
 */
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;


public class SymbolBalance {

	private MyStack<String> myStack = new MyStack<>();
	private int commentCheck;	// tells program to ignore the content within comments and quotes
	private int quoteCheck;
	private int continueLoop;	// tells program whether to continue checking file or not after the first error has been found

	public void balance(char[] myChar) {

		String compareValue;

		if (continueLoop != 1) {
			
			// Working through the char array of the given token from the java file and converting it to string

			for (int i = 0; i <= myChar.length - 1; i++) {			
				String in = Character.toString(myChar[i]);

				if (i < myChar.length - 1) {
					String peek = Character.toString(myChar[i+1]);
					if (in.equals("/") && peek.equals("*") ) {			
						in = "/*";
					} else if (in.equals("*") && peek.equals("/")) {
						in = "*/";
					}
				}
				// Pushing the opening symbols into stack

				// these if conditions ensure that nothing is read within the comments or quotations
				if (commentCheck != 1 && quoteCheck != 1) {		
					if (in.equals("{")) {
						myStack.push(in);
					} else if (in.equals("(")) {
						myStack.push(in);
					} else if (in.equals("[")) {
						myStack.push(in);
					} else if (in.equals("\"")) {

						quoteCheck = 1;
						myStack.push(in);

					} else if (in.equals("/*")) {

						commentCheck = 1;
						myStack.push(in);
					}

					// Now checking the corresponding opening closing of the symbols

					else if (in.equals(")")) {

		        // these if statements identify if the closing symbol has a corresponding opening symbol or not
						if (myStack.isEmptyStack()) { 		
							errorMsg(null, in);
						} else {
						
				// these else statements check if there's a mismatch
							
							compareValue = myStack.pop();

							if (!compareValue.equals("(")) {
								errorMsg(in, compareValue);
							}
						}
					} else if (in.equals("]")) {

						if (myStack.isEmptyStack()) {
							errorMsg(null, in);
						} else {
							compareValue = myStack.pop();

							if (!compareValue.equals("[")) {
								errorMsg(in, compareValue);
							}
						}
					} else if (in.equals("}")) {

						if (myStack.isEmptyStack()) {
							errorMsg(null, in);
						} else {
							compareValue = myStack.pop();

							if (!compareValue.equals("{")) {
								errorMsg(in, compareValue);
							}
						}

					} else if (in.equals("*/")) {
						errorMsg(null, in);
					}

			
				} else if (quoteCheck != 1 && commentCheck == 1 && in.equals("*/")) {

					if (myStack.isEmptyStack()) {
						errorMsg(null, in);
					} else {
						compareValue = myStack.pop();

						if (!compareValue.equals("/*")) {
							errorMsg(in, compareValue);
						} else {
							commentCheck = 0;			// allows program to start pushing the other symbols again
						}
					}

				} else if (commentCheck != 1 && quoteCheck == 1 && in.equals("\"")) {

					if (myStack.isEmptyStack()) {
						errorMsg(null, in);
					} else {
						compareValue = myStack.pop();

						if (!compareValue.equals("\"")) {
							errorMsg(in, compareValue);
						} else {
							quoteCheck = 0;
						}
					}
				}
			}
		}
	}


	public void emptyStack() {

		if (continueLoop != 1) {
			if (myStack.theSize() == 0) {
				System.out.println("This code is all balanced!");
			} else if (quoteCheck != 1 && commentCheck != 1) {

				while (myStack.theSize() > 0) {
					// pops operators until it reaches the first one to identify the first error
					if (myStack.theSize() == 1) {
						String firstError = myStack.pop();	
						System.out.println("The opening symbol " + firstError + " has no closing symbol!");
					} else {
						myStack.pop();
					}
				}
			} else if (commentCheck == 1) {
				System.out.println("The opening symbol /* has no closing symbol!");
			} else if (quoteCheck == 1) {
				System.out.println("The opening symbol \" has no closing symbol!");
			}
		}
	}

	public void errorMsg(String openSymbol, String errorSymbol) {

		if (openSymbol == null) {
			System.out.println("The closing symbol " + errorSymbol + " has no opening symbol!");
		} else {
			System.out.println("Imbalance found: " + errorSymbol + " is mismatched with " + openSymbol);
		}
		continueLoop = 1;
	}

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new BufferedReader( new FileReader(args[0])));
		SymbolBalance checkBalance = new SymbolBalance();
		String str;

		while (in.hasNext()) {

			str = in.next();
			char[] myChar = str.toCharArray();
			checkBalance.balance(myChar);
		}

		checkBalance.emptyStack();



	}
}



