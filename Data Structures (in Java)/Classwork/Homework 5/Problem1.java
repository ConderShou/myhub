/*
 * Conder Shou
 * cs3544
 * Problem1.java
 * 
 * A non-recursive (iterative) implementation of Merge Sort.
 * 		Uses Weiss's code for the merge method
 */
import java.util.Arrays;

public class Problem1 {

	/** ----Code From Weiss Textbook------
	 * Internal method that merges two sorted halves of a subarray
	 * @param a an array of Comparable items
	 * @param tmpArray an array to place the merged result
	 * @param leftPos the left-most index of the subarray
	 * @param rightPos the index of the start of the second half
	 * @param rightEnd the right-most index of the subarray
	 */
	private static <AnyType extends Comparable<? super AnyType>>
	void merge( AnyType[] a, AnyType[] tmpArray, 
			int leftPos, int rightPos, int rightEnd)
	{
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;

		//Main loop
		while( leftPos <= leftEnd && rightPos <= rightEnd )
			if( a[ leftPos ].compareTo( a[ rightPos ] ) <= 0 )
				tmpArray[ tmpPos++ ] = a[ leftPos++ ];
			else
				tmpArray[ tmpPos++ ] = a[ rightPos++ ];

		while( leftPos <= leftEnd )	//Copy rest of first half
			tmpArray[ tmpPos++ ] = a[ leftPos++ ];

		while( rightPos <= rightEnd )	//Copy rest of right half
			tmpArray[ tmpPos++ ] = a[ rightPos++ ];

		//Copy tmpArray back
		for( int i = 0; i < numElements; i++, rightEnd-- )
			a[ rightEnd ] = tmpArray[ rightEnd ];
	}

	public static void mergeSortB(Integer[] inputArray)
	{

		int leftPos = 0;
		int rightPos = 2;
		int size = 4;
		Integer[] tmpArray = new Integer[inputArray.length];
		Integer tmp;

		while (leftPos+1 < inputArray.length)
		{
			if (inputArray[leftPos] > inputArray[leftPos+1])
			{
				//Exchanging positions if the pair is unordered
				tmp = inputArray[leftPos+1];	
				inputArray[leftPos+1] = inputArray[leftPos];
				inputArray[leftPos] = tmp;
			} 

			//This condition is put within the while condition in order
			//  to allow the sorting of leftover pairs
			if (rightPos+1 < inputArray.length) 
			{
				if (inputArray[rightPos] > inputArray[rightPos+1])
				{
					tmp = inputArray[rightPos+1];
					inputArray[rightPos+1] = inputArray[rightPos];
					inputArray[rightPos] = tmp;
				} 

				//Merging two pairs at a time as we go from left to right
				merge(inputArray, tmpArray, leftPos, rightPos, rightPos+1);

				//In case there is an odd number of leftover elements
			} else if (rightPos < inputArray.length) 
				merge(inputArray, tmpArray, leftPos, 
						rightPos, inputArray.length-1);

			//Moving on to the next unordered pairs
			leftPos = leftPos + size;	
			rightPos = rightPos + size;

		}

		//Merging arrays of size 4 and above

		int rightEnd;

		while (size < inputArray.length)
		{
			rightEnd = 2*size - 1;

			if (rightEnd < inputArray.length)
			{
				merge(inputArray, tmpArray, 0, size, rightEnd);
			} else //In case there are two uneven subarrays left, merges them
			{
				merge(inputArray, tmpArray, 0, size, inputArray.length - 1);
			}

			size *= 2;
		}
	}

	public static void main(String[] args) {

		//Three elements will be leftover
		Integer[] someArray1 = {3, 5, 1, 9, 6, 2, 8, 4, 7, 0, 1};

		System.out.println("Initial First Array: "
				+ Arrays.toString(someArray1));

		mergeSortB(someArray1);

		System.out.println("Sorted First Array: " 
				+ Arrays.toString(someArray1));

		System.out.println();

		//A pair of elements will be leftover
		Integer[] someArray2 = {0, 5, 8, 3, 7, 1, 9, 4, 8, 2};

		System.out.println("Initial Second Array: "
				+ Arrays.toString(someArray2));

		mergeSortB(someArray2);

		System.out.println("Sorted Second Array: " 
				+ Arrays.toString(someArray2));
	}

}
