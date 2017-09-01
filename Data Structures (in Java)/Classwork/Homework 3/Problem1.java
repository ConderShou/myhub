/*
 * Conder Shou
 * cs3544
 * Problem1.java
 * 
 * Instantiates an expression and uses it to test out the
 * 		various functions and methods of the ExpressionTree.java class
 */

import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter a postfix expression: ");
		
		String expression = in.nextLine();
		
		ExpressionTree expTree = new ExpressionTree(expression);
		
		System.out.println("The evaluation of this tree is: "+expTree.eval());
		System.out.println("The postfix traversal is: "+expTree.postfix());
		System.out.println("The prefix traversal is: "+expTree.prefix());
		System.out.println("The infix traversal is: "+expTree.infix());
	}

}
