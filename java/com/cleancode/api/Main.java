package com.cleancode.api;

import com.cleancode.persistence.*;
import com.cleancode.service.*;

public class Main {
    public static void main(String[] args) {


        StudentDAO dao = new StudentDAOimpl("students.txt");
        StudentService studentService = new StudentServiceimpl(dao);
        new StudentRepl(studentService).run();
        
    }
    
}
