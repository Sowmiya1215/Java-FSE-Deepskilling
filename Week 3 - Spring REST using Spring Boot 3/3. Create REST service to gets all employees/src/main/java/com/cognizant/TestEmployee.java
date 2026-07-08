package com.cognizant;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeService;

public class TestEmployee {

    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();

        for (Employee employee : service.getAllEmployees()) {

            System.out.println("Id : " + employee.getId());
            System.out.println("Name : " + employee.getName());
            System.out.println("Salary : " + employee.getSalary());
            System.out.println("Permanent : " + employee.isPermanent());
            System.out.println("Department : " + employee.getDepartment().getName());
            System.out.println("Skills : " + employee.getSkillList());
            System.out.println("--------------------------------");
        }
    }
}