
public class StandardEnclosure extends AnimalEnclosure {
	String enclosureName;
	String enclosureManager;
	String enclosureOpeningTime;
	String enclosureClosingTime;
	
	public StandardEnclosure(String _name, double _weight, double _price, String _enclosureName, String _manager, String _openingTime, String _closingTime) {
		super(_name, _weight, _price);
		setEnclosureName(_enclosureName);
		setEnclosureManager(_manager);
		setOpeningTime(_openingTime);
		setClosingTime(_closingTime);
	}
	
	public void setEnclosureName(String _enclosureName) {
		this.enclosureName = _enclosureName;
	}
	
	public void setEnclosureManager(String _manager) {
		this.enclosureManager = _manager;
	}
	
	public void setOpeningTime(String _openingTime) {
		this.enclosureOpeningTime = _openingTime;
	}
	
	public void setClosingTime(String _closingTime) {
		this.enclosureClosingTime = _closingTime;
	}
	

	@Override
	public double getVeiwingPrice() {
		return this.veiwingPrice;  // the price no change
	}
	
	@Override
	public String getName() {
		return super.getName();
	}
	
	@Override
	public double getWeight() {
		return super.getWeight();
	}
	
	public String getEnclosureName() {
		return this.enclosureName;
	}
	
	public String getEnclosureManager() {
		return this.enclosureManager;
	}
	
	public String getOpeningTime() {
		return this.enclosureOpeningTime;
	}
	
	public String getClosingTime() {
		return this.enclosureClosingTime;
	}
	
	public String getOpeningHours() {
		return "Opening Hours: " + getOpeningTime() + " to " + getClosingTime();
	}
	
	@Override
	public String toString() {
		return " " + this.animalName + " " + this.animalWeight + "kg $" + this.getVeiwingPrice();
	}
}
