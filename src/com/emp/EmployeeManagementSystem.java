package com.emp;

import com.blueprint.Employee;
import com.data.ArrayListDB;
import com.data.DataBase;
import com.data.MySQLDB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementSystem {


	public static void main(String[] args) {
		DataBase dbObj = new ArrayListDB();
		EmployeeManagementSystem ems = new EmployeeManagementSystem();
		while (true) {
			System.out.println("Enter your choice :- ");
			System.out.println("1.Add Employee, 2.Wish 3.View All Employee, 4.View Employee, 5.Delete Employee,  0.Exit");
			Scanner sc = new Scanner(System.in);
			int inputChoice = sc.nextInt();
			switch (inputChoice) {
			case 1:
				ems.addEmployee(dbObj);
				break;
			case 2:
				ems.wish();
				break;
			case 3:
				ems.viewAll(dbObj);
				break;
			case 4:
				ems.viewEmp(dbObj);
				break;
			case 5:
				ems.delEmp(dbObj);
				break;
			case 0:
				ems.exit();
				break;
			default:
				System.out.println("Wrong input, please try again");
				break;
			}
		}
	}

	public void addEmployee(DataBase db) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your ID");
		int empid = 0;
		boolean empidvalue = false;
		while (!empidvalue) {
			try{
				empid = sc.nextInt();
				break;
			}
			catch(Exception e){
				System.out.println("please enter integer value");
				sc.next();
			}
		}
		System.out.println("Enter your name: ");
		while(sc.hasNextInt()) {
			System.out.println("Name can't contain only numbers! Try again.....");
			sc.next();
		}
		String name = sc.next();
		System.out.println("Enter your age");
		int age = 0;
		boolean agevalue = false;
		while(!agevalue) {
			try {
				age = sc.nextInt();
				break;
			}
			catch(Exception e) {
				System.out.println("Please enter integer value");
				sc.next();
			}
		}
		System.out.println("Enter your email");
		String email = sc.next();
		System.out.println("Enter your organization");
		String org = sc.next();
		Employee emp = new Employee(empid, name, age, email, org);
		db.addEmployee(emp);
		System.out.println("Employee added is -");
		System.out.println(emp);
	}

	public void viewAll(DataBase db) {
		List<Employee> employees = db.viewAll();
		if(employees.isEmpty()) {
			System.out.println("list is empty");
		}else {
			for (int i = 0; i < employees.size(); i++) {
				Employee emp = employees.get(i);

				System.out.println(emp.toString());
			}
		}
	}

	public void wish() {
		System.out.println("Enter your name: ");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("Greetings " + name);
	}

	public void viewEmp(DataBase db) {
		System.out.println("Enter the EMP no");
		Scanner sc = new Scanner(System.in);
		int empId = sc.nextInt();
		Employee emp = db.viewEmp(empId);

		if(emp==null) {
			System.out.println("Employee not found");
		} else {
			System.out.println(emp);
		}

	}
	
	public void delEmp(DataBase db){

		System.out.println("Enter the employee num");
		Scanner sc = new Scanner(System.in);
		int empId = sc.nextInt();
		Employee deletedEmp = db.delEmp(empId);
		if(deletedEmp==null) {
			System.out.println("Employee not found");
		}else{
			System.out.println("Employee deleted: "+deletedEmp);

		}
	}

	public void exit() {
		System.exit(0);

	}

}
