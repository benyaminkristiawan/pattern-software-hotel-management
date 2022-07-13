package entity;

import java.sql.Date;

public class Transaction {
	private String transactionID;
	private String customerName;
	private Integer roomsID;
	private Date checkinDate;
	private Date checkoutDate;
	public Transaction(String transactionID, String customerName, Integer roomsID, Date checkinDate,
			Date checkoutDate) {
		super();
		this.transactionID = transactionID;
		this.customerName = customerName;
		this.roomsID = roomsID;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
	}
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getRoomsID() {
		return roomsID;
	}
	public void setRoomsID(Integer roomsID) {
		this.roomsID = roomsID;
	}
	public Date getCheckinDate() {
		return checkinDate;
	}
	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}
	public Date getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	
}
