/*
 * Conder Shou
 * cs3544
 * SpellChecker.java
 * 
 * Checks the spelling of an input text file based on the 
 * 		accompanying dictionary file
 */

import java.util.HashSet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;
import java.util.ArrayList;

public class SpellChecker {

	private final static String[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".split("");

	//Table size is set large in anticipation of a long dictionary file
	private static int tableSize = 1000000; 
	private static HashSet<String> dictionary = new HashSet<>(tableSize);

	//Contains suggested valid words, prevents duplicates
	private static ArrayList<String> validWords = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		//Populating the hash table with the dictionary file

		Scanner in = new Scanner(new BufferedReader( 
				new FileReader(args[0])));

		String str;

		while (in.hasNext()) {

			str = in.next();
			str = str.toLowerCase().replaceFirst("^[^a-zA-Z]+", "")
					.replaceAll("[^a-zA-Z]+$", "")
					.replaceAll("([a-z]+)[?:!.,;]*", "$1");
			dictionary.add(str);
		}
		in.close();


		//Reading test file and keeping track of line numbers

		LineNumberReader lineRead = new LineNumberReader
				(new FileReader(args[1]));

		str = lineRead.readLine();
		String[] arrayLine;

		while (str != null) {

			if (str != null) {

				//remove leading and trailing punctuation
				// as well as converting everything into lower case
				str = str.toLowerCase().replaceFirst("^[^a-zA-Z]+", "")
						.replaceAll("[^a-zA-Z]+$", "")
						.replaceAll("([a-z]+)[?:!.,;]*", "$1");

				arrayLine = str.split(" ");

				for (String word : arrayLine) {

					if (!dictionary.contains(word)) {

						System.out.println();
						System.out.println("Word misspelled at line "
								+ lineRead.getLineNumber() + ": "
								+ word);

						suggestWords(word);

						if (validWords.isEmpty())
							System.out.println("No suggested valid words "
									+ "were found");

						//Clearing arraylist so that other misspelled
						//  words can still be given a suggested valid word
						//  that was given to a previous misspelled word
						//  (not a duplicate in this case)
						validWords.clear();
					}
				}
				str = lineRead.readLine();
			}
		}
		lineRead.close();
	}

	private static void suggestWords(String word) {
		
		for (int i = 0; i < word.length(); i++) {

			//Adding a character:
			//  Attempting to find a valid word by adding
			//  a character from "a" to "z"

			String addWord;

			for (String letter : ALPHABET) {

				// this doesn't add a letter to the end,
				//     so we do it later separately
				addWord = word.substring(0, i)
						.concat(letter) + word.substring(i);	

				checkDictionary(addWord);
			}

			// Adding a letter to the end
			if (i == word.length() - 1) {

				for (String letter : ALPHABET) {

					addWord = word.concat(letter);
					checkDictionary(addWord);
				}
			}

			//Removing a character:
			//	Attempting to find a valid word by removing
			//  a character anywhere in the word

			String removeWord = word.substring(0, i) + word.substring(i+1);
			checkDictionary(removeWord);

			//Exchanging adjacent characters:
			//  Attempting to find a valid word by swapping
			//  adjacent characters anywhere in the word

			if ( i < word.length() - 1) {

				String swapWord = word.substring(0, i)
						+ word.charAt(i + 1)
						+ word.charAt(i)
						+ word.substring(i + 2);
				checkDictionary(swapWord);
			}

		}
	}

	private static void checkDictionary(String word) {

		//Checking if word is in dictionary AND if it's a DUPLICATE
		if (dictionary.contains(word) && !validWords.contains(word)) {

			if (validWords.isEmpty())
			System.out.println("Suggested valid words: ");

			validWords.add(word);
			
			System.out.println(word);
			
		}
	}
}


