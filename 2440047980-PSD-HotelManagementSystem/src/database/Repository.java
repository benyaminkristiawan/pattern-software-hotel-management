package database;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import QualityRoom.QualityRooms;
import entity.Customer;
import entity.CustomerType;
import entity.Employee;
import entity.EmployeeType;
import entity.Rooms;
import entity.Transaction;

public class Repository {
	//singleton design pattern
		private static Repository instance;
		private Connect connect;
		
		private Repository() {
			connect=Connect.getConnection();
		}
		
		public static Repository getInstance() {
			if (instance==null) instance = new Repository();
			return instance;
		}
		
		ArrayList<CustomerType> customerTypeList = new ArrayList<>();
		ArrayList<EmployeeType> employeeTypeList = new ArrayList<>();
		
		public String generateNewTransactionID() {
			String nextID ="";
			try {
				String query = "SELECT `TransactionID` FROM `transaction` \r\n" + 
						"ORDER BY `TransactionID` DESC LIMIT 1";
				ResultSet res = connect.executeQuery(query);
				if(res.next()) {
					nextID=res.getString("TransactionID");
					Integer idInt = Integer.parseInt(nextID.substring(2))+1;
					nextID= String.format("TR%03d", idInt);
				}else {
					nextID = "TR001";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return nextID;
		}
		public String generateNewEmployeeID() {
			String nextID ="";
			try {
				String query = "SELECT `EmployeeID` FROM `employee` \r\n" + 
						"ORDER BY `EmployeeID` DESC LIMIT 1";
				ResultSet res = connect.executeQuery(query);
				if(res.next()) {
					nextID=res.getString("EmployeeID");
					Integer idInt = Integer.parseInt(nextID.substring(2))+1;
					nextID= String.format("EM%03d", idInt);
				}else {
					nextID = "EM001";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return nextID;
		}
		
		public boolean checkingExist(String id, String cName,String tName) {
			try {
				String query = String.format("SELECT null FROM `%s` WHERE `%s`= '%s'", tName,cName,id);
				ResultSet res = connect.executeQuery(query);
				if (res.next()) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Your input is Wrong! Please Try Again...");
			return false;
		}
		
		public boolean checkingExists(Integer roomID, String string,String string2) {
			try {
				String query = String.format("SELECT null FROM `%s` WHERE `%s`= '%s'", string2,string,roomID);
				ResultSet res = connect.executeQuery(query);
				if (res.next()) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Your input is Wrong! Please Try Again...");
			return false;
		}
		public boolean checkingRooms(String qr, String a, String bt) {
			try {
				String query = String.format("SELECT `RoomID` FROM `rooms` r\r\n" + 
						"JOIN bedtype bt ON bt.BedTypeID=r.BedTypeID\r\n" + 
						"JOIN qualityrooms q ON q.QualityRoomsID=r.QualityRoomsID\r\n" + 
						"JOIN accomodation a ON a.AccomodationID=r.AccomodationID\r\n" + 
						"WHERE bt.BedTypeName= `%s` AND q.QualityRooms=`%s` AND a.AccomodationLevel=`%s`", bt,qr,a);
				ResultSet res = connect.executeQuery(query);
				if (res.next()) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Your input is Wrong! Please Try Again...");
			return false;
		}
		
		public ArrayList<Transaction> getTransactions(){
			ArrayList<Transaction> transactions = new ArrayList<>();
			try {
				String query ="SELECT `TransactionID`, c.CustomerName, R.RoomID,T.CheckinDate,T.CheckoutDate FROM `transaction` t\r\n" + 
						"JOIN customer c ON c.CustomerID=t.CustomerID\r\n" + 
						"JOIN rooms r ON r.RoomID=t.RoomsID";
				ResultSet res = connect.executeQuery(query);
				String transactionID, customerName;Integer RoomID;
				Date checkinDate, checkoutDate;
				while(res.next()) {
					transactionID=res.getString("TransactionID");
					customerName=res.getString("CustomerName");
					RoomID=res.getInt("RoomID");
					checkinDate=res.getDate("CheckinDate");
					checkoutDate=res.getDate("CheckoutDate");
					transactions.add(new Transaction(transactionID, customerName, RoomID, checkinDate, checkoutDate));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return transactions;
		}
		public ArrayList<Customer> getCustomers() {
			ArrayList<Customer> customers = new ArrayList<>();
			try {
				String query ="SELECT `CustomerID`, ct.CustomerType, `CustomerName`, `CustomerEmail`, `CustomerAge` \r\n" + 
						"FROM `customer` c\r\n" + 
						"JOIN customertype ct ON ct.CustomerTypeID=c.CustomerTypeID";
				ResultSet res = connect.executeQuery(query);
				String customerID, customerType,customerName,customerEmail;Integer customerAge;
				while(res.next()) {
					customerID=res.getString("customerID");
					customerType=res.getString("CustomerType");
					customerName=res.getString("CustomerName");
					customerEmail=res.getString("CustomerEmail");
					customerAge=res.getInt("CustomerAge");
					customers.add(new Customer(customerID, customerType, customerName, customerEmail, customerAge));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return customers;
		}
		
		public ArrayList<Employee> getEmployee() {
			ArrayList<Employee> employees = new ArrayList<>();
			try {
				String query ="SELECT `EmployeeID`, et.EmployeeType, `EmployeeName`, `EmployeeAge` \r\n" + 
						"FROM `employee` e \r\n" + 
						"JOIN employeetype et ON et.EmployeeTypeID=e.EmployeeTypeID";
				ResultSet res = connect.executeQuery(query);
				String employeeID, employeeType,employeeName;Integer employeeAge;
				while(res.next()) {
					employeeID=res.getString("EmployeeID");
					employeeType=res.getString("EmployeeType");
					employeeName=res.getString("EmployeeName");
					employeeAge=res.getInt("EmployeeAge");
					employees.add(new Employee(employeeID, employeeType, employeeName, employeeAge));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return employees;
		}
		public ArrayList<Rooms> getRooms(){
			ArrayList<Rooms> roomies = new ArrayList<>();
			try {
				String bt,qr,a;
					String query = String.format("SELECT `RoomID` ,bt.BedTypeName, q.QualityRooms, a.AccomodationLevel FROM `rooms` r\r\n" + 
							"JOIN bedtype bt ON bt.BedTypeID=r.BedTypeID\r\n" + 
							"JOIN qualityrooms q ON q.QualityRoomsID=r.QualityRoomsID\r\n" + 
							"JOIN accomodation a ON a.AccomodationID=r.AccomodationID");
					ResultSet res = connect.executeQuery(query);
					Integer RoomID; String bedname,qrooms,alevel;
				while(res.next()) {
				RoomID=res.getInt("RoomID");
				bedname=res.getString("BedTypeName");
				qrooms=res.getString("QualityRooms");
				alevel=res.getString("AccomodationLevel");
						roomies.add(new Rooms(RoomID, bedname, qrooms, alevel));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return roomies;
		
		}
		public void loadCustomerType() {
			String customerTypeID, customerType, privileges;
			String query = "SELECT * FROM customertype";
			ResultSet res = connect.executeQuery(query);
			try {
				while(res.next()) {
					customerTypeID=res.getString("CustomerTypeID");
					customerType =res.getString("CustomerType");
					privileges=res.getString("Privileges");
					if (privileges==null)privileges="-";
					
					CustomerType curr = new CustomerType(customerTypeID, customerType, privileges);
					customerTypeList.add(curr);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void printCustomerTypeData() {
			for (CustomerType ct : customerTypeList) {
				System.out.println("CustomerTypeID : "+ct.getCustomerTypeID());
				System.out.println("CustomerType : "+ct.getCustomerType());
				System.out.println("Privileges : "+ct.getPrivileges());
				System.out.println();
			}
		}
		
		public void loadEmployeeType() {
			String employeeTypeID, employeeType, jobDesk;
			String query = "SELECT * FROM employeetype";
			ResultSet res = connect.executeQuery(query);
			try {
				while(res.next()) {
					employeeTypeID=res.getString("EmployeeTypeID");
					employeeType =res.getString("EmployeeType");
					jobDesk=res.getString("JobDesk");
					if (jobDesk==null)jobDesk="-";
					
					EmployeeType curr = new EmployeeType(employeeTypeID, employeeType, jobDesk);
					employeeTypeList.add(curr);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void printEmployeeTypeData() {
			for (EmployeeType et : employeeTypeList) {
				System.out.println("EmployeeTypeID : "+et.getEmployeeTypeID());
				System.out.println("EmployeeType : "+et.getEmployeeType());
				System.out.println("Job Desk : "+et.getJobDesk());
				System.out.println();
			}
		}

		public void insertCustomer(String customerID, String customerType, String customerName, String customerEmail,
				Integer customerAge) {
			// TODO Auto-generated method stub
			String query = String.format("INSERT INTO `customer`(`CustomerID`, `CustomerTypeID`, `CustomerName`, `CustomerEmail`, `CustomerAge`) VALUES \r\n" + 
					"('%s','%s','%s','%s','%d')", customerID,customerType,customerName,customerEmail,customerAge);
			connect.executeUpdate(query);
		}

		public void insertEmployee(String employeeType, String employeeName, Integer employeeAge) {
			// TODO Auto-generated method stub
			String query =String.format("INSERT INTO `employee`(`EmployeeID`, `EmployeeTypeID`, `EmployeeName`, `EmployeeAge`) VALUES \r\n" + 
					"('%s','%s','%s','%d')", generateNewEmployeeID(),employeeType,employeeName,employeeAge);
			connect.executeUpdate(query);
		}

		public void deleteTransaction(String transactionID) {
			// TODO Auto-generated method stub
			String query = String.format("DELETE FROM `transaction` WHERE TransactionID = '%s'", transactionID);
			connect.executeUpdate(query);
		}

		public void deleteEmployee(String employeeID) {
			// TODO Auto-generated method stub
			String query=String.format("DELETE FROM `employee` \r\n" + 
					"WHERE EmployeeID = '%s' ", employeeID);
			connect.executeUpdate(query);
		}

		public void updateEmployee(String employeeID, String employeeType) {
			// TODO Auto-generated method stub
			String query =String.format("UPDATE `employee` SET `EmployeeTypeID`='%d' WHERE EmployeeID = '%s'", employeeType,employeeID);
			connect.executeUpdate(query); 
		}

		public void deleteCustomer(String customerID) {
			// TODO Auto-generated method stub
			String query=String.format("DELETE FROM `customer` \r\n" + 
					"WHERE CustomerID = '%s' ", customerID);
			connect.executeUpdate(query);
		}

		public void updateCustomer(String customerID, String customerType) {
			// TODO Auto-generated method stub
			String query =String.format("UPDATE `customer` SET `CustomerTypeID`='%d' WHERE customerID = '%s'", customerType,customerID);
			connect.executeUpdate(query); 
		}

		public void InsertTransaction(String customerID, Integer roomID, String checkinDate, String checkoutDate) {
			// TODO Auto-generated method stub
			String query = String.format("INSERT INTO `transaction`(`TransactionID`, `CustomerID`, `RoomsID`, `CheckinDate`, `CheckoutDate`) VALUES \r\n" + 
					"('%s','%s','%d','%s,'%s')", generateNewTransactionID(),customerID,roomID,checkinDate,checkoutDate);
			connect.executeUpdate(query);
		}
}
