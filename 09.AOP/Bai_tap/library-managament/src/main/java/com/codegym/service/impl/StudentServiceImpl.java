package com.codegym.service.impl;

import com.codegym.entity.Book;
import com.codegym.entity.Student;
import com.codegym.repository.StudentRepository;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public void remove(int id) {
        this.studentRepository.deleteById(id);
    }

    @Override
    public Student findById(int id) {
        return this.studentRepository.findById(id).get();
    }
}
