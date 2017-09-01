/*
 * Conder Shou
 * cs3544
 * Game.java
 * 
 * Utilizes the Dealer and Player class to play the game of blackjack
 */

import java.util.Scanner;

public class Game {

	private boolean gameEnded;	//controls whether or not to exit game
	private boolean playerHandEnded = false; //signifies if the player continues to bet
	private boolean dealerHandEnded = false; //signfies if dealer still needs to hit
	private Scanner in = new Scanner(System.in);
	private Player player;
	private Dealer dealer;
	private Deck deck;
	private boolean dealerTopCard = true;
	private double betSize = 9;

	//shows the dealer's hand at end of game, can be disabled if set to false
	private boolean toggleDealerHand = true; 

	//notifies the player when his hand is a hard hand
	//  also keeps track of player's aces
	private int playerAceNumber = 0;

	public void play() {

		//Entering with a buy-in
		System.out.println("Greetings. Please enter your buy-in for today"
				+ ". It should be at least $100: ");

		int buyIn = in.nextInt();

		//checks to make sure the buy-in given is at least $100
		while (buyIn < 100) {	

			System.out.println();
			System.out.println("Scuzmoi peasant, the buy-in is at least $100");
			System.out.println("Please enter your buy-in again: ");

			buyIn = in.nextInt();
		}

		player = new Player(buyIn);
		deck = new Deck();
		dealer = new Dealer(deck);

		while (!gameEnded) {

			playerBet(); //player places bet

			//the four cards are dealt 
			playerHitting("Y");	
			dealerHitting();
			playerHitting("Y");
			dealerHitting();

			playerTurn();
			dealerTurn();

			winOrLose();

			//checks if the deck size is at 12 cards or less, IF SO:
			//  introduces previously dealt cards
			//  and reshuffles them
			dealer.checkDeckSize(); 
		}
	}

	private void playerTurn() {

		while (!playerHandEnded) {

			System.out.println();
			System.out.println("U wanna hit it? Y/N: ");
			String hitItOrNot = in.next().toUpperCase();

			playerHitting(hitItOrNot);
		}
	}

	private void dealerTurn() {

		while (!dealerHandEnded) {

			dealerHitting();
		}
	}

	private void dealerHitting() {

		Card tempCard = dealer.deal();

		if (tempCard.getFace().equals("Ace")) {

			int cardValue = dealer.checkAceValue();
			tempCard.setAce(cardValue);
		}

		dealer.acceptCard(tempCard);

		if (dealerTopCard) {

			System.out.println();
			System.out.println(dealer.toString());
			dealerTopCard = false;
		}

		//Allows dealer to see if it can lower the value of an ace card
		//  in its hand to get out of being busted
		if (dealer.getBust())
			dealer.setAceIfBust();


		if (dealer.getBust()) {

			dealerHandEnded = true;
		}


		//checks if the dealer has blackjack
		if (dealer.getBlackjack()) {

			dealerHandEnded  = true; 
		}

		if (dealer.getValue() >= 17)
			dealerHandEnded = true;

	} 



	private void playerHitting(String hitItOrNot) {

		if (hitItOrNot.equals("Y")) {

			Card tempCard = dealer.deal();

			System.out.println();
			System.out.println("You received a: " + tempCard.getFace() + " of "
					+ tempCard.getSuite());


			//Asks player what he would like to do with an ace
			if (tempCard.getFace().equals("Ace")) {

				playerAceNumber++;
				int cardValue;
				do {

					System.out.println();
					System.out.println("Would you like it to be worth 1 or 11?");
					cardValue = in.nextInt();
				} while (cardValue != 1 && cardValue != 11);

				tempCard.setAce(cardValue);
			}

			player.acceptCard(tempCard);

			System.out.println(player.toString());

			if (player.getBust()) {

				//ADD IN ABILITY to search for ace before declaring to lower the value of one
				System.out.println();
				System.out.println("Now checking to see if you can lower the value"
						+ " of an ace card to get yourself out of this mess");
			}

			//Allows player to see if he/she can lower the value of an ace card
			//  in his/her hand to get out of being busted
			boolean	foundAce = false;
			if (player.getBust())
				foundAce = player.setAceIfBust();

			// by this time, the entire hand has been scanned
			//   checks if the player is still busted after 
			//   scanning the last card
			if (player.getBust()) {	

				System.out.println();
				System.out.println("Nope, sorry man... you're screwed");
			} 


			if (foundAce == true && !player.getBust()) {
				System.out.println();
				System.out.println("Ace lowered. ");
				playerAceNumber--;

				if (playerAceNumber == 0)
					System.out.println("Your soft hand is now a hard hand");

			}

			if (player.getBust()) {

				System.out.println();
				System.out.println("YOU BUSTED BUSTER");

				playerHandEnded = true;
				dealerHandEnded = true;
			} 


			//checks if the player has blackjack
			if (player.getBlackjack()) {

				System.out.println();
				System.out.println("Blackjack...now let's see how I do yeah?");
				playerHandEnded  = true; //now we check the dealer for a push
			}
		} else { // player decided to stand

			System.out.println("You decide to stand.");
			playerHandEnded = true; //outcome of bet is determined after dealer turn
		}
	}

