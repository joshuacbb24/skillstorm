package com.skillstorm.week1.day2;

public class Triangle extends Shape implements Polygon{
	
	private double base;
	private double height;
	
	

	public Triangle() {
		super("Red");
	}



	public Triangle(double base, double height) {
		this(base, height, "Red");
	}

	public Triangle(double base, double height, String color) {
		super(color);
		setBase(base);
		setHeight(height);
	}


	/**
	 * @return the base
	 */
	public double getBase() {
		return base;
	}


	/**
	 * @param base the base to set
	 */
	public void setBase(double base) {
		this.base = base;
	}


	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}


	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}


	@Override
	public double calcArea() {
		return 0.5 * (base * height);
	}


	@Override
	public double calcPerimeter() {
		return base + height + base;
	}

}
