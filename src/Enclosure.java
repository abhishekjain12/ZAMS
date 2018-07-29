import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Enclosure {

	private EnclosureAnimalDatabase animals;
	private String zooName;
	
	public Enclosure() {
		this.animals = new EnclosureAnimalDatabase();
		this.zooName="unknown";
	}

	public void loadEnclosure() {
		String line;
		File f;
		Scanner s;
		AnimalEnclosure _anEntry;
		String animalEntry;
		double weight;
		String enclosureType;
		String enclosureName;
		String enclosureManager;
		String openingTime;
		String closingTime;
		double price;
		
		f = new File("MyZoo.txt");
		
		try {
			FileInputStream fis = new FileInputStream(f);
			s = new Scanner(fis);			
			
			this.zooName = s.nextLine();  // read zoo name first

				line =  s.nextLine();
			while (s.hasNext()) {
			
				if (! line.equalsIgnoreCase("END"))  {  // read each menu item details until hit "END"
					enclosureType = line;
					
					if (enclosureType.equalsIgnoreCase("Premium Enclosure")) { 
						line = s.nextLine();
						
						if (! line.equalsIgnoreCase("End-enclosure")) {
							enclosureName = line;
							enclosureManager = s.nextLine();
							openingTime = s.nextLine();
							closingTime = s.nextLine();
							price = s.nextDouble();
							line = s.nextLine();
							line = s.nextLine();
							
							while (! line.equalsIgnoreCase("End-enclosure")) {
								animalEntry = line;
								weight = s.nextDouble();
								line = s.nextLine();
								_anEntry = new PremiumEnclosure(animalEntry, weight, price, enclosureName, enclosureManager, openingTime, closingTime);
								this.animals.insert(_anEntry);
								line = s.nextLine();
							}
						}
					}
					else if (enclosureType.equalsIgnoreCase("Nocturnal Enclosure")) {
						line = s.nextLine();
						
						if (! line.equalsIgnoreCase("End-enclosure")) {
							enclosureName = line;
							enclosureManager = s.nextLine();
							openingTime = s.nextLine();
							closingTime = s.nextLine();
							price = s.nextDouble();
							line = s.nextLine();
							line = s.nextLine();
							
							while (! line.equalsIgnoreCase("End-enclosure")) {
								animalEntry = line;
								weight = s.nextDouble();
								line = s.nextLine();
								_anEntry = new NocturnalEnclosure(animalEntry, weight, price, enclosureName, enclosureManager, openingTime, closingTime);
								this.animals.insert(_anEntry);
								line = s.nextLine();
							}
						}
					}
					else {
						line = s.nextLine();
						
						if (! line.equalsIgnoreCase("End-enclosure")) {
							enclosureName = line;
							enclosureManager = s.nextLine();
							openingTime = s.nextLine();
							closingTime = s.nextLine();
							price = s.nextDouble();
							line = s.nextLine();
							line = s.nextLine();
							
							while (! line.equalsIgnoreCase("End-enclosure")) {
								animalEntry = line;
								weight = s.nextDouble();
								line = s.nextLine();
								_anEntry = new StandardEnclosure(animalEntry, weight, price, enclosureName, enclosureManager, openingTime, closingTime);
								this.animals.insert(_anEntry);
								line = s.nextLine();
							}
						}
					} 
					
				   line = s.nextLine();  // read next line of input
				}
			}		
		}
		catch (Exception e) {
			System.err.println("Error with file input " + f.getAbsolutePath());
			e.printStackTrace();
		}
	}	

	public String getZooName() {
		return this.zooName;
	}

	public void setZooName(String _name) {
		this.zooName = _name;
	}
	
	public EnclosureAnimalDatabase getAnimals() {
		return this.animals;
	}
}