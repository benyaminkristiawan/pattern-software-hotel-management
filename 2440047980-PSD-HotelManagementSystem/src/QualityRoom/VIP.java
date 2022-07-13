package QualityRoom;

public class VIP implements RoomQuality {
	private boolean hasTV;
	private boolean hasToilet;
	private boolean hasAC;
    private boolean hasWIFI;
    private boolean hasGizer;
    private boolean hasRefreshment;
    private boolean hasLuxuryDesign;
	
	public VIP(boolean hasTV, boolean hasToilet, boolean hasAC, boolean hasWIFI, boolean hasGizer,
			boolean hasRefreshment, boolean hasLuxuryDesign) {
		super();
		this.hasTV = hasTV;
		this.hasToilet = hasToilet;
		this.hasAC = hasAC;
		this.hasWIFI = hasWIFI;
		this.hasGizer = hasGizer;
		this.hasRefreshment = hasRefreshment;
		this.hasLuxuryDesign = hasLuxuryDesign;
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

	public boolean isHasWIFI() {
		return hasWIFI;
	}

	public void setHasWIFI(boolean hasWIFI) {
		this.hasWIFI = hasWIFI;
	}

	public boolean isHasGizer() {
		return hasGizer;
	}

	public void setHasGizer(boolean hasGizer) {
		this.hasGizer = hasGizer;
	}

	public boolean isHasRefreshment() {
		return hasRefreshment;
	}

	public void setHasRefreshment(boolean hasRefreshment) {
		this.hasRefreshment = hasRefreshment;
	}

	public boolean isHasLuxuryDesign() {
		return hasLuxuryDesign;
	}

	public void setHasLuxuryDesign(boolean hasLuxuryDesign) {
		this.hasLuxuryDesign = hasLuxuryDesign;
	}

	@Override
	public int calculatePrice(int baseprice) {
		// TODO Auto-generated method stub
		return baseprice+(40/100*baseprice);
	}
	
}
