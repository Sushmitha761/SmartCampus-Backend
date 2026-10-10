package com.smartcampus.backend.controller;

import com.smartcampus.backend.model.Student;
import com.smartcampus.backend.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /* =========================
       CREATE - REGISTER
       ========================= */

    @PostMapping("/register")
    public String registerStudent(@RequestBody Student student) {

        try {

            int result = studentService.saveStudent(student);

            if (result > 0) {
                return "Student registration successful!";
            }

            return "Student registration failed.";

        } catch (Exception e) {

            return "Registration failed: " + e.getMessage();
        }
    }

    /* =========================
       LOGIN
       ========================= */

    @PostMapping("/login")
    public String loginStudent(@RequestBody Student student) {

        return studentService.loginStudent(student);
    }

    /* =========================
       GET STUDENT ID
       ========================= */

    @GetMapping("/id/{rollNo}")
    public Integer getStudentId(@PathVariable String rollNo) {

        return studentService.getStudentIdByRollNo(rollNo);
    }

    /* =========================
       READ - PROFILE
       ========================= */

    @GetMapping("/profile/{rollNo}")
    public Student getStudentProfile(
            @PathVariable String rollNo) {

        Student student =
                studentService.getStudentByRollNo(rollNo);

        return student;
    }

    /* =========================
       LOGIN SUCCESS
       ========================= */

    @GetMapping("/login-success")
    public String loginSuccess() {

        return "Student login API is working!";
    }

    /* =========================
       REGISTER SUCCESS
       ========================= */

    @GetMapping("/register-success")
    public String registerSuccess() {

        return "Student registration API is working!";
    }

    /* =========================
       UPDATE - PROFILE
       ========================= */

    @PutMapping("/update")
    public String updateStudent(
            @RequestBody Student student) {

        int result =
                studentService.updateStudent(student);

        if (result > 0) {
            return "Student details updated successfully!";
        }

        return "Student not found.";
    }

    /* =========================
       DELETE - STUDENT
       ========================= */

    @DeleteMapping("/delete/{rollNo}")
    public String deleteStudent(
            @PathVariable String rollNo) {

        int result =
                studentService.deleteStudent(rollNo);

        if (result > 0) {
            return "Student deleted successfully!";
        }

        return "Student not found.";
    }
}