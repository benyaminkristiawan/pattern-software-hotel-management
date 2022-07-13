package QualityRoom;

public class Executive implements RoomQuality{
	private boolean hasTV;
	private boolean hasToilet;
	private boolean hasAC;
	private boolean hasCooler;
	private boolean hasRefreshment;
	
	
	public Executive(boolean hasTV, boolean hasToilet, boolean hasAC, boolean hasCooler, boolean hasRefreshment) {
		super();
		this.hasTV = hasTV;
		this.hasToilet = hasToilet;
		this.hasAC = hasAC;
		this.hasCooler = hasCooler;
		this.hasRefreshment = hasRefreshment;
	}


	public boolean isHasTV() {
		return hasTV;
	}


	public void setHasTV(boolean hasTV) {
		this.hasTV = hasTV;
	}


	public boolean isHasToilet() {
		return hasToilet;
	}


	public void setHasToilet(boolean hasToilet) {
		this.hasToilet = hasToilet;
	}


	public boolean isHasAC() {
		return hasAC;
	}


	public void setHasAC(boolean hasAC) {
		this.hasAC = hasAC;
	}


	public boolean isHasCooler() {
		return hasCooler;
	}


	public void setHasCooler(boolean hasCooler) {
		this.hasCooler = hasCooler;
	}


	public boolean isHasRefreshment() {
		return hasRefreshment;
	}


	public void setHasRefreshment(boolean hasRefreshment) {
		this.hasRefreshment = hasRefreshment;
	}


	@Override
	public int calculatePrice(int baseprice) {
		// TODO Auto-generated method stub
		return baseprice+(20/100*baseprice);
	}
	    
}
