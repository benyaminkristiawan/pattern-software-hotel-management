package entity;

public class CustomerType {
	private String customerTypeID;
	private String customerType;
	private String privileges;
	
	public CustomerType(String customerTypeID, String customerType, String privileges) {
		super();
		this.customerTypeID = customerTypeID;
		this.customerType = customerType;
		this.privileges = privileges;
	}
	public String getCustomerTypeID() {
		return customerTypeID;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getPrivileges() {
		return privileges;
	}
	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}
	
}
