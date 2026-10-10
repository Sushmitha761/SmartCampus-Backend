package com.smartcampus.backend.model;


public class Complaint {


    // ========================================
    // VARIABLES
    // ========================================

    private int id;

    private Integer studentId;

    private String category;

    private String title;

    private String description;

    private String priority;

    private String status;

    private String department;

    private String resolution;


    // ========================================
    // DEFAULT CONSTRUCTOR
    // ========================================

    public Complaint() {
    }


    // ========================================
    // CONSTRUCTOR
    // ========================================

    public Complaint(
            Integer studentId,
            String category,
            String title,
            String description,
            String priority) {

        this.studentId = studentId;

        this.category = category;

        this.title = title;

        this.description = description;

        this.priority = priority;
    }


    // ========================================
    // ID
    // ========================================

    public int getId() {

        return id;
    }


    public void setId(int id) {

        this.id = id;
    }


    // ========================================
    // STUDENT ID
    // ========================================

    public Integer getStudentId() {

        return studentId;
    }


    public void setStudentId(Integer studentId) {

        this.studentId = studentId;
    }


    // ========================================
    // CATEGORY
    // ========================================

    public String getCategory() {

        return category;
    }


    public void setCategory(String category) {

        this.category = category;
    }


    // ========================================
    // TITLE
    // ========================================

    public String getTitle() {

        return title;
    }


    public void setTitle(String title) {

        this.title = title;
    }


    // ========================================
    // DESCRIPTION
    // ========================================

    public String getDescription() {

        return description;
    }


    public void setDescription(String description) {

        this.description = description;
    }


    // ========================================
    // PRIORITY
    // ========================================

    public String getPriority() {

        return priority;
    }


    public void setPriority(String priority) {

        this.priority = priority;
    }


    // ========================================
    // STATUS
    // ========================================

    public String getStatus() {

        return status;
    }


    public void setStatus(String status) {

        this.status = status;
    }


    // ========================================
    // DEPARTMENT
    // ========================================

    public String getDepartment() {

        return department;
    }


    public void setDepartment(String department) {

        this.department = department;
    }


    // ========================================
    // RESOLUTION
    // ========================================

    public String getResolution() {

        return resolution;
    }


    public void setResolution(String resolution) {

        this.resolution = resolution;
    }

}