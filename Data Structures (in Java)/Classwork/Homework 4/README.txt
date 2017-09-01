Conder Shou
cs3544
Homework 4 
Data Structures in Java


-------------------------------------------------------------------------------------------------------------------
Files Submitted
-------------------------------------------------------------------------------------------------------------------

SpellChecker.java
words.txt
filetospellcheck.txt
KBestCounter.java
TestKBest.java
README.txt
written.pdf


-------------------------------------------------------------------------------------------------------------------
SpellChecker.java
-------------------------------------------------------------------------------------------------------------------

Takes in two command line arguments, a dictionary file and a text file to spellcheck,
	and spell checks the latter text file. 

Displays what word is misspelled at which line, and gives a list of suggested words 
that exist in the dictionary file.

The suggested words are found through doing one of the following operations:
	
	Adding one character
	Removing one character
	Exchanging adjacent characters


TO COMPILE through the command line, type:		javac SpellChecker.java

TO RUN the program through the command line, INCLUDING the two text files, type:	

	java SpellChecker words.txt filetospellcheck.txt

OR, to run the program for other text files other than the ones included, follow this generic form:

	java SpellChecker [insert name of dictionary file] [insert name of file to spell check]

When entering the name of the text files, Include extensions and remove the brackets.  


-------------------------------------------------------------------------------------------------------------------
words.txt
-------------------------------------------------------------------------------------------------------------------

The dictionary file to be used with SpellChecker.java.

Not meant to be independently compiled and run through. 


-------------------------------------------------------------------------------------------------------------------
filetospellcheck.txt
-------------------------------------------------------------------------------------------------------------------

The text file meant to be spell checked by SpellChecker.java

Not meant to be independently compiled and run through. 


------------------------------------------------------------------------------------------------------------------- 
KBestCounter.java
-------------------------------------------------------------------------------------------------------------------

Finds the k-largest values in a set of data, given any sequence of values. 

	Can process the next element in the set of data.
	
	Can return a sorted, decreasing (largest to smallest) list of the k-largest elements, 
	restoring the priority queue to its original state after retrieving the k largest elements. 

This class is meant to be instantiated by TestKBest.java and NOT meant to be compiled and ran through 
directly from the command line.


-------------------------------------------------------------------------------------------------------------------
TestKBest.java
-------------------------------------------------------------------------------------------------------------------

Tests the functions of KBestCounter.java

	Inserts sequences of values and tests to see if KBestCounter.java will return the 5 largest
	elements in a sorted, decreasing list. 


TO COMPILE through the command line, type:		javac TestKBest.java

TO RUN the program through the command line, type:	java TestKBest


-------------------------------------------------------------------------------------------------------------------
README.txt
-------------------------------------------------------------------------------------------------------------------

Outlining the function of each program, what files I'm submitting, and how to compile and run them.

-------------------------------------------------------------------------------------------------------------------
written.pdf
-------------------------------------------------------------------------------------------------------------------

The written portion of the homework.