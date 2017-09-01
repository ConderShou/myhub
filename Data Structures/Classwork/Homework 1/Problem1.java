
public class Problem1 {
	
	
	public static <AnyType extends Comparable<AnyType>>  AnyType findMax(AnyType[] arr) {
		  int maxIndex = 0;
		  for (int i = 1; i < arr.length; i++)
		    if ( arr[i].compareTo(arr[maxIndex]) > 0 )
		       maxIndex = i;
		    return arr[maxIndex];
		}
	
	public static void main(String[] args) {
		Rectangle[] r = {
				new Rectangle(14,20),
				new Rectangle(10,24),
				new Rectangle(19,15),
				new Rectangle(11,22),
				new Rectangle(27,8)		
				};
		
		Rectangle largestIndex;
		
		largestIndex = findMax(r);
		
		System.out.println("The rectangle largest in perimeter has width " + largestIndex.getWidth() +
									" and length " +largestIndex.getLength());
	}

}
