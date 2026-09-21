package com.cleancode.api;
import java.util.Scanner;
import com.cleancode.service.*;
import com.cleancode.domain.*;

public class StudentRepl {

    private final Scanner scanner = new Scanner(System.in);
    private final StudentService studentService;

    public StudentRepl(StudentService svc){
        this.studentService = svc;

    }

    public void run(){
        while(true){
            System.out.println(">");
            String command  = scanner.nextLine().trim();

            if(command.equals("exit")){
                return;
            }

            try{
                handle(command);

            } catch(IllegalArgumentException e){
                System.out.println("error: "+e.getMessage());

            }
        }
    }


    private void handle(String command){
        switch (command) {
            case "help" -> printHelp();
            case "add" -> studentService.addStudent(readStudent());
            case "list" -> studentService.findAllstudents().forEach(s -> System.out.println("ID: "+s.getID()));
            case "find" -> findStudent();
            case "update" -> studentService.updateStudent(readStudent());
            case "delete" -> studentService.deleteStudent(readInt("Student ID: "));

        }
    }

    private void findStudent(){
        System.out.println("student id: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

    }

    private Student readStudent(){
        System.out.println("Enter Student ID: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Enter Student Name: ");
        String name = scanner.nextLine().trim();

        System.out.println("Enter a Major: ");
        String major = scanner.nextLine().trim();

        System.out.println("Enter GPA: ");
        double gpa = readDouble("GPA: ");

        return new Student(id,name,major,gpa);
        
    }

    private int readInt(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine().trim());
    }

    private double readDouble(String prompt) {
        System.out.print(prompt);
        return Double.parseDouble(scanner.nextLine().trim());
    }

    private void printHelp(){
        System.out.println();
        System.out.println("Available commands: ");
        System.out.println("add - add new student ");
        System.out.println("list - list all student ");
        System.out.println("find - find all student by id");
        System.out.println("exit - exit the application. ");
    }
    
}
