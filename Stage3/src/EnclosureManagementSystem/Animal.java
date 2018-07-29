package EnclosureManagementSystem;

public class Animal {
	protected String type;
	protected String name;
	protected String id;
	protected String weight;
	protected String vaccination;
	protected String age;
	protected String location;

	public Animal(String type, String name, String id, String weight, String vaccination, String age, String loctaion) {
		this.type = type;
		this.name = name;
		this.id = id;
		this.weight = weight;
		this.vaccination = vaccination;
		this.age = age;
		this.location = loctaion;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getVaccination() {
		return vaccination;
	}

	public void setVaccination(String vaccination) {
		this.vaccination = vaccination;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String loctaion) {
		this.location = loctaion;
	}

	@Override
	public String toString() {
		String details = "Animal Id: " + id + 
				"\n\tAnimal Name: " + name + 
				"\n\tAnimal Type: " + type +
				"\n\tWeight of animal: " + weight + 
				"\n\tVaccination Status: " + vaccination + 
				"\n\tAge of animal: " + age +
				"\n\tLocation of animal: " + location;
		return details;
	}
}