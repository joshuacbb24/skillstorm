package com.skillstorm.week1.day1;

public class GoldenRetriever extends Dog{
	// Extending a class causes all public and protected properties to be inherited by the new class
	
	// Constructors should generally be public
	public GoldenRetriever() {
		super(); // Calls the no-arg constructor of the parent class
	}
	
	public GoldenRetriever(String name, short age, String owner) {
		//this(); sibling constructor
		super(name, age, owner, "Golden Retriever"); // Constructor chaining
	}
	
	//If I want, I can "override" the behavior of the parent method by giving it the same method definition + name 
	@Override //Annotation that ensures the method is actually an override. If not, it won't compile
	public void speak() {
		//super can call original overwritten method
		super.speak();
		System.out.println("I am a Golden Retriever");
	}
	public static void main(String[] args) {
		GoldenRetriever levi = new GoldenRetriever("Levi", (short)1, "Sean");
		System.out.println(levi.getBreed());
		
	}
}
