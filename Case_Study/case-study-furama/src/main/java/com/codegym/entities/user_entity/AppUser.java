package com.codegym.entities.user_entity;

import com.codegym.entities.employee_entity.Employee;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "user")
public class AppUser {
    @Id
    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> role;

    @OneToMany(mappedBy = "appUser",cascade = CascadeType.ALL)
    List<Employee> employee;

    public AppUser() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}
