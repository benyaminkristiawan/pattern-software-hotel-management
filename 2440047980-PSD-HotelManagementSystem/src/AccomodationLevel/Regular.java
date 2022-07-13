package AccomodationLevel;

public class Regular implements LevelAccomodation{
	private boolean hasbed;

	
	public Regular(boolean hasbed) {
		super();
		this.hasbed = hasbed;
	}


	public boolean isHasbed() {
		return hasbed;
	}


	public void setHasbed(boolean hasbed) {
		this.hasbed = hasbed;
	}


	@Override
	public int calculatePrice(int baseprice) {
		// TODO Auto-generated method stub
		return baseprice;
	}

	
}
