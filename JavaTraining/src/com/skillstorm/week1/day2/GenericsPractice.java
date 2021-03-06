package com.skillstorm.week1.day2;

// I can use generics to allow runtime determination of the type
class MyList<T> { // T stands for type
	
	T[] arr;
	
	public void print(T item) {
		System.out.println(item);
	}
}

public class GenericsPractice {

	public static void main(String[] args) {
		
		MyList<Shape> list = new MyList<Shape>();
		list.print(new Rectangle());
	}

}
