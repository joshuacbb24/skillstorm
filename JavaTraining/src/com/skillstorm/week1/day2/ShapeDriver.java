package com.skillstorm.week1.day2;

public class ShapeDriver {
	
	
	//Static functions can only call other static functions
	public static void printArea (Shape shape) {
		//I specify the param as a Shape is so that I can take ANY shape
		System.out.println("The area of the shape provided is: " + shape.calcArea());
	}
	
	public static void printPerimeter(Polygon polygon) {
		System.out.println("The perimeter of the shape provided is: " + polygon.calcPerimeter());
	}
	public static void main(String[] args) {
		Rectangle rect = new Rectangle(5.0, 10.0, "Blue");
		System.out.println("The area of the rectangle is: " +rect.calcArea());
		System.out.println("Perimeter of the rectangle is: " + rect.calcPerimeter());
		System.out.println("The color of the rectangle is:" + rect.getColor());
		
		Triangle triangle = new Triangle(10.0, 15.0, "yellow");
		System.out.println("The area of the triangle is: " + triangle.calcArea());
		System.out.println("Perimeter of the triangle is: " + triangle.calcPerimeter());
		System.out.println("The color of the triangle is:" + triangle.getColor());
		
		//Since they're both shapes, I can call them both shapes
		printArea(rect);
		printArea(triangle);
		
		printPerimeter(rect);
		printPerimeter(triangle);
		
		
	}
}
