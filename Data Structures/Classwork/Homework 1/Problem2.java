import java.util.Arrays;

public class Problem2 {

	public static <AnyType extends Comparable<AnyType>> 
	int binarySearch(AnyType[] a, AnyType x) {
		
		int left = 0;
		int right = a.length-1;
		
		
		while (left <= right) {
			
			int mid = (left + right)/2;
			
			 if(a[mid].compareTo(x) < 0) {
				    AnyType[] tempArr = Arrays.copyOfRange(a, mid + 1, a.length);
				    int index = binarySearch(tempArr, x);
				    
				    if(index != -1){
				      index = mid + 1 + index;
				      return index;
				    }
			 }
				  else if(a[mid].compareTo(x) > 0) {
				    AnyType[] tempArr2 = Arrays.copyOfRange(a, 0, mid); 
				    return binarySearch(tempArr2, x);
				  }
				  else {
				    return mid;
				  }
			 
	}
		return -1;
}
	
		
	public static void main(String[] args) {
		Rectangle[] r = {
				new Rectangle(14,20),
				new Rectangle(10,24),
				new Rectangle(19,15),
				new Rectangle(11,22),
				new Rectangle(27,8)		
				};
		
		Rectangle FindPerim = new Rectangle(15, 19);
		Arrays.sort(r);
		int MatchedPerimeterPos = binarySearch(r, FindPerim);	// Searching a rectangle with a perimeter of FindValue
		
		if (0 <= MatchedPerimeterPos){
			System.out.println("A rectangle with perimeter " + FindPerim.getPerim() + " has been located at position " + MatchedPerimeterPos);
		} else {
			System.out.println("No match found.");
		}
	}

}
