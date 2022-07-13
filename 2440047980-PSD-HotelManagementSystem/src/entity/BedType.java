package entity;

public class BedType {
	private String bedTypeID;
	private String bedTypeName;
	private String bedTypeDetails;
	public BedType(String bedTypeID, String bedTypeName, String bedTypeDetails) {
		super();
		this.bedTypeID = bedTypeID;
		this.bedTypeName = bedTypeName;
		this.bedTypeDetails = bedTypeDetails;
	}
	public String getBedTypeID() {
		return bedTypeID;
	}
	public void setBedTypeID(String bedTypeID) {
		this.bedTypeID = bedTypeID;
	}
	public String getBedTypeName() {
		return bedTypeName;
	}
	public void setBedTypeName(String bedTypeName) {
		this.bedTypeName = bedTypeName;
	}
	public String getBedTypeDetails() {
		return bedTypeDetails;
	}
	public void setBedTypeDetails(String bedTypeDetails) {
		this.bedTypeDetails = bedTypeDetails;
	}
	
}
