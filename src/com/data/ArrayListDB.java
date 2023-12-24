package com.data;

import com.blueprint.Employee;

import java.util.ArrayList;
import java.util.List;


public class ArrayListDB implements DataBase{


    private List<Employee> emplist = new ArrayList<Employee>();

    @Override
    public void addEmployee(Employee e) {
        emplist.add(e);

    }

    @Override
    public List<Employee> viewAll() {
        return emplist;
    }



    @Override
    public Employee viewEmp(int empId) {
        Employee emp = null;
        for (int i = 0; i < emplist.size(); i++) {
            emp = emplist.get(i);
            if (empId == emp.getEmpID()) {
                break;
            }
        }
        return emp;
    }

    @Override
    public Employee delEmp(int empId){
        Employee deletedEmp = null;
        for (int i = 0; i < emplist.size(); i++) {
            Employee emp = emplist.get(i);
            if (empId == emp.getEmpID()) {
                deletedEmp= emplist.remove(i);
                break;
            }
        }
        return deletedEmp;
    }
}


