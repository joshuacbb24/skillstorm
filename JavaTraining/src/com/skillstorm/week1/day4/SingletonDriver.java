package com.skillstorm.week1.day4;

public class SingletonDriver {

	public static void main(String[] args) {
		Singleton instance = Singleton.getInstance();
		Singleton anotherinstance = Singleton.getInstance();

		System.out.println(instance);
		System.out.println(anotherinstance);

	}

}
