package com.skillstorm.week1.day4;

public class Singleton {

	// Having some control over a global entity
	// When i want only one copy of something to exist, I should look to use Singleton
	
	// Eagerly creating the instance
	private static final Singleton instance = new Singleton();
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return instance;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
