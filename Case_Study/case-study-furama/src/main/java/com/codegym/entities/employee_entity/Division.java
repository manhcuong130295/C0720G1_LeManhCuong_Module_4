package com.codegym.entities.employee_entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "division")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    int id;

    @Column(name = "division_name",columnDefinition = "VARCHAR(45)")
    String divisionName;

    @OneToMany(mappedBy = "division")
    private List<Employee> employee;

    public Division() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}
