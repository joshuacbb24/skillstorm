package com.skillstorm.week1.day3;

public class Car implements Driveable {

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("Vroom vroom");
		
	}

	@Override
	public void drive(int numMiles) {
		// TODO Auto-generated method stub
		System.out.println("Vroom vroom " + numMiles);
		
	}

}
