package com.smartcampus.backend.model;

public class Student {

    private Integer id;
    private String name;
    private String rollNo;
    private String email;
    private String password;
    private String department;
    private Integer year;
    private String phone;

    public Student() {
    }

    public Student(
            Integer id,
            String name,
            String rollNo,
            String email,
            String password,
            String department,
            Integer year,
            String phone) {

        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.email = email;
        this.password = password;
        this.department = department;
        this.year = year;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}