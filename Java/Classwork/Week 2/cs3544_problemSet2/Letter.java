/**
 * Creates a Letter class that prints a custom letter 
 * @author Conder Shou
 *
 */
public class Letter {
	
	private String from;
	private String to;
	private String body;
	
	public Letter(String from, String to) {
		this.from = from;
		this.to = to;
		body = ("Dear " + to + ":" + "\n" + "\n");
	}
	
	/**
	 * Adds a custom line to the letter 
	 * @param line line of words to be added
	 */
	
	public void addLine(String line) {
		body = body.concat(line).concat("\n");
	}
	
	/**
	 * Returns the whole letter
	 * @return returns the whole body of the letter
	 */
	public String getText() {
		
		body = body.concat("\n").concat("Sincerely,").concat("\n").concat("\n").concat(from);
		return body;
		
	}
	
}
