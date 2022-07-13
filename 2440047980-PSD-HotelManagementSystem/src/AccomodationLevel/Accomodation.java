package AccomodationLevel;

public class Accomodation {
	private String accomodationID;
	
	public Accomodation(String accomodationID) {
		super();
		this.accomodationID = accomodationID;
	}

	public String getAccomodationID() {
		return accomodationID;
	}
	
	public LevelAccomodation getLevel(String LevelType) {
		if(LevelType == null){
	         return null;
	      }		
	      if(LevelType.equalsIgnoreCase("REGULAR")){
	         return new Regular(true);
	         
	      } else if(LevelType.equalsIgnoreCase("SUITE")){
	         return new Suite(true, true);
	         
	      } else if(LevelType.equalsIgnoreCase("APARTMENT")){
	         return new Apartment(true, true, true);
	      }
		
		return null;
		
	}
}