	private void winOrLose() {

		System.out.println();
		System.out.println(dealer.showHand(toggleDealerHand));
		System.out.println();

		if (dealer.getBlackjack())
			System.out.println("Btw I have blackjack ;) ");

		if (dealer.getBlackjack() && player.getBlackjack() 
				|| !dealer.getBust() && !player.getBust()
				&& dealer.getValue() == player.getValue()) {

			System.out.println();
			System.out.println("Seems like we're tied. "
					+ "Oh well, next hand it is then.");

		} else if (dealer.getBlackjack() && !player.getBlackjack() 
				|| !dealer.getBust() && (dealer.getValue() > player.getValue()) 
				|| player.getBust()) {

			System.out.println();
			System.out.println("WOOHOOO... I, the Dealer, WONNNN");

			//player immediately loses bet
			// also checks for bankruptcy
			if (!player.updateBet(false)) { 

				System.out.println();
				System.out.println("You have: $" + player.getBuyInMoney());
				System.out.println("THAT WAS TOO EASY. GAME OVERRRRRRRR.");
				gameEnded = true;
			} 

		} else if (!dealer.getBlackjack() && player.getBlackjack() 
				|| !player.getBust() && !dealer.getBust() 
				&& (dealer.getValue() < player.getValue())
				|| !player.getBust() && dealer.getBust()){

			System.out.println();
			System.out.println("Wow screw you... Fine, take my money >.> ");
			player.updateBet(true);
		}

		if (!gameEnded) {

			System.out.println();
			System.out.println("You have: $" + player.getBuyInMoney());

			gameEnded = playAnother();
		}

	}

	private boolean playAnother() {

		System.out.println();
		System.out.println("Would you like to play another hand? Y/N  ");

		String yesOrNo = in.next().toUpperCase();

		//checks if player has enough money for another hand, taking into
		//  consideration the current minimum bet required
		if (!player.bet(betSize)) { 

			System.out.println("You don't have enough for another hand."
					+ " Sorry mate.");
			return true;

		} else if (yesOrNo.equals("Y")) {

			player.clearHand();
			dealer.clearHand();
			playerHandEnded = false;
			dealerHandEnded = false;
			dealerTopCard = true;
			playerAceNumber = 0;

			return false;	//game does not end

		} else {

			System.out.println("Alright, see you later ol' chap");
			return true;	//game ends
		}
	}

	private void playerBet() {

		//Incrementing bet size
		betSize++;

		double bet;

		//Placing a bet
		do{

			System.out.println();
			System.out.println("Enter your bet, it must be at least "
					+ betSize + " and at most 1000: ");
			bet = in.nextDouble();
		} while (bet < betSize || bet > 1000);

		//checks to make sure the buy-in given is at least $100
		while (!player.bet(bet)) {	

			System.out.println();
			System.out.println("Sir, shall I give you the boot?");
			System.out.println("You don't have enough for that bet");
			System.out.println();
			System.out.println("If your small brain is up to it, try again: ");

			bet = in.nextInt();
		}
		player.bet(bet);

	}
}
