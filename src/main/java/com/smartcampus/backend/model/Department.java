
package com.smartcampus.backend.model;

public class Department {

    private Integer id;
    private String departmentName;
    private String staffName;
    private String email;

    public Department() {
    }

    public Department(
            Integer id,
            String departmentName,
            String staffName,
            String email) {

        this.id = id;
        this.departmentName = departmentName;
        this.staffName = staffName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}