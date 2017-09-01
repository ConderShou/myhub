Conder Shou
cs3544
Intro to CS: Java


--------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------
				Programming Project 5: Scrabble List
--------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------



--------------------------------------------------------------------------------------------------------------------------------------------
INSTRUCTIONS ON HOW TO USE THE PROGRAM
--------------------------------------------------------------------------------------------------------------------------------------------

Run WordListsTester.java, or use your own tester.

Output text files are sent to the chosen directory. The default is in the workspace folder of Eclipse.

--------------------------------------------------------------------------------------------------------------------------------------------
SOFTWARE DESIGN
--------------------------------------------------------------------------------------------------------------------------------------------

I will now explain why and how I chose to design my code the way I did.

Because many functions of the method were similar, I used a very similar structure for the methods of 
WordList.java

------------------------------------------------------
WordList.java
------------------------------------------------------

I used an ArrayList to store the dictionary file because we don't know the size of the array beforehand,
 or at least, it'd more difficult to find the array size than to just use an Array list. 

Also, I made sure throw the FileNotFoundException in case the file inputted inside the Reader does not exist.

I went through the array list elements for each method because each element was a word, and then either 
compared the word to the desired quantities we needed to, or split the word with .split("") into individual letters
to search for the specified conditions. 

I also made sure to convert the inputted character parameters into String to make them more comparable. 

------------------------------------------------------
WorListTester.java
------------------------------------------------------

Used a try-with-resources statement to protect multiple PrintWriter objects that create an individual text file
for each method tested.

Tests each method after instantiating WordList.java by invoking them with given parameters. 