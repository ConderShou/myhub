/**
 * A tester for the Drunkard class.
 *   
 * @author Cannon 
 */

import java.util.Scanner;
       
public class DrunkardTester {
    public static void main(String[] args) {

	Scanner input = new Scanner(System.in);

	System.out.println("Please enter the starting avenue integer: ");
	int avenue = input.nextInt();
	System.out.println("Please enter the starting street integer: ");
	int street = input.nextInt();
	
	// make the Drunkard with initial position
	Drunkard ozzy = new Drunkard(avenue,street);

	// have him move 100 intersections
	ozzy.fastForward(100);
	
	// get his current location  
	String location = ozzy.getLocation();
	
	// get distance from start
	int distance = ozzy.howFar();

	System.out.println("Current location: " + location);
	System.out.println("That's " + distance + " blocks from start.");

    }
}
