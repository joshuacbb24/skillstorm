package com.skillstorm.week1.day2;

//Interfaces are similar to abstract classes, but they can't have ANY concrete methods (only abstract)
//A class can only extend one other class, but a class can implement multiple interfaces
public interface Polygon {

	//Anything that's a Polygon will be able to calculate it's own perimeter
	public double calcPerimeter();
	
//Interfaces can extend other interfaces
//Anything implementing this one, must implement 
interface MyPolygon extends Polygon {
	
}
}
