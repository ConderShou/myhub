/*
 * It should be noted that in an attempt for greater accuracy in the results, I found the average for 30 trials of each fragment,
 * 		this has, as a result, significantly slowed the program because of the Tread.sleep() function being repeated 30 times. 
 * 
 * Thus, it has been noted that in the future, a better plan should be implemented to conduct such trial runs.
 * 
 * Nonetheless, choosing to do this has also given much clearer results, and a much more reliable trend.  			
 */

public class Problem3 {

	public static void fragmentA(int n) {

		long timespan[] = new long[30];							// Creating an array to run 30 trials

		// timing fragment A
		
		for(int it = 0; it<=timespan.length-1; it++) {			
			long starTime = System.nanoTime();
			int sum = 0;
			for ( int i = 0; i < 23; i ++) {
			} for ( int j = 0; j < n ; j ++){
				sum = sum + 1;
			}
			long endTime = System.nanoTime();
			timespan[it] = (endTime - starTime);
		}
		long average = 0;
		
		// Calculates average of the timespan
		
		for (int s = 0; s <= timespan.length-1; s++) {			
			average = timespan[s]+average;
		}
		average = average/timespan.length;
		System.out.println("Average time for fragment A: "+ average + " nanoseconds");
	}

	public static void fragmentB(int n ) {

		long timespan[] = new long[30];

		// timing fragment B
		
		for(int it = 0; it<=timespan.length-1; it++) {
			long starTime = System.nanoTime();
			int sum = 0;
			for ( int i = 0; i < n ; i ++)
				for ( int k = i ; k < n ; k ++)
					sum = sum + 1;
			long endTime = System.nanoTime();
			timespan[it] = (endTime - starTime);
		}
		long average = 0;

		for (int s = 0; s <= timespan.length-1; s++) {
			average = timespan[s]+average;
		}
		average = average/timespan.length;
		System.out.println("Average time for fragment B: "+ average + " nanoseconds");
	}

	public static int foo(int n, int k) {

		try { 
			Thread.sleep(100);			// slowing down the method in order to get usable results
		}
		catch(Exception e) {
			System.out.println(e); 
		}

		if(n<=k)
			return 1;
		else
			return foo(n/k,k) + 1;
	}

	public static void main(String[] args) {

		long timespanC[] = new long[30];
		System.out.println("The printed running times of these fragments are an average of " + timespanC.length + " trial runs.");
		System.out.println("------------------------------------------------------------");
		System.out.println();
		
		// running and timing the fragments three times with different values of n
		int[] n = {10, 20, 40, 80};

		for ( int i = 0; i<=3; i++){
			System.out.println("Running time with an n value of " + n[i]);
			System.out.println();
			fragmentA(n[i]);
			fragmentB(n[i]);



			/* 
			 * the time counters are brought out of the body of the method for fragment C because 
			 * 	the return statements make it more difficult for the method itself
			 * 	to measure and print its running time 
			 */
			
			int k = 2;
			System.out.println("The k value for fragment C is: " + k);		// during testing, k was always set to 2

			
			
			// timing fragment C
			
			for(int it = 0; it<=timespanC.length-1; it++) {
				long starTime = System.nanoTime();		
				foo(n[i], k);
				long endTime = System.nanoTime();
				timespanC[it] = (endTime - starTime);
			}
			
			long average = 0;
			
			for (int s = 0; s <= timespanC.length-1; s++) {
				average = timespanC[s]+average;
			}
			average = average/timespanC.length;
			System.out.println("Average time for fragment C: "+ average + " nanoseconds");
			System.out.println("------------------------------------------");
			System.out.println();
		}
	}
}


