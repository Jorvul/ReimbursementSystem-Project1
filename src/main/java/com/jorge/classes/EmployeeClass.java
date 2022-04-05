package com.jorge.classes;

public class EmployeeClass {
	
	private int employeeId;
	private String employeeName;
	private String employeeTitle;
	private String username;
	private String password;
	
	public EmployeeClass() {
		super();
	}

	public EmployeeClass(int employeeId, String employeeName, String employeeTitle, String username, String password) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeTitle = employeeTitle;
		this.username = username;
		this.password = password;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeTitle() {
		return employeeTitle;
	}

	public void setEmployeeTitle(String employeeTitle) {
		this.employeeTitle = employeeTitle;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "EmployeeClass [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeTitle="
				+ employeeTitle + ", username=" + username + ", password=" + password + "]";
	}

}
