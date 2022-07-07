package com.skillstorm.week1.day2;

//Public class name must match the file
//Only on public class per file
public class Rectangle extends Shape implements Polygon{
	private double length;
	private double width;
	
	public Rectangle() {
		super();
	}
	
	public Rectangle(double length) { // Act as a Square constructor
		//this.length = length;
		//this.width = length;
		this(length, length, "Red"); //constructor chaining
	}
	
	public Rectangle(double length, double width, String color) {
		super(color);
		setLength(length);
		setWidth(width);
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	
	//calculate area
	public double calcArea() {
		return length * width;
	}
	
	//calculate Perimeter
	public double calcPerimeter() {
		return (2 * length) + (2 * width);
	}
	
	public static void main(String[] args) {
		Rectangle rect = new Rectangle(5.0, 10.0, "Green");
		System.out.println("Area of the rectangle: " + rect.calcArea());
		System.out.println("Perimeter of the rectangle " + rect.calcPerimeter());
		
		rect.setLength(10.0);
		System.out.println("Area of the rectangle: " + rect.calcArea());
		System.out.println("Perimeter of the rectangle " + rect.calcPerimeter());
		
	}
	
	
	
}
