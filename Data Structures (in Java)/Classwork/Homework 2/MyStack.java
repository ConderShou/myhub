/**
 * @author Conder Shou
 * cs3544
 * MyStack.java
 * 
 * A stack class for SymbolBalance.java
 *
 */
import java.util.LinkedList;

public class MyStack<AnyType> {
	
	private LinkedList<AnyType> list = new LinkedList<>();
	
	public void push(AnyType elem) {
		
		list.addLast(elem);
	}
	
	public AnyType pop() {
		
		return list.removeLast();
		 
	}
	
	public boolean isEmptyStack() {
		return list.isEmpty();
	}
	
	public int theSize() {
		
		return list.size();
	}
	
	
}
