package EnclosureManagementSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class EnclosureDatabase {
	private String zooName;
	private String animalType;
	private String animalName;
	private String animalId;
	private String animalWeight;
	private String animalAge;
	private String vaccination;
	private String animalLocation;
	private Map<String, Enclosure> myEnclosures;

	public EnclosureDatabase() {
		myEnclosures = new HashMap<String, Enclosure>();
	}

	public void insert(String name, Enclosure _newEnclosure) {
		myEnclosures.put(name.trim(), _newEnclosure);
	}

	public Enclosure retrieve(String _key) {
		return myEnclosures.get(_key.trim());
	}

	public Map<String, Enclosure> getMyEnclosures() {
		return myEnclosures;
	}

	private boolean isInvalid(String str) {
		return null == str || str.trim().isEmpty() ? true : false;
	}

	public void loadEnclosureData() {
		Scanner s = null;
		String fileName = "MyZoo.txt";

		File zooFile = new File(fileName);
		if (zooFile.exists() && zooFile.isFile() && zooFile.canRead()) {
			String line = null;

			try {
				FileInputStream fis = new FileInputStream(zooFile);
				s = new Scanner(fis);
				line = s.nextLine();
				if (null == line || line.trim().isEmpty()) {
					System.out.println("Error: Zoo name is blank");
					return;
				}
				
				this.zooName = line;
				line = s.nextLine();
				System.out.println("Welcome to " + zooName + " \n");
				while (s.hasNext()) {
					if (!line.equalsIgnoreCase("END")) {
						String enclosure = line;
	
						if (isInvalid(enclosure)) {
							System.out.println("Error: Enclosure  is not mentioned");
							continue;
						} 
						else {
							switch (enclosure.trim()) {
							case "African Safari Enclosure":
								Enclosure premium = new Premium(enclosure);
								line = s.nextLine();
								while (!"End-enclosure".equals(line)) {
									animalType = line;
									animalName = s.nextLine();
									animalId = s.nextLine();
									animalWeight = s.nextLine();
									vaccination = s.nextLine();
									animalAge = s.nextLine();
									animalLocation = s.nextLine();
											Animal animal = new Animal(animalType, animalName, animalId, animalWeight,
																		vaccination, animalAge, animalLocation);
											premium.addAnimal(animalId, animal);
											//System.out.println(premium);
									line = s.nextLine();
								}
								insert(enclosure, premium);
								line = s.nextLine();
								break;
	
							case "Standard Australian Enclosure":
								Enclosure standard = new Standard(enclosure);
								line = s.nextLine();
								while (!"End-enclosure".equals(line.trim())) {
									animalType = line;
									animalName = s.nextLine();
									animalId = s.nextLine();
									animalWeight = s.nextLine();
									vaccination = s.nextLine();
									animalAge = s.nextLine();
									animalLocation = s.nextLine();
											Animal animal = new Animal(animalType, animalName, animalId, animalWeight,
																		vaccination, animalAge, animalLocation);
											standard.addAnimal(animalId, animal);								
									line = s.nextLine();
								}
								insert(enclosure, standard);
								line = s.nextLine();
								break;
	
							case "Nocturnal Enclosure":
								Enclosure special = new Special(enclosure);
								line = s.nextLine();
								while (!"End-enclosure".equals(line.trim())) {
									animalType = line;
									animalName = s.nextLine();
									animalId = s.nextLine();
									animalWeight = s.nextLine();
									vaccination = s.nextLine();
									animalAge = s.nextLine();
									animalLocation = s.nextLine();
											Animal animal = new Animal(animalType, animalName, animalId, animalWeight,
																		vaccination, animalAge, animalLocation);
											special.addAnimal(animalId, animal);
									line = s.nextLine();
								}
								insert(enclosure, special);
								line = s.nextLine();
								break;
							default:
								System.out.println("Error: Invalid Type:" + enclosure);
								break;
							}
						}
					}
				}
			} 
			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			} 
		}
	}

	@Override
	public String toString() {
		String str = zooName + "\n";
		for (Entry<String, Enclosure> enclosure : myEnclosures.entrySet()) {
			str += enclosure.getValue() + "\n";
		}
		return str;
	}
	
	public String getZooName() {
		return zooName;
	}

	public Enclosure getEnclosure(String name) {
		Enclosure enclosure = retrieve(name);
		return enclosure;
	}

	public Animal getEnclosureAnimal(String name, String id) {
		Enclosure enclosure = retrieve(name);
		if (null != enclosure) {
			return enclosure.getAnimal(id);
		}
		return null;
	}
}