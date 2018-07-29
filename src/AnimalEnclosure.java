
public abstract class AnimalEnclosure {
	String animalName;
    double animalWeight;
    double veiwingPrice;
    final double DEFAULTPRICE = 10.00; // default min price

	public AnimalEnclosure(String _name, double _weight, double _veiwingPrice) {
		this.setName(_name);
		this.setWeight(_weight);
		this.setVeiwingPrice(_veiwingPrice);
	}
	
	private void setName(String _name) {
		this.animalName = _name;
	}

	public void setWeight(double _weight) {
			this.animalWeight = _weight;
	}
	
	public void setVeiwingPrice(double _veiwingPrice) {
		if (_veiwingPrice > DEFAULTPRICE)
			this.veiwingPrice = _veiwingPrice;
		else 
			this.veiwingPrice = DEFAULTPRICE;
	}
	
	public String getName() {
		return this.animalName;
	}
	
	public double getWeight() {
		return this.animalWeight;
	}
	
	public abstract double getVeiwingPrice();
	
	public String toString() {
		return " " + this.animalName + " " +  this.animalWeight + "kg $" + this.veiwingPrice;
	}
}