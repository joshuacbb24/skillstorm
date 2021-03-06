package com.skillstorm.week1.day3;

// Anything that implements Driveable will have the ability to be "driven"
public interface Driveable {

	public void drive();
	
	public void drive(int numMiles);
	
	public static void main(String[] args) {
		Driveable[] methodsOfTransport = new Driveable[3];
		methodsOfTransport[0] = new Car();
		methodsOfTransport[1] = new Skateboard();
		methodsOfTransport[2] = new Bicycle();
		
		for (Driveable transport : methodsOfTransport) {
			transport.drive();
		}
	}
}
