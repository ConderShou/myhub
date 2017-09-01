/*
 * Conder Shou
 * cs3544
 * Intro to Java
 * 
 * WordLists.java
 * 
 * Generates useful word lists for scrabble players using the included
 *   dictionary file
 */
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class WordLists {

	private Scanner in;
	private ArrayList<String> dictionary = new ArrayList<>();

	//Transfers dictionary to an ArrayList 
	public WordLists(String fileName) throws FileNotFoundException
	{
		in = new Scanner(new BufferedReader( 
				new FileReader(fileName)));;

				while (in.hasNext())
				{
					dictionary.add(in.next());
				}
	}

	//Returns an array of words of length n
	public String[] lengthN(int n)
	{	
		ArrayList<String> tempList = new ArrayList<>();

		//Enhanced for loop to traverse through dictionary file
		for (String word : dictionary)
		{
			//Checking for the proper word length
			if (word.length() == n)
				tempList.add(word);
		}

		//Creating a new array to contain the tempList arraylist
		String[] array = new String[tempList.size()];

		for (int i = 0; i < array.length; i++)
			array[i] = tempList.get(i);

		return array;
	}

	//Returns an array of words of length n
	//  beginning with the letter firstletter
	public String[] startsWith(int n, char firstLetter)
	{
		ArrayList<String> tempList = new ArrayList<>();

		for (String word : dictionary)
		{
			//Splitting word into its individual characters
			String[] wordArray = word.split("");
			String letter = Character.toString(firstLetter);
			
			//Checking if the first letter is the desired letter
			if (wordArray[0].equals(letter)
					&& word.length() == n)
				tempList.add(word);
		}

		String[] array = new String[tempList.size()];

		for (int i = 0; i < array.length; i++)
			array[i] = tempList.get(i);

		return array;
	}
	
	//Returns an array of words of length n containing the letter included
	//   but not beginning with it
	public String[] containsLetter(int n, char included)
	{
		ArrayList<String> tempList = new ArrayList<>();
		boolean hasVowel = false;
		
		for (String word : dictionary)
		{
			String[] wordArray = word.split("");
			String letter = Character.toString(included);
			
			//Going through the word in all positions except beginning
			//   to find if it has the desired letter
			for (int i = 1; i < wordArray.length; i++)
			{
				String elem = wordArray[i];
				
				if (elem.equals(letter))
					hasVowel = true;
			}
			
			if (hasVowel && word.length() == n)
				tempList.add(word);
			
			//Reset hasVowel for the next word
			hasVowel = false;
		}

		String[] array = new String[tempList.size()];

		for (int i = 0; i < array.length; i++)
			array[i] = tempList.get(i);

		return array;
	}
	
	//Returns an array of words of length n containing at least m vowels
	public String[] vowelHeavy(int n, int m)
	{
		ArrayList<String> tempList = new ArrayList<>();
		int numOfVowels = 0;
		
		for (String word : dictionary)
		{
			String[] wordArray = word.split("");
			
			for (int i = 0; i < wordArray.length; i++)
			{
				String elem = wordArray[i];
	
				//Increments the counter for the number of vowels when
				// a vowel is found in the word
				if (elem.equals("a") || elem.equals("e") || elem.equals("i")
						|| elem.equals("o") || elem.equals("u"))
					numOfVowels++;
			}
			
			if (numOfVowels >= m && word.length() == n)
				tempList.add(word);
			
			//Resets numOfVowels for the next word
			numOfVowels = 0;
		}

		String[] array = new String[tempList.size()];

		for (int i = 0; i < array.length; i++)
			array[i] = tempList.get(i);

		return array;
	}
	
	//Returns an array of words with at least m occurrences
	//  of the letter included
	public String[] multiLetter(int m, char included)
	{
		ArrayList<String> tempList = new ArrayList<>();
		String letter = Character.toString(included);
		int numOfLetter = 0;
		
		for (String word : dictionary)
		{
			String[] wordArray = word.split("");
			
			for (int i = 0; i < wordArray.length; i++)
			{
				String elem = wordArray[i];
	
				//Increments the counter for the number of vowels when
				// a vowel is found in the word
				if (elem.equals(letter))
					numOfLetter++;
			}
			
			if (numOfLetter >= m)
				tempList.add(word);
			
			//Resets numOfVowels for the next word
			numOfLetter = 0;
		}

		String[] array = new String[tempList.size()];

		for (int i = 0; i < array.length; i++)
			array[i] = tempList.get(i);

		return array;
	}
	
}
