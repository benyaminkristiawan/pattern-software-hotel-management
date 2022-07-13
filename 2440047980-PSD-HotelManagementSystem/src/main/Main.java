package main;

import java.time.LocalDate;
import java.util.Scanner;

import database.Repository;
import entity.Customer;
import entity.Employee;
import entity.Rooms;
import entity.Transaction;



public class Main {
	private Scanner scan;
	private Repository repo;
	public Main() {
		// TODO Auto-generated constructor stub
			scan = new Scanner(System.in);
			repo = Repository.getInstance();
			
			int choose=0;
			
			while (true) {
				
				System.out.println("Welcome Admin Hotel ABC!");
				System.out.println("1. Do Transactions");
				System.out.println("2. View All Transactions");
				System.out.println("3. Delete Transactions");
				System.out.println("4. Add Customer");
				System.out.println("5. Delete and Update Customer");
				System.out.println("6. add Employee");
				System.out.println("7. Delete and Update Employee");
				System.out.println("8. Exit");
				System.out.println(">>");
				
				choose = scan.nextInt();scan.nextLine();
				
				switch (choose) {
				case 1:
					doTransactions();
					break;
				case 2:
					viewTransactions();
					break;
				case 3:
					deleteTransactions();
					break;
				case 4:
					addCustomer();
					break;
				case 5:
					changeCustomer();
					break;
				case 6:
					addEmployee();
					break;
				case 7:
					changeEmployee();
					break;
				case 8:
					System.out.println("Thankyou, See ya!");
					System.exit(0);
					break;
				
				}
			}
		}

	public void changeEmployee() {
		// TODO Auto-generated method stub
		String c;
		do {
			System.out.println("Update | Delete [Case Insensitive] >> ");
			c =scan.nextLine();
		} while (!(c.equalsIgnoreCase("DELETE")||c.equalsIgnoreCase("UPDATE")));
		if(c.equalsIgnoreCase("DELETE")) {
			for(Employee e : repo.getEmployee()) {
				System.out.println(String.format("| %-5s | %-30s | %-7s | %-10d |",
						e.getEmployeeID(),e.getEmployeeName(),e.getEmployeeTypeID(),e.getEmployeeAge()));
			}
			
			String EmployeeID;
			do {
				System.out.println("Input the EmployeeID you want to delete : ");
				EmployeeID=scan.nextLine();
			} while (!repo.checkingExist(EmployeeID, "EmployeeID", "employee"));
			repo.deleteEmployee(EmployeeID);
			System.out.println("The employee has been deleted...");
		}else if (c.equalsIgnoreCase("UPDATE")) {
			for(Employee e : repo.getEmployee()) {
				System.out.println(String.format("| %-5s | %-30s | %-7s | %-10d |",
						e.getEmployeeID(),e.getEmployeeName(),e.getEmployeeTypeID(),e.getEmployeeAge()));
			}
			String EmployeeID;
			do {
				System.out.println("Input the EmployeeID you want to update : ");
				EmployeeID=scan.nextLine();
			} while (!repo.checkingExist(EmployeeID, "EmployeeID", "employee"));
			
			String EmployeeType;
			do {
				repo.loadEmployeeType();
				repo.printEmployeeTypeData();
				System.out.println("Input your EmployeeTypeID : ");
				EmployeeType =scan.nextLine();
			} while (!repo.checkingExist(EmployeeType, "EmployeeTypeID", "employeetype"));
			repo.updateEmployee(EmployeeID,EmployeeType);
			System.out.println("The product price has been updated...");
			
		}
	}

	public void addEmployee() {
		// TODO Auto-generated method stub
		String EmployeeType;
		do {
			repo.loadEmployeeType();
			repo.printEmployeeTypeData();
			System.out.println("Input your EmployeeTypeID : ");
			EmployeeType =scan.nextLine();
		} while (!repo.checkingExist(EmployeeType, "EmployeeTypeID", "employeetype"));
		System.out.println();
		
		String EmployeeName;
		do {
			System.out.println("Input your Name : ");
			EmployeeName =scan.nextLine();
		} while (EmployeeName.isEmpty());
		System.out.println();
		
		Integer EmployeeAge;
		do {
			System.out.println("Input your Age : ");
			EmployeeAge =scan.nextInt();scan.nextLine();
		} while (!(EmployeeAge>1));
		System.out.println();
		repo.insertEmployee(EmployeeType,EmployeeName,EmployeeAge);
		System.out.println("Employee added successfully!!!");
	}

