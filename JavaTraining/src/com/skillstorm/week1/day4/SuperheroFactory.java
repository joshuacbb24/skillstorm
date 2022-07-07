package com.skillstorm.week1.day4;

// Factory Design pattern is a way to manage the creation of objects
// INstead of say new whatever() everywhere in the codebase, you instead leverage the factory

// Factory design pattern allows for decoupling so that i can get back a superhero, but it doesn't
// matter which one I get back
public class SuperheroFactory {

	public static Superhero createSuperHero() {
		return new Superman();
	}
	
	public static Superhero createSuperHero(String name) {
		if (name == null) {
			return createSuperHero();
		}
		
		switch(name.toUpperCase()) {
			case "SUPERMAN":
				return new Superman();
			case "BATMAN":
				return new Batman();
			case "WONDERWOMAN":
				return new WonderWoman();
			default:
				return createSuperHero();
		}
	}
	public static void main(String[] args) {
		Superhero supe = createSuperHero();
		supe.activateSuperpower();
		supe.stateName();

	}

}
