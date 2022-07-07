package com.skillstorm.week1.day4;

import java.util.HashSet;

public class SetPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet<Vehicle> vehicleSet = new HashSet<>();
		
		Vehicle vehicle1 = new Vehicle("Tesla", "Y", 2022, "Hot Red");
		Vehicle vehicle2 = new Vehicle("Volkswagen", "Jetta", 2016, "White");
		Vehicle vehicle3 = new Vehicle("Porsche", "Taycan", 2022, "Black");
		Vehicle vehicle4 = new Vehicle("Chrysller", "Turbine", 1964, "#B00B69");
		
		vehicleSet.add(vehicle1);
		vehicleSet.add(vehicle2);
		vehicleSet.add(vehicle3);
		vehicleSet.add(vehicle4);
		System.out.println(vehicleSet);
		
		
		

	}

}
