/*
 * Conder Shou
 * cs3544
 * Intro to Java
 * 
 * WordListsTester.java
 * 
 * Tests each of the methods in WordLists.java and writes
 * 	the wordlists to text files
 */
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class WordListsTester {

	public static void main(String[] args) {

		//A try-with-resources statement to close PrintWriter if an exception
		//   arises
		try (PrintWriter lengthNOut = new PrintWriter("lengthN.txt");
				PrintWriter startsWithOut  = new PrintWriter("startsWith.txt");
				PrintWriter containsLetterOut
					= new PrintWriter("containsLetter.txt");
				PrintWriter vowelHeavyOut
				= new PrintWriter("vowelHeavy.txt");
				PrintWriter multiLetterOut
				= new PrintWriter("multiLetter.txt"))
		{
			WordLists list = new WordLists("dictionary.txt");
			
			lengthNOut.println(Arrays.toString(list.lengthN(5)));
			startsWithOut.println(Arrays.toString(list.startsWith(5, 'a')));
			containsLetterOut.println(Arrays.toString(list.containsLetter(6, 'l')));
			vowelHeavyOut.println(Arrays.toString(list.vowelHeavy(7, 2)));
			multiLetterOut.println(Arrays.toString(list.multiLetter(2, 't')));
			
		} catch (FileNotFoundException e) {
			
			System.out.println("We cannot find this file.");

		}
		
		
	}

}
