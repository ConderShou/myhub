/*
 * Conder Shou
 * cs3544
 * 
 * ExpressionTree.java
 * 
 * Constructs an expression tree from a postfix expression
 * Has methods that can evaluate the tree, and give the
 * 	postorder, inorder, and preorder traversal
 */

public class ExpressionTree {

	private static class ExprNode {
		char operator;
		int operand;

		ExprNode left;
		ExprNode right;
	}

	private ExprNode root;
	private String exprString = "";
	
	public ExpressionTree(String postfix) {

		MyStack<ExprNode> exprTree = new MyStack<>();
		String[] expression = postfix.split(" ");
		
		String value;
	
		// Using the algorithm learned in class and in Weiss
		for (int i = 0; i < expression.length; i++) {

			value = expression[i];

			ExprNode node = new ExprNode();

			if (value.equals("+") || value.equals("-") || value.equals("*") 
					|| value.equals("/")) {

				node.operator = value.charAt(0);
				node.right = exprTree.pop();	//creating a new tree
				node.left = exprTree.pop();

				exprTree.push(node);
			} else {

				node.operand = Integer.parseInt(value);

				exprTree.push(node); //pushing the newly created tree
			}
			
			// in a postfix expression, the last element is the node
			if (i == expression.length - 1) {
				root = node;	
			}
		}
	}

	public int eval() {
		
		return eval(root);
	}

	private int eval(ExprNode t) {
		
		// tests if root is null
		if (t == null) {
			System.out.println("ERROR: Root is null");
			return 0;
		}
		
		MyStack<Integer> evalTree = new MyStack<>();
		
		String[] postExpr = postfix().split(" ");
		int result = 0; //contains the sum/diff/product/quotient of the operations
		String elem;
		
		for (int i = 0; i < postExpr.length; i++) {

			
			elem = postExpr[i];

			if (elem.equals("+") || elem.equals("-") || elem.equals("*") 
					|| elem.equals("/")) {

				int right = evalTree.pop();
				int left = evalTree.pop();
				
			// does the corresponding operation that is popped
				if (elem.equals("+")) {
					result = left + right;
				} else if (elem.equals("-")) {
					result = left - right;
				} else if (elem.equals("*")) {
					result = left * right;
				} else if (elem.equals("/")) {
					result = left / right;
				}
				
				evalTree.push(result);
				
			// pushing the result of the operation back into stack
			} else {
				evalTree.push(Integer.parseInt(elem));
			}
		}
		
		return evalTree.pop();
		
	}


	public String postfix() {
		// calls private recursive method that takes in root
		if (!exprString.isEmpty()) {
			exprString = "";
		}
		
		return postfix(root);
	}

	//postfix traversal
	private String postfix(ExprNode t) {

		if (t == null) {
			return "";
		}
		postfix(t.left);
		postfix(t.right);

		//spaces are added in between here for the split operator
		if (t.left != null) 
			exprString = exprString + t.operator + " ";
		else
			exprString = exprString + t.operand + " ";
		
		return exprString;
	}

	
	public String prefix() {
		
		if (!exprString.isEmpty()) {
			exprString = "";
		}
		
		return prefix(root);
	}

	//following algorithm of prefix traversal
	private String prefix(ExprNode t) {
		
		if (t == null) 
			return "";
	
		if (t.left != null) 
			exprString = exprString + t.operator + " ";	
		else
			exprString = exprString + t.operand + " ";
		
		prefix(t.left);
		prefix(t.right);
		
		return exprString;
	}

	//infix traversal
	public String infix() {
		
		if (!exprString.isEmpty()) {
			exprString = "";
		}
		
		return infix(root);
	}

	private String infix(ExprNode t) {
		
		if (t == null)
			return "";
		
		
		if (t.left == null) 
			exprString = exprString + t.operand;
		else {
			exprString = exprString + "(";
			infix(t.left);
			exprString = exprString + " " + t.operator + " ";
			infix(t.right);
			exprString = exprString + ")";
		}
		
		return exprString;
	}
	 
}
