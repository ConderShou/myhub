
public class Car {
	
	private double fuel;
	private double gasEfficiency;
	
	public Car() {
		fuel = 0;
		gasEfficiency = 30;		// fuel efficiency is 10 miles per gallon
	}
	
	public double getGasinTank() {
		return fuel;
	}
	
	public void drive(double distance) {	// Textbook says to assume we never drive a distance greater than available gas
		fuel = fuel - distance/gasEfficiency;
	}
	
	public void addGas(double addFuel) {
		fuel = fuel + addFuel;
	}
	
	public double getGasInTank() {
		return fuel;
	}
	
}
