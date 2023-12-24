package com.blueprint;

public class Employee{

	public Employee(int empID, String name, int age, String email, String org) {
		super();
		this.empID = empID;
		this.name = name;
		this.age = age;
		this.email = email;
		this.org = org;
	}

	private int empID;
	private String name;
	private int age;
	private String email;
	private String org;

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ",| name=" + name + ",| age=" + age + ",| email=" + email + ",| org=" + org
				+ "]";
	}
}
