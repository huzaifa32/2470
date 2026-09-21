package com.cleancode.service;

import java.util.*;

import com.cleancode.domain.Student;

public interface StudentService {

    public void addStudent(Student student);
    public List<Student> findAllstudents();
    Student findStudent(int id);
    void updateStudent(Student student);
    void deleteStudent(int id);
    //missed this in lecture
    
}
