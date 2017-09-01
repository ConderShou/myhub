/** 
 * A class to test the Car class
 * @author Conder Shou
 */

public class CarTester {

	/**
	 * Tests the methods of the Car class.
	 * @param args not used
	 */
	public static void main(String[] args) {
		Car newCar = new Car();
		
		double gas = 120;
		double distance1 = 60;
		double distance2 = 30;
		
		newCar.addGas(gas);
		newCar.drive(distance1);
		newCar.addGas(gas);
		newCar.drive(distance2);
		
		// gas efficiency is 30 miles per gallon
		
		double expectedGas = 120 - distance1/30 + 120 - distance2/30;
		System.out.println("The expected amount of gas in the car is: " + expectedGas);
		System.out.println("The actual amount of gas in the car is: " + newCar.getGasInTank());
	}
		
}
