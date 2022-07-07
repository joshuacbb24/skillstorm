package com.skillstorm.week1.day1;

public class Dog {

	private String name; // A dog's name
	private short age; // A dog's age
	private String owner; // A dog's owner
	private String breed; // A dog's breed
	private static int dogPopulation; //dog population
	
	// Static; Shared across all instances
	// Final; can't be changed
	// Constant variables should be public static final in java
	public final static String SCIENTIFIC_NAME = "Canis lupus familiaris"; //Dog's scientific name
	
	//default constructor
	Dog() {
		dogPopulation++;
	}
	//Defining my own constructor
	Dog(String name, short age, String owner, String breed) { 
		// use "this" keyword to assign properties
		this.name = name;
		this.age = age;
		this.owner = owner;
		this.breed = breed;
		dogPopulation++;
		}
	//overloaded constructor without breed
	Dog(String name, short age, String owner) { 
		// use "this" keyword to assign properties
		this.name = name;
		this.age = age;
		this.owner = owner;
		this.breed = "Unknown";
		dogPopulation++;
		}
	
	//Function to get name property
	public String getName() {return name;}
	//Function to set/change name property
	public void setName(String name) {
		//if string is not empty set/change the name property
		if (name != "") {
			this.name = name;
			}
		}
	//Function to get age property
	public short getAge() {return age;}
	//Function to set/change age property
	public void setAge(short age) {this.age = age;}
	//Function to get owner property
	public String getOwner() {return owner;}
	//Function to set/change owner property
	public void setOwner(String owner) {this.owner = owner;}
	//Function to get breed property
	public String getBreed() {return breed;}
	//Function to set/change breed property
	public void setBreed(String breed) {this.breed = breed;} 
	//Function to make dog speak
	public void speak() {
		System.out.println("Bark! (My name is " + this.name + ")");
	}
	
}
