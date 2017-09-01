/* Conder Shou
 * cs3544
 * Dealer.java
 * 
 * Simulates the hand, dealing action, and shuffling action of the dealer
 */
import java.util.ArrayList;

public class Dealer {

	private int value; //value of the cards at hand
	private boolean blackjack; //if true, player receives no pay
	private ArrayList<Card> hand = new ArrayList<Card>(); //the dealer's hand
	private Deck deck = new Deck();
	private boolean bust = false;
	private int cardsReceived = 0;

	public Dealer(Deck someDeck) {

		deck = someDeck;
	}

	public Card deal() {
		
		return deck.playDeck();
	}

	//previously dealt cards are reintroduced into deck
	//   and then entire deck is reshuffled
	public void checkDeckSize() {
		
		if (deck.getSize() <= 12) 
			deck.shuffle();
	}
	
	public void shuffle() {

		deck.shuffle();
	}

	public boolean getBlackjack() {

		return blackjack;	//scenario is addressed in Game.java
	}

	public boolean getBust() {

		return bust;
	}

	public int getValue() {

		return value;
	}

	public void acceptCard(Card dealtCard) {

		cardsReceived++;

		hand.add(cardsReceived - 1, dealtCard);

		checkValue();	//calculates value of current hand
	}



	private void checkValue() {

		value = 0;

		for (Card elem : hand) {

			value += elem.getValue();
		}

		if (value == 21) 
			if (hand.get(0).getFace().equals("Ace") && hand.get(1).getValue() == 10
				|| hand.get(0).getValue() == 10 && hand.get(1).getFace().equals("Ace"))
				blackjack = true;

		if (value > 21)
			bust = true;
		else
			//for the setAceIfBust method, if changing the value of the ace
			// allowed the player to get out of being busted
			bust = false; 

	}

	//Helps Dealer choose the largest Ace value that won't bust him
	//	returns value that Dealer should assign to his Ace
	public int checkAceValue() { 

		int testValue = 0;

		for (Card elem : hand){

			testValue += elem.getValue();
		}

		//tests if adding a value of 11 will bust the dealer
		//    a value of 1 won't because the dealer would have 
		//    ended its cycle if it got blackjack already
		if ((testValue += 11) > 21) 
			return 1;
		else
			return 11;
	}

	//If the dealer draws a card and is about to get busted, it calls this 
	//   method to see if it can lower the value of an ace card
	public void setAceIfBust() {

		//checks to see if it has an ace card
		boolean foundAce = false;

		int i = 0;
		
		while(!foundAce && i < hand.size()){

			if (hand.get(i).getFace().equals("Ace") 
					&& hand.get(i).getValue() == 11 ) {

				hand.get(i).setAce(1); 
				foundAce = true;
			}
			i++;
		}
		checkValue();
	}

	public void clearHand() {

		int size = hand.size();
		for (int i = 0; i < size; i++) {
			hand.remove(0); //remove method also shifts the array
		}

		cardsReceived = 0;
		blackjack = false;
		bust = false;
	}

	public String toString() {	//toString method to display dealer's hand

		return "The Dealer's top card is a: " + hand.get(0).getFace() + " of " + hand.get(0).getSuite();
	}

	//User can choose to enable this future or not in the Game.java class
	public String showHand(boolean toggle) {

		String dispHand = "-----------My hand-----------";

		for (Card elem : hand) {

			dispHand = dispHand.concat("\n") + elem.getFace() + " of " + elem.getSuite();
			dispHand.concat("\n").concat("-------------------------------");
		}

		return dispHand;
	}
}

