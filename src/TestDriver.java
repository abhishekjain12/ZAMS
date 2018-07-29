import java.util.ArrayList;

public class TestDriver {

	ArrayList<Enclosure> allMyAnimals = null;
	
	public TestDriver() {
		allMyAnimals = new ArrayList<Enclosure>(); // enable testing possibility of a list of enclosure
	}

	public void test1() {	
		Enclosure e = new Enclosure();
		
		e.loadEnclosure();
		
		allMyAnimals.add(e) ;
		
		for (AnimalEnclosure animal : e.getAnimals().animals)
			System.out.println(animal);
	}

	public static void main (String [] args) {		
		TestDriver d = new TestDriver();
		d.test1();
	}
}
