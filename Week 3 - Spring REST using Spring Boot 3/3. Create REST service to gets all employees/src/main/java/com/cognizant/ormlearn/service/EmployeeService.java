package com.cognizant.ormlearn.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.dao.EmployeeDao;
import com.cognizant.ormlearn.model.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public ArrayList<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Transactional
    public Employee get(int id) {

        for (Employee employee : employeeDao.getAllEmployees()) {
            if (employee.getId() == id) {
                return employee;
            }
        }

        return null;
    }

    @Transactional
    public void save(Employee employee) {

        ArrayList<Employee> employeeList = employeeDao.getAllEmployees();

        boolean found = false;

        for (int i = 0; i < employeeList.size(); i++) {

            if (employeeList.get(i).getId() == employee.getId()) {
                employeeList.set(i, employee);
                found = true;
                break;
            }
        }

        if (!found) {
            employeeList.add(employee);
        }
    }
}