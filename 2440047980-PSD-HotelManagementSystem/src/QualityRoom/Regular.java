package QualityRoom;

public class Regular implements RoomQuality {
	private boolean hasAC;
	private boolean hasToilet;
	private boolean hasTelevision;
	
	public Regular(boolean hasAC, boolean hasToilet, boolean hasTelevision) {
		super();
		this.hasAC = hasAC;
		this.hasToilet = hasToilet;
		this.hasTelevision = hasTelevision;
	}

	public boolean isHasAC() {
		return hasAC;
	}

	public void setHasAC(boolean hasAC) {
		this.hasAC = hasAC;
	}

	public boolean isHasToilet() {
		return hasToilet;
	}

	public void setHasToilet(boolean hasToilet) {
		this.hasToilet = hasToilet;
	}

	public boolean isHasTelevision() {
		return hasTelevision;
	}

	public void setHasTelevision(boolean hasTelevision) {
		this.hasTelevision = hasTelevision;
	}

	@Override
	public int calculatePrice(int baseprice) {
		// TODO Auto-generated method stub
		return baseprice;
	}
	
}
