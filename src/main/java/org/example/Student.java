package org.example;

import java.util.List;

public class Student {
    private String name;

    private String surname;

    private String dormitory;

    private int roomNumber;

    private double accommodationFee;

    private int age;

    private List<String> benefits;

    public Student(String name, String surname, String dormitory, int roomNumber, double accommodationFee, int age, List<String> benefits){
        this.name = name;
        this.surname = surname;
        this.dormitory = dormitory;
        this.roomNumber = roomNumber;
        this.accommodationFee = accommodationFee;
        this.age = age;
        this.benefits = benefits;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getDormitory(){
        return dormitory;
    }

    public void setDormitory(String dormitory){
        this.dormitory = dormitory;
    }

    public int getRoomNumber(){
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }

    public double getAccommodationFee(){
        return accommodationFee;
    }

    public void setAccommodationFee(double accommodationFee){
        this.accommodationFee = accommodationFee;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public List<String> getBenefits(){
        return benefits;
    }

    public void setBenefits(List<String> benefits){
        this.benefits = benefits;
    }

    @Override
    public String toString(){
      return "Student - " + name + ' ' + surname + ' ' + dormitory + ' ' + roomNumber + ' ' + accommodationFee + ' ' + age + ' ' + benefits + '\n';
    }
}
