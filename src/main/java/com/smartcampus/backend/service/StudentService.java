package com.smartcampus.backend.service;

import com.smartcampus.backend.dao.StudentDao;
import com.smartcampus.backend.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    /* =========================
       CREATE
       ========================= */

    public int saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    /* =========================
       LOGIN
       ========================= */

    public String loginStudent(Student student) {
        return studentDao.loginStudent(student);
    }

    /* =========================
       GET STUDENT ID
       ========================= */

    public Integer getStudentIdByRollNo(String rollNo) {
        return studentDao.getStudentIdByRollNo(rollNo);
    }

    /* =========================
       READ PROFILE
       ========================= */

    public Student getStudentByRollNo(String rollNo) {
        return studentDao.getStudentByRollNo(rollNo);
    }

    /* =========================
       UPDATE
       ========================= */

    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    /* =========================
       DELETE
       ========================= */

    public int deleteStudent(String rollNo) {
        return studentDao.deleteStudent(rollNo);
    }
}