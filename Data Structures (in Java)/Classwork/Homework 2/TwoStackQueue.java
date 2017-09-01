/*
 * Conder Shou
 * cs3544
 * TwoStackQueue.java
 * 
 * A queue made of out of two completely separate stacks S1 and S2
 */
public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {

	private MyStack<AnyType> s1 = new MyStack<>();
	private MyStack<AnyType> s2 = new MyStack<>();
	
	public void enqueue(AnyType elem) {
		
		s1.push(elem);
	}
	
	public AnyType dequeue() {
		
		// The elements at the end of s2 are now the first ones inputed by s2
		if (s2.isEmptyStack()) {
		while (!s1.isEmptyStack()){
				s2.push(s1.pop());	
			}
		}
		
		if (s2.isEmptyStack()) {
			return null;
		} else {
			 return s2.pop();
		}
	}
	
	public boolean isEmpty() {
	
		return (s2.isEmptyStack() && s1.isEmptyStack());
	}
	
	public int size() {
		
		return (s2.theSize() + s1.theSize());	// using theSize() method created in MyStack.java
	}
}
