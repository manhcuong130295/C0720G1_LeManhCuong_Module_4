package com.codegym.service.employee_service;

import com.codegym.entities.employee_entity.Division;
import com.codegym.entities.employee_entity.EducationDegree;
import com.codegym.entities.employee_entity.Employee;
import com.codegym.entities.employee_entity.Position;
import com.codegym.entities.user_entity.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    void save(Employee employee);

    Employee findById(int id);


    void remove(int id);

    Page<Employee> findAllByEmployeeNameContaining(Pageable pageable,String keyword);
    List<Position> listPosition();
    List<Division> listDivision();
    List<EducationDegree> listEducationDegree();
    List<AppUser> listUser();
}
