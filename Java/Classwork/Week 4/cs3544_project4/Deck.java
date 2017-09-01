/*
 * Conder Shou
 * cs3544
 * Deck.java
 * 
 * Contains a random array of 52 card objects, one of each type
 */
public class Deck {

	private Card[] deckArr = new Card[52];
	private int size;
	private String[] suite = {"Spades", "Clubs", "Hearts", "Diamonds"};

	public Deck() {

		createDeck();
	}

	 // Shuffles the deck randomly
	 // Randomly inserts one card from one part of the deck to another 
	public void shuffle() {

		Card tempCard;
		int randPos;

		// The used cards are reintroduced into the deck for the entire deck
		//     to then be reshuffled
		size = 52;

		for (int i = size - 1; i >= 0; i--) {

			//randomly selects a position from the unshuffled cards
			randPos = (int) (Math.random() * (i+1)); 

			tempCard = deckArr[i];
			deckArr[i] = deckArr[randPos];
			deckArr[randPos] = tempCard;
		}
	}


	private void createDeck() {

		int deckCount = 0; // keeps track of position in the deck array

		for (int suiteName = 0; suiteName < 4; suiteName++) {	// keeps track of suites
			for (int value = 1; value < 14; value++) {	//tracks card number

				deckArr[deckCount] = new Card(value, suite[suiteName]);
				deckCount++;
			}
		}

		size = deckArr.length;

		shuffle();
	}

	public Card playDeck() {

		// first decrements size for an appropriate array position
		//   then returns the card at the top of the deck
		return deckArr[--size]; 

	}
	
	public int getSize() {
		
		return size;
	}

}
