package EnclosureManagementSystem;

public class Standard extends Enclosure{
	
	public Standard(String name){
		super(name);	
	}
	public String toString(){
		return super.toString();
	}
	
	@Override
	public double getPrice() {
		return super.getPrice();
	}
	
	@Override
	public String getOpeningHours() {
		return super.getOpeningHours(); 
	}	
}