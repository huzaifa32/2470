package com.cleancode.service;
import java.util.*;

import com.cleancode.domain.Student;
import com.cleancode.persistence.StudentDAO;

public class StudentServiceimpl implements StudentService{
    private final StudentDAO studentDAO;

    public StudentServiceimpl(StudentDAO studentDAO){
        this.studentDAO=studentDAO;
    }

    @Override 
    public Student findStudent(int id){
        return studentDAO.getStudentById(id);
    }


    /* 
    @Override 
    public Student getStudentById(int id){
        List<Student> students = studentDAO.getAllStudents();
        Student res = new Student(id, null, null, id);

        for(Student s : students ){
            if(s.getID()==id){
                res = s; 
            }
        }

        return res;
    }
    */

    @Override 
    public void addStudent(Student student){
         
        if(studentDAO.getStudentById(student.getID()) !=null){
            throw new IllegalArgumentException("Student ID already exists");
        } 


        studentDAO.addStudent(student);
    }


    @Override 
    public List<Student> findAllstudents(){
        return studentDAO.getAllStudents();
    }

    @Override
    public void updateStudent(Student student) {
        if (studentDAO.getStudentById(student.getID()) == null) {
            throw new IllegalArgumentException("Student not found");
        }

        studentDAO.updateStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        if (studentDAO.getStudentById(id) == null) {
            throw new IllegalArgumentException("Student not found");
        }

        studentDAO.deleteStudent(id);
    }
    
}
