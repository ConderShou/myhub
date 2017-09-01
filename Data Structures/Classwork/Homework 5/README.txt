Conder Shou
cs3544
Data Structures in Java


-------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------
						Homework 5
-------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------


-------------------------------------------------------------------------------------------------------------------
Files Submitted
-------------------------------------------------------------------------------------------------------------------

written.pdf
Problem1.java
Dijkstra.java
Display.java; Edge.java; Vertex.java
citypairs.txt
cityxy.txt
README.txt


-------------------------------------------------------------------------------------------------------------------
Problem1.java
-------------------------------------------------------------------------------------------------------------------

Implements a non-recursive, iterative implementation of Merge Sort.
The algorithm starts with each pair of elements in the array and sorts larger and larger subarrays bottom-up.

TO COMPILE through the command line, type:		javac Problem1.java

TO RUN the program through the command line, type:	java Problem1


-------------------------------------------------------------------------------------------------------------------
Dijkstra.java
-------------------------------------------------------------------------------------------------------------------

Implements Dijkstra's algorithm to find shortest paths between pairs of cities on a map.
Also calculates all eculidean distances between each directly connected pair of cities.

It is optional for the user to compile this progrm for debugging. 

The output of this program will give an adjacency list of the cities included in the citypairs.txt file as well as a
path between SanFrancisco and Boston.

TO COMPILE through the command line, type:		javac Dijkstra.java

TO RUN the program through the command line, type:	java Dijkstra

MAKE SURE to include the two text files: citypairs.txt and cityxy.txt 	in the same source folder if this program is
	being run through the command line. 

-------------------------------------------------------------------------------------------------------------------
Display.java - Edge.java - Vertex.java
-------------------------------------------------------------------------------------------------------------------

These files were given by the instructor and were meant to all be used together in the same source folder, along with
Dijkstra.java, citypairs.txt, and cityxy.txt (assuming this is being run through the command line)

----------
Display.java  
----------

Creates a GUI that visually shows the map of cities and their distances.
Allows the user to press a button to compute all the euclidean distances between each directly connected pair of cities.
Allows the user to press a button to highlight the shortest path from one city to another, calling upon the algorithm
	implemented in Dijsktra.java


TO COMPILE through the command line, type:		javac Display.java

TO RUN the program through the command line, type:	java Display


----------
Edge.java
----------

Creates the edge class.
Contains the distance between two vertices.

Not meant to be independently compiled and run.


----------
Vertex.java
----------

Creates the Vertex class and holds all the properties of the vertex. 
Contains the name of the vertex, its coordinates, its distance, the edges of adjacent vertices, its known value, and 
	the path variable for implementing Dijkstra's algorithm. 

Not meant to be independently compiled and run.


------------------------------------------------------------------------------------------------------------------- 
cityxy.txt
-------------------------------------------------------------------------------------------------------------------

Contains the city names and their x-y coordinates.

Not meant to be independently compiled and run.

-------------------------------------------------------------------------------------------------------------------
citypairs.txt
-------------------------------------------------------------------------------------------------------------------

Contains the pairs of cities directly connected to each other by an edge and their default distance values. 

Not meant to be independently compiled and run.


-------------------------------------------------------------------------------------------------------------------
README.txt
-------------------------------------------------------------------------------------------------------------------

Outlining the function of each program, what files I'm submitting, and how to compile and run them.

-------------------------------------------------------------------------------------------------------------------
written.pdf
-------------------------------------------------------------------------------------------------------------------

The written portion of the homework.