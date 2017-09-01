Conder Shou
cs3544
Intro to CS: Java


--------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------
				Programming Project 4: Blackjack
--------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------



--------------------------------------------------------------------------------------------------------------------------------------------
INSTRUCTIONS ON HOW TO USE THE PROGRAM
--------------------------------------------------------------------------------------------------------------------------------------------

Run Tester.java, or create one of your own that instantiates a Game.java class and runs its .play() method.

When the game starts, it will prompt the user for a buy-in. This amount should be at least $100.

Afterwards, the game will prompt the user to enter a bet that's at least $10, but at most, $1000.

Then the four cards are dealt, the player receives his/her first two cards, and the dealer receives its 
first two cards. 

The dealer's first card, or top card, is then displayed for the player.

Now, the program will prompt the user to choose whether to hit or not.

If the player enters "Y", then the program will give the player another card.
If the player enters "N", then the program lets the player stand.

If the player gets an "Ace" anytime a card is being dealt, the program will prompt the player to choose whether
to consider with the value "11" or "1". 

If the player chooses 11, and then later, he/she receives a card that would
bust their hand, the program will look through the player's hand to check for any aces, and LOWER the value
of any aces that are set to the value 11 IN AN ATTEMPT to rescue the player from being busted.
	This is done because it is assumed that the player would want to do this for themselves, and lower the
	value of an "Ace" card to avoid being busted.

	Once all the Aces in the player's hand have been lowered, the program will notify the player that they 
	have a "hard" hand now, a hand whose value cannot change ("hard hand" is blackjack terminology). 

Once the player decides to stand, or if they get busted, or if they have blackjack (the program assumes that 
	the player would not want to continue hitting once they receive blackjack), the program moves on
	to the dealer's turn.

During the dealer's turn they will continue hitting until they reach 17 or above, in which they will always choose
to stand.
	
They will also automatically set the value of the Ace card to whichever is the highest that doesn't get them busted.
They will also lower the value of an Ace card if it happens to bust them

The dealer's turn is over if they decide to stand, if they get busted, or if they have blackjack. 

After both turns are over, the current code allows the player to see what the hand of the dealer was. This function
is easily changeable in the code, and will be discussed within the section, "SOFTWARE DESIGN". 

It is a TIE in the following scenarios:

	Dealer and Player both have blackjack.
	Dealer and Player both have the same value (as long as they didnt bust)

