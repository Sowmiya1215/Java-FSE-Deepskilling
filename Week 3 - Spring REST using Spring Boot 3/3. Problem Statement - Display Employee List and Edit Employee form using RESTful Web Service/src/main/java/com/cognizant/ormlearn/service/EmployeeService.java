package com.cognizant.ormlearn.service;

import java.util.ArrayList;

import com.cognizant.dao.EmployeeDao;
import com.cognizant.ormlearn.model.Employee;

public class EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDao();

    public ArrayList<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
}