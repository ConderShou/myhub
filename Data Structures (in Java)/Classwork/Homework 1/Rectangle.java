public class Rectangle implements Comparable<Rectangle>{
	private int Rectlength;
	private int Rectwidth;
	private int perimeter;
	
	public Rectangle(int Rectlength, int Rectwidth)
	{
		this.Rectlength = Rectlength;
		this.Rectwidth = Rectwidth;
		this.perimeter = 2*Rectlength + 2*Rectwidth;
	}
	public int getLength() {
		return Rectlength;
	}
	
	public int getWidth() {
		return Rectwidth;
	}
	
	public int compareTo(Rectangle other){
		if (this.perimeter > other.perimeter){
			return 1;
		}
		else if (this.perimeter < other.perimeter) {
			return -1;
		}
		else 
			return 0;
		}
	
	public int getPerim(){
		return perimeter;
	}
}
