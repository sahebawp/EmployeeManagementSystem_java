package com.data;

import com.blueprint.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySQLDB implements  DataBase {
    private String driverClass = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://database.cmyidwwmaurt.us-west-2.rds.amazonaws.com";
    private String user = "admin";
    private String password = "rootadmin";


    @Override
    public void addEmployee(Employee e) {
        try{
            Class.forName(driverClass);
            Connection con=DriverManager.getConnection(url,user,password);
            String q = "insert into development.employee(id,name,age,email,org) values(?,?,?,?,?)";
            PreparedStatement preStat = con.prepareStatement(q);
            preStat.setInt(1,e.getEmpID());
            preStat.setString(2,e.getName());
            preStat.setInt(3,e.getAge());
            preStat.setString(4,e.getEmail());
            preStat.setString(5,e.getOrg());
            preStat.executeUpdate();
            con.close();
        }catch(Exception ex){
            System.out.println(ex);
        }

    }

    @Override
    public List<Employee> viewAll() {
        List<Employee> empList = new ArrayList<Employee>();
        try{
            Class.forName(driverClass);
            Connection con=DriverManager.getConnection(url,user,password);

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from development.employee");

            while(rs.next()) {

                empList.add(new Employee(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getString("email"),rs.getString("org")));
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }

        return empList;
    }

    @Override
    public Employee viewEmp(int empId) {

        Employee emp = null;
        try{
            Class.forName(driverClass);
            Connection con=DriverManager.getConnection(url,user,password);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT employee.id,\n" +
                    "employee.name,\n" +
                    "employee.age,\n" +
                    "employee.email,\n" +
                    "employee.org\n" +
                    "FROM development.employee\n" +
                    "where employee.id = " + empId);

            while(rs.next()) {

                emp = new Employee(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getString("email"),rs.getString("org"));
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }


        return emp;
    }

    @Override
    public Employee delEmp(int empId) {
        Employee emp = null;
        try{
            Class.forName(driverClass);
            Connection con=DriverManager.getConnection(url,user,password);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT employee.id,\n" +
                    "employee.name,\n" +
                    "employee.age,\n" +
                    "employee.email,\n" +
                    "employee.org\n" +
                    "FROM development.employee\n" +
                    "where employee.id = " + empId);
            while(rs.next()) {

                emp = new Employee(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getString("email"),rs.getString("org"));
            }
            if(emp!=null){
                String q = ("DELETE FROM development.employee WHERE id = ?");
                PreparedStatement preStat = con.prepareStatement(q);
                preStat.setInt(1, empId);
                preStat.executeUpdate();
            }

            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return emp;
    }
}
