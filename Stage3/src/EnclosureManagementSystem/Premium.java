package EnclosureManagementSystem;

public class Premium extends Enclosure{
	
	private final double PREMIUM_FACTOR = 1.2;
	
	public Premium(){
		super();
		super.setOpeningHours("10.00am to 3.00pm");
	}
	
	public Premium(String name){
		super(name);
		super.setOpeningHours("10.00am to 3.00pm");
	}
	public String toString(){
		return super.toString();
	}
	
	@Override
	public double getPrice() {
		return super.getPrice() * PREMIUM_FACTOR;  // the price is increased by MARKUP factor (110%)
	}
	
	@Override
	public String getOpeningHours() {
		return super.getOpeningHours(); 
	}
}