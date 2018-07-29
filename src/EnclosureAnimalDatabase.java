import java.util.ArrayList;

public class EnclosureAnimalDatabase {

public	ArrayList<AnimalEnclosure> animals ;
	
	public EnclosureAnimalDatabase() {
		this.animals = new ArrayList<AnimalEnclosure>();
	}
	
	public void insert(AnimalEnclosure _anAnimal) {  // needs two parameters instead of one 
		this.animals.add(_anAnimal);
	}

	public AnimalEnclosure retrieve(int key) { 
		
		if (animals.size() > key)   //  if size is 5 then key can go up to 4 only
			return animals.get(key);
		else return null;
	}
}