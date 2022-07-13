package QualityRoom;

public class QualityRooms {
	private String qualityRoomsID;

	public QualityRooms(String qualityRoomsID) {
		super();
		this.qualityRoomsID = qualityRoomsID;
	}

	public String getQualityRoomsID() {
		return qualityRoomsID;
	}

	public RoomQuality getQuality(String QualityType) {
		if(QualityType == null){
	         return null;
	      }		
	      if(QualityType.equalsIgnoreCase("Regular")){
	         return new Regular(true, true, true);
	         
	      } else if(QualityType.equalsIgnoreCase("Executive")){
	         return new Executive(true, true, true, true, true);
	         
	      } else if(QualityType.equalsIgnoreCase("VIP")){
	         return new VIP(true, true, true, true, true, true, true);
	      }
		
		return null;
	}
}
