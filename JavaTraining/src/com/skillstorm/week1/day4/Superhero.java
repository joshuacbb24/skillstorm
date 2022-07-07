package com.skillstorm.week1.day4;

public interface Superhero {

	void activateSuperpower();
	
	void stateName();
}

class Superman implements Superhero {

	@Override
	public void activateSuperpower() {
		System.out.println("Flies and shoot lasers");
		
	}

	@Override
	public void stateName() {
		System.out.println("My name is superman");
		
	}
	
}

class Batman implements Superhero {

	@Override
	public void activateSuperpower() {
		System.out.println("Being rich");
		
	}

	@Override
	public void stateName() {
		System.out.println("My name is Batman");
		
	}
	
}

class WonderWoman implements Superhero {

	@Override
	public void activateSuperpower() {
		System.out.println("Half God half Amazon");
		
	}

	@Override
	public void stateName() {
		System.out.println("I am Wonder Woman");
		
	}
	
}