
public class LetterPrinter {
	
	public static void main(String[] args) {
		
		Letter goodByteNote = new Letter("Mary", "John");	//get it...Good Byte?... haha...haha...hahhhh....
		
		goodByteNote.addLine("I am sorry we must part.");
		goodByteNote.addLine("I wish you all the best.");
		
		System.out.println(goodByteNote.getText());
	}
}
