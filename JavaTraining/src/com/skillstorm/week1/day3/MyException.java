package com.skillstorm.week1.day3;

import java.util.Arrays;

public class MyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5183199652990520740L;

	public MyException() {
		// Creating a default MyException object using Exception's default
		super();
	}
	
	public MyException(String message) {
		super(message); // Exception class knows what to do with this message
		
	}
	
//	@Override
//	public String toString() {
//		return super.getMessage();
//	}

	public static void main(String[] args) {
		MyException me = new MyException("Something went wrong");
		System.out.println(me);

	}

}
