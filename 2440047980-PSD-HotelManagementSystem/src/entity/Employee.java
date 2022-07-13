package entity;

public class Employee {
	private String employeeID;
	private String employeeTypeID;
	private String employeeName;
	private Integer employeeAge;
	public Employee(String employeeID, String employeeTypeID, String employeeName, Integer employeeAge) {
		super();
		this.employeeID = employeeID;
		this.employeeTypeID = employeeTypeID;
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public String getEmployeeTypeID() {
		return employeeTypeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Integer getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(Integer employeeAge) {
		this.employeeAge = employeeAge;
	}
	
	
}
