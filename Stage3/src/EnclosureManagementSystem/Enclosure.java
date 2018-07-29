package EnclosureManagementSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class Enclosure {
	private String enclosureName;
	private String openingHours = "8.00am to 8.00pm";
	protected double entryPrice = 15;
	private Map<String, Animal> animals = new HashMap<String, Animal>();

	public Enclosure() {
		enclosureName = "Unknown Enclosure Name.";
	}

	public Enclosure(String name) {
		enclosureName = name;
	}

	public String getEnclosureName() {
		return enclosureName;
	}

	public void addAnimal(String id, Animal a) {
		animals.put(id, a);
	}

	public Map<String, Animal> getAnimals() {
		return animals;
	}

	public String toString() {
		String details = "----------------------------------" + 
				"\nEnclosure Name: " + enclosureName + 
				"\nNumber of animals: " + animals.size() + " animal(s) " +
				"\nOpening hours: " + openingHours + 
				" \nEntry price: " + this.getPrice() + 
				"\nAnimals Details:\n";
		
		for (Entry<String, Animal> animal : animals.entrySet()) {
			details += animal.getValue() + "\n";
		}
		return details;
	}

	public double getPrice() {
		return this.entryPrice;
	}

	public void setOpeningHours(String _openingHours) {
		this.openingHours = _openingHours;
	}

	public String getOpeningHours() {
		return this.openingHours;
	}

	public Animal getAnimal(String id) {
		return animals.get(id.trim());
	}
}