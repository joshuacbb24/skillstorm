package com.skillstorm.week1.day4;

import java.util.Deque;
import java.util.LinkedList;

public class StackPractice {

	public static void main(String[] args) {
		
		// First-in / Last-out or Last-in / First-out
		Deque<String> words = new LinkedList<>();
		words.push("Wikipedia");
		words.push("George Washington");
		System.out.println(words);
		System.out.println(words.peek());
	}

}
