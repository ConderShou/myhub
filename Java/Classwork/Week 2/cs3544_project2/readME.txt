Conder Shou
cs3544
Intro to CS: Java

---------------------------------------------------------
RomanNumeral.java
---------------------------------------------------------

For the RomanNumeral class, I chose to first calculate the amount of thousands, hundreds, tens, and ones 
in the number through the use of integer division. This also means I calculated if a 500 or a 50 was also included
in the number. I kept track of how often these numbers fit into the user-inputted number and then I gave conditional 
statements accordingly. 

If there were any amount of thousands in the number, I made a for loop run through and add the corresponding
number of M's, then I made sure to first include a statement to check whether or not I needed to instead add a 
"CM" if the number also consisted of a 900. 

Everytime I checked whether one of the 900, 90, or 9 values was included in the chosen number, I created a 
boolean value to make sure that the program wouldn't then input more numerals, like nine I's for 9 after it 
had already added a "IX". 

For that same reason, I also added boolean values for when I added the 500 or 50 value numerals.

Other than that, I would include the appropriate conditional statements to run loops that would add the same numeral 
as needed. With my boolean values from before, I would be able to make sure the loops didn't add this same numeral 
more than 3 times. 

To simplify things, I also made separate methods that added the numeral to the main string and that converted the inputted number into a roman numeral. 
The converting method is immediately called upon the instantiation of a RomanNumeral object.

I designed my code like this in order to organize it in concrete steps and in AN ATTEMPT to reduce the amount of hard-coding 
in the program. Whether I succeeded in this or not will be up to my viewer;s judgement and largely due to my inexperience and nooby background in programming. 

---------------------------------------------------------
RomanNumeralTester.java
---------------------------------------------------------

Here I ask the user for a number and add a "do" loop to make sure the inputted number is equal to below 3999.
Then I simply instantiate a RomanNumeral obejct and print out the "get" method of the RomanNumeral class after
it has been converted.

Here I simply instantiate an object of the class and test to see if it works by calling its "get" method, in which it
should return the converted equivalent of the inputted number. 

---------------------------------------------------------
Drunkard.java
---------------------------------------------------------

Upon instantiation of the Drunkard object, the coordinates are kept in two separate sets. 
One set is meant to remember the initial position, and so is a final value. 
The other set is meant for the other methods to manipulate and randomly add or subtract from depending on the
result of the random integer generator. 

In the step() method I create a Random object that only calls four different numbers, from 0 to 4 exclusive, and 
I use a switch statement to compare the result of the random integer with the different actions the program must execute.
Respectively, I have the program adding or subtracting one from the current position of the drunkard to simulate
the direction of left, right, up, and down. Earlier, I chose the switch statement because it is simple to look at and is cleaner
for comparing numbers and executing a simple action based on each match. 

For fastForward(), I use the integer parameter as the upper bound for the for loop, in order to give an according
iteration of the number of steps the drunkard takes.

For howFar(), I use the given Manhattan distance metric method, with the tool Math.abs to help me find the absolute
value when needed.

getLocation() is simpy a concatenated string that includes the current position of the drunkard.

---------------------------------------------------------
DrunkardTester.java 
---------------------------------------------------------

This program was given to us.

No modification was made. No explanation is necessary


