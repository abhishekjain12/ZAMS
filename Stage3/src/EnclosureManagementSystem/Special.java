package EnclosureManagementSystem;

public class Special extends Enclosure{
	
	private final double MARK_FACTOR = 0.8;
	
	public Special(String name){
		super(name);
		super.setOpeningHours("3.00pm to 6.00pm");
	}
	public String toString(){
		return super.toString();
	}
	
	@Override
	public double getPrice() {
		return super.getPrice() * MARK_FACTOR;  // The price decreased by MARKUP factor (80%).
	}
	
	@Override
	public String getOpeningHours() {
		return super.getOpeningHours(); 
	}
}