	public void changeCustomer() {
		// TODO Auto-generated method stub
		String c;
		do {
			System.out.println("Update | Delete [Case Insensitive] >> ");
			c =scan.nextLine();
		} while (!(c.equalsIgnoreCase("DELETE")||c.equalsIgnoreCase("UPDATE")));
		if(c.equalsIgnoreCase("DELETE")) {
			for(Customer c1 : repo.getCustomers()) {
				System.out.println(String.format("| %-5s | %-30s | %-7s |%-22s | %-10d |",
						c1.getCustomerID(),c1.getCustomerName(),c1.getCustomerTypeID(),c1.getCustomerEmail(),c1.getCustomerAge()));
			}
			
			String CustomerID;
			do {
				System.out.println("Input the CustomerID you want to delete : ");
				CustomerID=scan.nextLine();
			} while (!repo.checkingExist(CustomerID, "CustomerID", "customer"));
			repo.deleteCustomer(CustomerID);
			System.out.println("The Customer has been deleted...");
		}else if (c.equalsIgnoreCase("UPDATE")) {
			for(Customer c1 : repo.getCustomers()) {
				System.out.println(String.format("| %-5s | %-30s | %-7s |%-22s | %-10d |",
						c1.getCustomerID(),c1.getCustomerName(),c1.getCustomerTypeID(),c1.getCustomerEmail(),c1.getCustomerAge()));
			}
			
			String CustomerID;
			do {
				System.out.println("Input the CustomerID you want to delete : ");
				CustomerID=scan.nextLine();
			} while (!repo.checkingExist(CustomerID, "CustomerID", "customer"));
			
			String CustomerType;
			do {
				repo.loadCustomerType();
				repo.printCustomerTypeData();
				System.out.println("Input your CustomerTypeID : ");
				CustomerType =scan.nextLine();
			} while (!repo.checkingExist(CustomerType, "EmployeeTypeID", "employeetype"));
			repo.updateCustomer(CustomerID,CustomerType);
			System.out.println("The product price has been updated...");
			
		}
	
	}

	public void addCustomer() {
		// TODO Auto-generated method stub
		String CustomerID;
		do {
			System.out.println("Please input your CivilizationID (KTP/PassportID) [Must be 16 digit]...");
			System.out.println("Input your CustomerID : ");
			CustomerID =scan.nextLine();
		} while (!(CustomerID.length()<17)||!(CustomerID.length()>15));
		System.out.println();
		
		String CustomerType;
		do {
			repo.loadCustomerType();
			repo.printCustomerTypeData();
			System.out.println("Input your CustomerTypeID : ");
			CustomerType =scan.nextLine();
		} while (!repo.checkingExist(CustomerType, "CustomerTypeID", "customertype"));
		System.out.println();
		
		String CustomerName;
		do {
			System.out.println("Input your Name : ");
			CustomerName =scan.nextLine();
		} while (CustomerName.isEmpty());
		System.out.println();
		
		String CustomerEmail;
		do {
			System.out.println("Input your Email : [contains @]");
			CustomerEmail =scan.nextLine();
		} while (!(CustomerEmail.contains("@")));
		System.out.println();
		
		Integer CustomerAge;
		do {
			System.out.println("Input your Age : ");
			CustomerAge =scan.nextInt();scan.nextLine();
		} while (!(CustomerAge>1));
		System.out.println();
		repo.insertCustomer(CustomerID,CustomerType,CustomerName,CustomerEmail,CustomerAge);
		System.out.println("Customer added successfully!!!");
	}
	

	public void deleteTransactions() {
		// TODO Auto-generated method stub
		viewTransactions();
		String TransactionID;
		do {
			System.out.println("Input the TransactionID you want to delete : ");
			TransactionID=scan.nextLine();
		} while (!repo.checkingExist(TransactionID, "TransactionID", "transaction"));
		repo.deleteTransaction(TransactionID);
		System.out.println("Transaction has been deleted..");
	}
	public void viewCustomer() {
		System.out.println("===============Customer List===================");
		for(Customer c : repo.getCustomers()) {
			System.out.println(String.format("| %-30s | %-10s | %-25s | %-25s | %-10d |", c.getCustomerID(),c.getCustomerTypeID(),c.getCustomerName(),c.getCustomerEmail(),c.getCustomerAge()));
		}
	}
	public void viewTransactions() {
		// TODO Auto-generated method stub
		System.out.println("================================================TRANSACTION LIST================================================");
		for (Transaction transaction : repo.getTransactions()) {
			System.out.println(String.format("| %-5s | %-20s | %-4d | %-16s | %-10s |", 
					transaction.getTransactionID(), transaction.getCustomerName(),transaction.getRoomsID(),transaction.getCheckinDate(),transaction.getCheckoutDate()));
		}
	}
	
	public void doTransactions() {
		// TODO Auto-generated method stub
		String CustomerID;
		do {
			viewCustomer();
			System.out.println("Input your CustomerID : ");
			CustomerID =scan.nextLine();
		} while (!repo.checkingExist(CustomerID, "CustomerID", "customer"));
		
		System.out.println();
		System.out.println("================================================ROOM AVAILABLE================================================");
		for (Rooms r : repo.getRooms()) {
			System.out.println(String.format("| %-5d | %-20s | %-10s | %-10s |", 
		r.getRoomID(),r.getBedTypeID(),r.getQualityRoomsID(),r.getAcommodationID()));	
		}
		Integer roomID;
		String a,qr,bt;
		do {
			System.out.println("Input your BetType Name : ");
			bt=scan.nextLine();
			System.out.println("Input your Quality Rooms : ");
			qr=scan.nextLine();
			System.out.println("Input your Level Accomodation : ");
			a=scan.nextLine();
			System.out.println("Input your roomID : ");
			roomID =scan.nextInt();scan.nextLine();
		} while (!repo.checkingExists(roomID, "RoomID", "rooms"));
		System.out.println();
		
		String checkinDate = LocalDate.now().toString();
		String checkoutDate;
		do {
			System.out.println("Input your check out Date : [yyyy-mm-dd]");
			checkoutDate =scan.nextLine();
		} while (checkoutDate.startsWith("2022"));
		
		repo.InsertTransaction(CustomerID,roomID,checkinDate,checkoutDate);
		System.out.println("Transaction has been successful");
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
