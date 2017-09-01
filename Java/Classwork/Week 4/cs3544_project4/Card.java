/*
 * Conder Shou
 * cs3544
 * Card.java
 * 
 * Contains the properties of each individual card and their properties
 */

public class Card {

	private int value;
	private String suite;
	private String face;


	public Card(int number, String suite ) {

		matchFace(number);
		this.suite = suite;
	}

	// Determining if the card is a face card and assigning it its 
	//    corresponding properties
	private void matchFace(int number) {

		if (number >= 1 && number <= 10) {
			value = number;

			if (number == 1) 
				face = "Ace";
			else
				face = Integer.toString(number);

		} else {
			value = 10;

			switch (number) {
			case 11: face = "Jack"; break;
			case 12: face = "Queen"; break;
			case 13: face = "King"; break;
			}
		}
	}

	public void setAce(int aceValue) {

		value = aceValue;
	}

	public int getValue() {

		return value;
	}

	public String getSuite() {

		return suite;
	}

	public String getFace() {

		return face;
	}
}


