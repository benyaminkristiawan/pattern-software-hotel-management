package entity;

public class EmployeeType {
	private String employeeTypeID;
	private String employeeType;
	private String jobDesk;
	public EmployeeType(String employeeTypeID, String employeeType, String jobDesk) {
		super();
		this.employeeTypeID = employeeTypeID;
		this.employeeType = employeeType;
		this.jobDesk = jobDesk;
	}
	public String getEmployeeTypeID() {
		return employeeTypeID;
	}
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	public String getJobDesk() {
		return jobDesk;
	}
	public void setJobDesk(String jobDesk) {
		this.jobDesk = jobDesk;
	}
	
}
