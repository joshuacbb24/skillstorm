package com.skillstorm.week1.day3;

public class Bicycle implements Driveable {

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("Ding ding");

	}

	@Override
	public void drive(int numMiles) {
		// TODO Auto-generated method stub
		System.out.println("Ding ding " + numMiles);

	}

}
