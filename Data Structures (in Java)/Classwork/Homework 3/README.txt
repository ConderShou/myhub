Conder Shou
cs3544
Homework 3 
Data Structures in Java


-------------------------------------------------------------------------------------------------------------------
Files Submitted
-------------------------------------------------------------------------------------------------------------------

AvlTree.java
ExpressionTree.java
MyStack.java
Problem1.java
Problem2.java
UnderflowException.java
README.txt
written.pdf


-------------------------------------------------------------------------------------------------------------------
ExpressionTree.java
-------------------------------------------------------------------------------------------------------------------

Constructs an expression tree from a postfix String expression.

Returns the result of the postfix expression through method eval()

Returns a String that contains the postfix expression of the Expression tree through method postfix()

Returns a String that contains the prefix expression of the Expression tree through method prefix()

Returns a String that contains the infix expression of the Expression tree through method infix()

This class is meant to be instantiated by Problem1.java and NOT meant to be compiled and ran through
directly from the command line. 

-------------------------------------------------------------------------------------------------------------------
MyStack.java
-------------------------------------------------------------------------------------------------------------------

The MyStack.java file from the sample solution of homework 2. 

Using java.util.LinkedList, this program functions as a stack, supplying functional push and pop methods
 for ExpressionTree.java to construct its expression tree with, and to evaluate its expression with.

This class is meant to be used by ExpressionTree.java, which is then meant to be demonstrated through
  Problem1.java. This program is NOT meant to be compiled and ran through directly from the command line.

-------------------------------------------------------------------------------------------------------------------
Problem1.java
-------------------------------------------------------------------------------------------------------------------

Instantiates the ExpressionTree class.

Creates an expression tree from any user-inputted postfix expression.

Calls the public eval(), postfix(), prefix(), and infix()  methods to demonstrate their
functionality.

TO COMPILE through the command line, type:		javac Problem1.java

TO RUN the program through the command line, type:	java Problem1


------------------------------------------------------------------------------------------------------------------- 
AvlTree.java
-------------------------------------------------------------------------------------------------------------------

An AVL tree class that contains nodes that are meant to contain a word and its linked list of line numbers 
that it occurs at. 

Adds an occurrence of a word and its line number to the tree through the method indexWord.
	If a word already exists in the AVL tree, it adds a new line number to the existing node.
	If a word appears on the same line twice, then the line number only occurs once. 

Looks up a word and returns the list of line numbers in which that word occurs at through method getLinesForWord

Prints out each unique word stored in the AVL tree along with the list of line numbers that the word appears at
through method printIndex

This class is meant to be instantiated by Problem2.java and NOT meant to be compiled and ran through
directly from the command line. 


-------------------------------------------------------------------------------------------------------------------
UnderFlowException.java
-------------------------------------------------------------------------------------------------------------------

An exception class that AVLTree.java requires to function with.

AVLTree.java throws this exception in certain parts of its code. 

This class is meant to be used by AVLTree.java and NOT meant to be compiled and ran through 
directly from the command line.


-------------------------------------------------------------------------------------------------------------------
Problem2.java
-------------------------------------------------------------------------------------------------------------------

Creates an instance of AVL tree and indexes the words contained in a text file that is provided
through the command line. 

It converts all text into lower case and removes ALL punctuation and any special characters.

It calls the printIndex() method after indexing the text file, displaying the list of unique words in the text file
as well as their corresponding line numbers


TO COMPILE through the command line, type:		javac Problem2.java

TO RUN the program through the command line, type, without the brackets:

	java Problem2 [insert textfile name, including its extension]

Ex: 
	java Problem2 spook.txt

-------------------------------------------------------------------------------------------------------------------
README.txt
-------------------------------------------------------------------------------------------------------------------

Outlining the function of each program, what files I'm submitting, and how to compile and run them.

-------------------------------------------------------------------------------------------------------------------
written.pdf
-------------------------------------------------------------------------------------------------------------------

The written portion of the homework