package com.codegym.service.employee_service.impl;

import com.codegym.entities.employee_entity.Division;
import com.codegym.entities.employee_entity.EducationDegree;
import com.codegym.entities.employee_entity.Employee;
import com.codegym.entities.employee_entity.Position;
import com.codegym.entities.user_entity.AppUser;
import com.codegym.repository.employee_repository.*;
import com.codegym.repository.user_repository.UserRepository;
import com.codegym.service.employee_service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    PositionRepository positionRepository;
    @Autowired
    DivisionRepository divisionRepository;
    @Autowired
    EducationDegreeRepository educationDegreeRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return this.employeeRepository.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return this.employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findAllByEmployeeNameContaining(Pageable pageable, String keyword) {
        return this.employeeRepository.findAllByEmployeeNameContaining(pageable,keyword);
    }

    @Override
    public List<Position> listPosition() {
        return this.positionRepository.findAll();
    }

    @Override
    public List<Division> listDivision() {
        return this.divisionRepository.findAll();
    }

    @Override
    public List<EducationDegree> listEducationDegree() {
        return this.educationDegreeRepository.findAll();
    }

    @Override
    public List<AppUser> listUser() {
        return this.userRepository.findAll();
    }
}
