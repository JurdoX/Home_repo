package com.jurdox.spring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jungle {

	private Animal largest;
	private Map<String, String> foods = new HashMap<String, String>();
	private Map<String, Animal> animals = new HashMap<String, Animal>();

	public Animal getLargest() {
		return largest;
	}

	public void setLargest(Animal largest) {
		this.largest = largest;
	}

	public void setFoods(Map<String, String> foods) {
		this.foods = foods;
	}

	public void setAnimals(Map<String, Animal> animals) {
		this.animals = animals;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		// sb.append("Largest: " + largest + "\n");
		// sb.append("Others:\n");

		// for (Animal animal : animals) {
		// sb.append(animal + "\n");
		// }

		for (Map.Entry<String, String> entry : foods.entrySet()) {
			sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
		}

		sb.append("\n");
		
		for (Map.Entry<String, Animal> entry : animals.entrySet()) {
			sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
		}
		
		return sb.toString();
	}

}
