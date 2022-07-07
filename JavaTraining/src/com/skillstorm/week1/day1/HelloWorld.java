package com.skillstorm.week1.day1;

public class HelloWorld {

	public static void main(String[] args) {
		//System.out.println("Hello World!");
		//System.out.println(args[0]); //sysout then ctrl + space 
		//Dog dog = null; 
		Dog dog = new Dog("Levi", (short)1, "Sean", "Golden Retreiver"); // creates a dog object
		dog.speak();

	}

}
