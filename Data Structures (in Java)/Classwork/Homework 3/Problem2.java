import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

/*
 * Conder Shou
 * cs3544
 * Problem2.java
 * 
 * Goes through a text file line by line and inserts the
 *		word and line number into an AVL tree
 */
public class Problem2 {

	public static void main(String[] args) throws IOException {

		LineNumberReader lineRead = new LineNumberReader(new FileReader(args[0]));
		String line;
		AvlTree tree = new AvlTree();
		String word;

		line = lineRead.readLine();
		String[] arrayLine;

		while (line != null) {

			while (line != null && line.equals("")) {
				line = lineRead.readLine();	// skips empty lines
			}

			if (line != null) {

				//remove punctuation
				line = line.replaceAll("\\p{Punct}+", "");
				
				//remove the more special characters
				line = line.replaceAll("[^\\p{ASCII}]", "");
				
				line = line.toLowerCase();
				arrayLine = line.split(" ");

				//indexing each word and its line number
				for (int i = 0; i < arrayLine.length; i++) {

					word = arrayLine[i];
					
					//removes any remaining spaces
					word.replaceAll(" ", "");	
					
					//an extra check to ignore empty strings
					if (!word.equals("")) 
						tree.indexWord(word, lineRead.getLineNumber());
				}

				line = lineRead.readLine();
			}
		}

		tree.printIndex();
	}
}






