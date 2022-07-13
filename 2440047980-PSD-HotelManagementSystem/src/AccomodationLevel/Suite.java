package AccomodationLevel;

public class Suite implements LevelAccomodation{
	private boolean hasbed;
	private boolean hasfamilyroom;
	
	public Suite(boolean hasbed, boolean hasfamilyroom) {
		super();
		this.hasbed = hasbed;
		this.hasfamilyroom = hasfamilyroom;
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
	@Override
	public int calculatePrice(int baseprice) {
		// TODO Auto-generated method stub
		return baseprice+(30/100*baseprice);
	}
	
}
