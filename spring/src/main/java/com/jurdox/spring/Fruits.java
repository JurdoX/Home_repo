package com.jurdox.spring;

import java.util.List;

public class Fruits {

	private String name;
	private List<String> fruits;

	public Fruits(String name, List<String> fruits) {
		this.name = name;
		this.fruits = fruits;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append(" contains\n");

		for (String fruit : fruits) {
			sb.append(fruit + "\n");
		}

		return sb.toString();
	}

}
