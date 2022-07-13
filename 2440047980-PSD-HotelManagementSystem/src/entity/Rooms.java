package entity;

public class Rooms {
	private Integer roomID;
	private String bedTypeID;
	private String qualityRoomsID;
	private String acommodationID;
	public Rooms(Integer roomID, String bedTypeID, String qualityRoomsID, String acommodationID) {
		super();
		this.roomID = roomID;
		this.bedTypeID = bedTypeID;
		this.qualityRoomsID = qualityRoomsID;
		this.acommodationID = acommodationID;
	}
	public Integer getRoomID() {
		return roomID;
	}
	public String getBedTypeID() {
		return bedTypeID;
	}
	public String getQualityRoomsID() {
		return qualityRoomsID;
	}
	public String getAcommodationID() {
		return acommodationID;
	}
	
}
