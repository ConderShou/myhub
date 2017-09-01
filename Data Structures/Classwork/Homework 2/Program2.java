/*
 * Conder Shou
 * cs3544
 * Program2.java
 * 
 * Tests TwoStackQueue.java to see if it enqueue, dequeue, and printing the dequeue correctly
 */
public class Program2 {

	/*
	 * Correct output should be:
	 *
	 * 0
	 * 5
	 * 4
	 * 12
	 * 2345
	 * 4
	 * 213
	 * 32
	 * 92
	 * 34
	 */
	public static void main(String[] args) {
		
		TwoStackQueue<Integer> prog = new TwoStackQueue<>();
		
		System.out.println(prog.size());
		
		prog.enqueue(5);
		prog.enqueue(12);
		System.out.println(prog.dequeue());
		prog.enqueue(2345);
		prog.enqueue(213);
		prog.enqueue(32);
		System.out.println(prog.size());
		prog.enqueue(92);
		System.out.println(prog.dequeue());
		prog.enqueue(34);
		System.out.println(prog.dequeue());
		System.out.println(prog.size());
		
		while(!prog.isEmpty()){
		    System.out.println(prog.dequeue());
		}

	    }


	}


