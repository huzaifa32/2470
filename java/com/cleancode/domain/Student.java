package com.cleancode.domain;

public class Student {

    private int id;
    private String name;
    private String major;
    private double gpa;


    public Student(int id, String name, String major, double gpa){
        this.id=id;
        this.name=name;
        this.major=major;
        this.gpa=gpa;
    }

    //setters
    public void setID(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setMajor(String major){
        this.major=major;
    }
    public void setGpa(double gpa){
        this.gpa=gpa;
    }

    //getters
    public int getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getMajor(){
        return major;
    }
    public double getGpa(){
        return gpa;
    }

    public String toFileString(){
        return id+", "+name+", "+major+", "+gpa;
    }

    //id, name, major, gpa
    public static Student fromFileString(String line){
        String[] parts = line.split(",");

        return new Student(Integer.parseInt(parts[0]), parts[1], parts[2], Double.parseDouble(parts[3]));

    }

    @Override 
    public String toString(){
        return String.format("ID: %d | Name: %s | Major: %s | GPA: %f ",id,name,major,gpa);
    }
    
}
