package com.skillstorm.week1.day2;

//Adding the abstract keyword makes the class abstract
//An abstract class CANNOT be instantiated
//An abstract class is used to represent an idea or what a group of objects is capable of
public abstract class Shape {
	
	String color;
	
	public Shape() {
		
	}
	
	//These constructors will be called using super()
	public Shape(String color) {
		setColor(color);
	}
	
	//I can define a function body so long as there's no abstract keyword
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}


	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	//A shape must be able to do this
	
	
	//A shape must be able to calculate its area
	//Any class inheriting from shape MUST override calcArea()
	public abstract double calcArea();// No function definition
	//A shape must be able to calculate its perimeter
}
