package com.cognizant.ormlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;

@SpringBootApplication
public class OrmLearnApplication {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SkillService skillService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @PostConstruct
    public void run() {

        

        testGetEmployee();

       //  testAddSkillToEmployee();
    }

    private void testGetEmployee() {

        Employee employee = employeeService.get(1);

        System.out.println("Employee : " + employee.getName());
        System.out.println("Department : " + employee.getDepartment().getName());

        System.out.println("Skills");

        for (Skill skill : employee.getSkillList()) {
            System.out.println(skill.getName());
        }
    }

    private void testAddSkillToEmployee() {

        Employee employee = employeeService.get(1);

        Skill skill = skillService.get(2);

        employee.getSkillList().add(skill);

        employeeService.save(employee);

        System.out.println("Skill Added Successfully");
    }
}