The Player LOSES in the following scenarios:

	Dealer gets blackjack and the Player doesn't.
	Dealer has a greater value in its hand than the player (as long as the dealer didn't bust)
	Player busts (doesn't matter if Dealer busts or not)

The Player WINS in the following scenarios:

	Player gets blackjack and the dealer doesn't.
	Player has more value in its hand than the dealer (as long as neither of them busted)
	The dealer busted but the player didn't. 

The current funds of the player will then be displayed and the game will ask the player if they want to play
another hand.

The player will also be paid 1.5 the size of their bet. 

The bet itself also increments by $1 every hand.

If, however, the player doesn't have enough money for another hand, the program will be able to detect this
and end the game, notifying the player that they have too little money. 

After checking who wins or not, the dealer will then check to see if there are 12 or less cards remaining in the deck,
if so, they will reintroduce the previously dealt cards and reshuffle the deck. 

Note:
	Only one desk of size 52 cards is being used. 
	The player can hit or stand on anything.
	
	NO OTHER VARIATION IS BEING USED OTHER THAN THAT GIVEN.


--------------------------------------------------------------------------------------------------------------------------------------------
SOFTWARE DESIGN
--------------------------------------------------------------------------------------------------------------------------------------------

I will now explain why and how I chose to design my code the way I did.

Certain elements in the game, especially the statements I choose to print, while they may not be completely
necessary, certainly serve to make the game feel nicer to use for the player. As a result, if the person 
analyzing this code cannot come up with a functional purpose for something, they should look to see if it serves
a convenient, or aesthetic purpose instead.

------------------------------------------------------
Card.java
------------------------------------------------------

I created a Card class that takes in a number from 1 to 13 and a suite and because I knew I needed to keep
track of the face and make sure to assign them a value of 10, I had the constructor call another method
called matchFace(number).

This method checks to see if a number is between 1 and 10, then it assigns the card the face value of "Ace"
if its number is 1, and assigns the face value to be the card's respective number in all other numbers greater
than 1 and less than 10

It then checks to see if the number is above 10, it assigns the face value correspondingly to the face card's name.
So, 11 means "Jack", 12 means "Queen", and 13 means "King. I made sure to include here that the card's value 
would be set to 10 if it was as face card.

For all my other methods, they are simply get methods that get properties of the card I use later on to check for
the current hand and the current state of the Player and Dealer.


------------------------------------------------------
Deck.java
------------------------------------------------------

Here, I had the deck constructor automatically call the method creatDeck() so that it could automatically create
a deck without need of another command. 

In createDeck(), I had a nested for loop where it would first choose a suite name from the suite String
array instance variable, and then create 13 cards from that one suite. It then moves on to the next suite
until it goes through all four. I also made sure to have an exterior counter outside of the nested for loops
because in order to count up to 52 for the deck array, I needed the deck's counter to only increase during
the actual adding of the card to the deck itself. Therefore, "deckCount" is initialized outside of the nested for loop.

The size of the deck is automatically found, and then the shuffe method is called.

In the shuffle() method, it sets the size to 52 first because this method will also be called when the deck is at 12
cards or less, and so the previously dealt cards must also be re-introduced into the deck. If the deck was just
created, then it has no effect on the deck. It then starts at position 51 in the deck array, creates a random position
and assigns the Card at that random position in the deck to the position of the deck at the current counter i. 
The counter i then decrements so that we can ensure all the cards in the deck will be assigned some random 
card from another part of the deck. 
	This approach seemed much more time and space efficient to me as well as just simply more effective
	at ensuring that all cards in the deck would be addressed, much more so than just giving some 
	arbitrary large number. 

In playDeck(), I then return the card at the end of the deck array, making sure to first decrement size before 
letting it call the Card at that position. Otherwise, because the size 52 deck array only has positions from  0 to 51, I 
would get an error.

The getSize() method was made to make sure the dealer could check if the deck needed reshuffling once its size
was at 12 or less cards.


------------------------------------------------------
Dealer.java
------------------------------------------------------

There are a number of get methods and other simple methods here, 
these are fairly intuitive to understand, their creation was because 
I needed to use a property of the dealer at one point or another to check on its state during the game.

The acceptCard method noticeably, is a simple method that adds an inputted card into the rest of the arraylist
hand. It then automatically checks the value of the hand to see if the dealer has busted, if it has blackjack, etc..

I will now address the methods less intuitive.

In checkValue(), it uses an enhanced for loop to add up the value of the dealer's hand, it then checks to see if the
dealer has blackjack if the value happens to equal 11 by seeing if it has any combination of an Ace and a value 10
card in its first two cards. I thought about using a contains method but if the dealer had an Ace card and a value
10 card later in the game when the Ace was worth 1, and it had three other cards at hand, it would identify
a blackjack falsely. Therefore, though a bit bruteforce, I used this method to check if the dealer (and player)
has blackjack. If the value is greater than 21, it would then be a bust.

The dealer uses checkAceValue() to test to see if an Ace should be 11 or 1, to see which value would help it increase
the value of its hand the greatest without busting. To do this, I also assigned "value" to another integer called
"testValue", so that "value" wouldn't change in value, and all our calls to getValue() would remain accurate. I
used an enhanced for loop at add up the hand, and then added 11 to see if it would bust the dealer.
If it did, it'd be clear that it had to be 1. This was left as is because the dealer wouldnt hit at 21, and if it did, 
the bust calls later would catch that the dealer was gonna bust anyways. 

The setAceIfBust() metho also makes sure to check for a card that is both an "Ace" and has value 11, to set it to
1 in order to avoid being busted. 


------------------------------------------------------
Player.java
------------------------------------------------------

The methods are all very similar to the Dealer's.

A difference worth mentioning is that the setAceIfBust() method returns a boolean. This is so that the program
can notify the player if its Ace has been lowered. While not necessary to have this function, it certainly makes
the program feel much nicer. 

------------------------------------------------------
Game.java
------------------------------------------------------

Again, I will gloss over the intuitive functions of this program and directly address things that might seem 
confusing AND that are NOT addressed in the comments. 

For the game itself, I chose to divide the turns into TWO major portions, a hitting method and a turn method.
There are other smaller functions involved, but those are simplistic and intuitive to understand. I divded it up
as such so that the first four cards could be dealt, and the blackjack status of the player and dealer could be
checked by calling the same method that would check the bust/hit/stand status of the player and dealer later
on in the game as well. Having all things related to checking the value of the hand in one place seems like a 
convenient and systematic of designing the code to me, so that is why I did not have separate code for 
the beginning phase of the game. 

In the turn methods, I included a while loop that would continually calling the hitting methods. For the player,
they would get a system prompt, while the dealer does not need one, it being an artificial player. 

In the hitting methods, I have things ordered in a particular way so that the player/dealer would first get a Card,
check if it's an Ace, set the value of the Ace, see if the value of an Ace needs to be lowered if their hand is busted,
and THEN after another check to see if they're still busted, or, for the dealer's case, if its hand's value
was above 17, to end their turn. Of course

After each turn was done, I had a method that determined who won or not. Notice I have two types of booleans,
handEnded booleans, and a gameEnded boolean. The handEnded booleans ends the turn of the player and the dealer
so that the next phase of the game can continue. While the gameEnded boolean will end the game entirely if
the player runs out of funds, or if the player chooses to stop playing entirely. The blackjack check could 
have been placed anywhere because the entire method still has to run through its entire 
self before realizing that it needed to proceed its next turn. 

After a hand is over, a quick check is done to see if the deck needs reshuffling.
Then the cycle begins and the player is asked to place their own bet again. There are many checks here to ensure
that the player is betting an appropriate amount, and has enough to fund those bets. I felt like if statements
here were the best way to do this. 

Notice that when the hand is over, I ensured to set many of the variables back to default, and to clear the hand
of the player and the dealer, a method that just removes the cards from the arraylist hand of the player and the
dealer.

An option to end the game is also given.