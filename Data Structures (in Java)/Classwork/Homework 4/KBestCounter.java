/*
 * Conder Shou
 * cs3544
 * KBestCounter.java
 * 
 * Keeps track of the k-largest elements seen so far in a set of data
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KBestCounter<T extends Comparable<? super T>> {

	PriorityQueue<T> heap;
	int k;

	public KBestCounter(int k) {
		
		this.k = k;
		heap = new PriorityQueue<>(k);	
	}

	public void count(T x) {

		if (heap.size() < k )
			heap.add(x);
		
		//if inputted value is larger than the root of the heap, 
		// replace the root
		else if (heap.peek().compareTo(x) < 0) {
			heap.poll();
			heap.add(x);
		}
	}

	public List<T> kbest() {

		List<T> sortedList = new ArrayList<>(k);
		
		int sizeOfHeap = heap.size() - 1;
		
		for (int i = sizeOfHeap; i >= 0 ; i--)
			sortedList.add(heap.poll());
		
		//re-ordering the list to sort it in decreasing order,
		//  from largest to smallest
		for (int i = sizeOfHeap; i >= 0 ; i--) {
			sortedList.add(sortedList.get(i));
			sortedList.remove(i);
		}
		
		//re-inserting the elements back into the heap to restore it to
		//   its original functionality
		for (int i = 0; i < sortedList.size(); i++)
			heap.add(sortedList.get(i));
		
		return sortedList;
	}

}
