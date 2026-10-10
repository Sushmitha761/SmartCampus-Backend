package com.smartcampus.backend.service;

import com.smartcampus.backend.dao.DepartmentDao;
import com.smartcampus.backend.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentDao departmentDao;

    public DepartmentService(
            DepartmentDao departmentDao) {

        this.departmentDao = departmentDao;
    }


    // ========================================
    // GET ALL DEPARTMENTS
    // ========================================

    public List<Department> getAllDepartments() {

        return departmentDao.getAllDepartments();
    }


    // ========================================
    // ADD DEPARTMENT
    // ========================================

    public int addDepartment(
            String departmentName,
            String staffName,
            String email) {

        return departmentDao.addDepartment(
                departmentName,
                staffName,
                email
        );
    }


    // ========================================
    // UPDATE DEPARTMENT
    // ========================================

    public int updateDepartment(
            int id,
            String departmentName,
            String staffName,
            String email) {

        return departmentDao.updateDepartment(
                id,
                departmentName,
                staffName,
                email
        );
    }


    // ========================================
    // DELETE DEPARTMENT
    // ========================================

    public int deleteDepartment(int id) {

        return departmentDao.deleteDepartment(id);
    }
}