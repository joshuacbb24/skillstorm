package com.skillstorm.week1.day3;

public class Varargs {

	public static void vargs(String... words) {
		for (String word : words) {
			System.out.println(word);
		}
		

	}
	// Varargs stands for variable number of arguments
	public static void main(String[] args) {
		vargs("Hello", "my", "name", "is", "Joshua");

	}

}
