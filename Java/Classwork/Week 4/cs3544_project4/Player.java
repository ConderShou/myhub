/*
 * Conder Shou
 * cs3544
 * Player.java
 * 
 * Simulates the hand, money, and betting action of the player
 */
import java.util.ArrayList;

public class Player {

	private ArrayList<Card> hand = new ArrayList<Card>(); 
	private double balance;
	private double bet;
	private int cardsReceived = 0;
	private boolean blackjack;
	private int value;	//total value of hands
	private boolean bust = false; //value of hands exceeds 21

	public Player(int buyIn) {

		balance = buyIn;
	}

	public void acceptCard(Card dealtCard) {

		cardsReceived++;

		hand.add(cardsReceived - 1, dealtCard);

		checkValue();
	}

	public String toString() {

		String dispHand = "-----------Your hand-----------";

		for (Card elem : hand) {

			dispHand = dispHand.concat("\n") + elem.getFace() + " of " + elem.getSuite();
			dispHand.concat("\n").concat("-------------------------------");
		}

		return dispHand;
	}

	public boolean bet(double betMoney) {

		if (balance >= betMoney) {
			bet = betMoney;
			return true; //player is able to bet this much
		} else 
			return false; //player cant bet this much
	}

	//winOrLose is true if bet was won, false if bet was lost
	public boolean updateBet(boolean winOrLose) {	

		if (winOrLose)
			balance = balance + bet + bet/2;
		else
			balance = balance - bet;

		if (balance == 0)	//checks if player is bankrupt yet
			return false;
		else
			return true;

	}

	public double getBuyInMoney() {

		return balance;
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

	public boolean setAceIfBust() {

		//checks to see if it has an ace card
		boolean foundAce = false;

		int i = 0;
		
		while(!foundAce && i < hand.size()){

			if (hand.get(i).getFace().equals("Ace") 
					&& hand.get(i).getValue() == 11 ) {

				hand.get(i).setAce(1); 
				foundAce = true;
			}
			
			if (foundAce == true){

				checkValue();
				return true;
			}
			i++;
		}
		checkValue();
		return false;
	}

	public void clearHand() {

		int size = hand.size();
		for (int i = 0; i < size; i++) {

			hand.remove(0); //the remove method also shifts the array
		}

		cardsReceived = 0;
		blackjack = false;
		bust = false;
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
}
