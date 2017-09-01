import java.util.Scanner;

public class E64 {

	public static void main(String[] args) {

		//part a: Print only the uppercase letters in the string

		Scanner inA = new Scanner(System.in);

		System.out.println("a. Please enter a string for only its uppercase letters to be printed: ");
		String userStringA = inA.nextLine();

		System.out.print("The uppercase letters in this string are: ");
		for(int i = 0; i < userStringA.length(); i++) {

			char letter = userStringA.charAt(i);

			if (Character.isUpperCase(letter)) {
				System.out.print(letter);
			}
		}
		System.out.println();

		// part b: Print every second letter of the string

		Scanner inB = new Scanner(System.in);
		System.out.println("b. Please enter another string for every second letter to be printed: ");
		String userStringB = inB.nextLine();

		//String bodyB = "";

		System.out.print("Every second letter in this string is: ");
		for(int i = 1; i < userStringB.length(); i+=2) {
			System.out.print(userStringB.charAt(i));
		}
		System.out.println();

		// part c: Print the string with all vowels replaced by an underscore

		Scanner inC = new Scanner(System.in);
		System.out.println("c. Please enter another string for its vowels to be replaced: ");
		String userStringC = inC.nextLine();
		String bodyC = "";

		for (int i = 0; i < userStringC.length(); i++) {

			String letterC = userStringC.substring(i, i+1);

			if (letterC.equals("a") || letterC.equals("e") || letterC.equals("i") ||
					letterC.equals("o") || letterC.equals("u") || letterC.equals("A") ||
					letterC.equals("E") || letterC.equals("I") || letterC.equals("O") || letterC.equals("U")){
				letterC = "_";
			}
			bodyC = bodyC.concat(letterC);
		}
		System.out.println("The modified string is: " + bodyC);

		// part d: Prints the number of vowels in the string

		Scanner inD = new Scanner(System.in);
		System.out.println("d. Please enter a string for its vowels to be counted: ");
		String userStringD = inD.nextLine();

		int vowelCounter = 0;

		for (int i = 0; i < userStringD.length(); i++) {
			String letterD = userStringD.substring(i, i+1);		// this gives only the specified letter at the position i in the string array

			if (letterD.equals("a") || letterD.equals("e") || letterD.equals("i") ||
					letterD.equals("o") || letterD.equals("u") || letterD.equals("A") ||
					letterD.equals("E") || letterD.equals("I") || letterD.equals("O") || letterD.equals("U")){
				vowelCounter++;
			}
		}
		System.out.println("The number of vowels in this string is: " + vowelCounter);

		// part e: Prints the positions of all vowels in the string

		Scanner inE = new Scanner(System.in);
		System.out.println("e. Please enter a string for the positions of all its vowels to be printed: ");
		String userStringE = inE.nextLine();

		System.out.println("The position of the vowels are: ");

		for (int i = 0; i < userStringE.length(); i++) {
			
			String letterE = userStringE.substring(i, i+1);
			
			if (letterE.equals("a") || letterE.equals("e") || letterE.equals("i") ||
					letterE.equals("o") || letterE.equals("u") || letterE.equals("A") ||
					letterE.equals("E") || letterE.equals("I") || letterE.equals("O") || letterE.equals("U")){
				System.out.print(i + " ");
			}
		}
	}
}