package entity;

public class Customer {
	private String customerID;
	private String customerTypeID;
	private String customerName;
	private String customerEmail;
	private Integer customerAge;
	
	public Customer(String customerID, String customerTypeID, String customerName, String customerEmail,
			Integer customerAge) {
		super();
		this.customerID = customerID;
		this.customerTypeID = customerTypeID;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerAge = customerAge;
	}
	public String getCustomerID() {
		return customerID;
	}

	public String getCustomerTypeID() {
		return customerTypeID;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public Integer getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(Integer customerAge) {
		this.customerAge = customerAge;
	}
	
}
