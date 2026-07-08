package com.cognizant.ormlearn.model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "skill")
public class Skill {

    public Skill() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "skillList")
    private Set<Employee> employeeList;

    // Getter and Setter for id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for name

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for employeeList

    public Set<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(Set<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return name;
    }
}