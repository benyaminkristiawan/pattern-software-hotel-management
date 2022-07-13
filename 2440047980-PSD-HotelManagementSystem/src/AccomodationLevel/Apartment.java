package AccomodationLevel;

public class Apartment implements LevelAccomodation{
	
	private boolean hasbed;
	private boolean hasfamilyroom;
	private boolean haskitchen;
	
	public Apartment(boolean hasbed, boolean hasfamilyroom, boolean haskitchen) {
		super();
		this.hasbed = hasbed;
		this.hasfamilyroom = hasfamilyroom;
		this.haskitchen = haskitchen;
	}
	public boolean isHasbed() {
		return hasbed;
	}
	public void setHasbed(boolean hasbed) {
		this.hasbed = hasbed;
	}
	public boolean isHasfamilyroom() {
		return hasfamilyroom;
	}
	public void setHasfamilyroom(boolean hasfamilyroom) {
		this.hasfamilyroom = hasfamilyroom;
	}
	public boolean isHaskitchen() {
		return haskitchen;
	}
	public void setHaskitchen(boolean haskitchen) {
		this.haskitchen = haskitchen;
	}
	@Override
	public int calculatePrice(int baseprice) {
		// TODO Auto-generated method stub
		return  baseprice+(50/100*baseprice);
	}
	
}
