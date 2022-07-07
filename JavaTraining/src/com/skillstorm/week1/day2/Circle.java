package com.skillstorm.week1.day2;

public class Circle extends Shape{
	
	private double radius;

	
	public Circle() {
		super();
	}


	public Circle(double radius) {
		super();
		this.radius = radius;
	}


	public Circle(double radius, String color) {
		super(color);
		setRadius(radius);
	}


	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}


	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}


	@Override
	public double calcArea() {
		return Math.PI * (radius * radius);
	}
}
