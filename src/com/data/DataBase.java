package com.data;

import com.blueprint.Employee;

import java.util.List;

public interface DataBase {
    public void addEmployee(Employee e);
    public List<Employee> viewAll();
    public Employee viewEmp(int empId);
    public Employee delEmp(int empId);
}
