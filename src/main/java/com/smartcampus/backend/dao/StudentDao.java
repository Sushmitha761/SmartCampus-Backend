package com.smartcampus.backend.dao;

import com.smartcampus.backend.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {

    private final JdbcTemplate jdbcTemplate;

    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /* =========================
       CREATE - REGISTER STUDENT
       ========================= */

    public int saveStudent(Student student) {

        String sql = """
                INSERT INTO students
                (name, roll_no, email, password, department, year, phone)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        return jdbcTemplate.update(
                sql,
                student.getName(),
                student.getRollNo(),
                student.getEmail(),
                student.getPassword(),
                student.getDepartment(),
                student.getYear(),
                student.getPhone()
        );
    }

    /* =========================
       LOGIN STUDENT
       ========================= */

    public String loginStudent(Student student) {

        String sql = """
                SELECT COUNT(*)
                FROM students
                WHERE roll_no = ?
                AND password = ?
                """;

        Integer count = jdbcTemplate.queryForObject(
                sql,
                Integer.class,
                student.getRollNo(),
                student.getPassword()
        );

        if (count != null && count > 0) {
            return "Login successful!";
        }

        return "Invalid roll number or password";
    }

    /* =========================
       GET STUDENT ID
       ========================= */

    public Integer getStudentIdByRollNo(String rollNo) {

        String sql = """
                SELECT id
                FROM students
                WHERE roll_no = ?
                """;

        List<Integer> result = jdbcTemplate.query(
                sql,
                (rs, rowNum) -> rs.getInt("id"),
                rollNo
        );

        if (result.isEmpty()) {
            return null;
        }

        return result.get(0);
    }

    /* =========================
       READ - GET STUDENT PROFILE
       ========================= */

    public Student getStudentByRollNo(String rollNo) {

        String sql = """
                SELECT
                    id,
                    name,
                    roll_no,
                    email,
                    password,
                    department,
                    year,
                    phone
                FROM students
                WHERE roll_no = ?
                """;

        List<Student> students = jdbcTemplate.query(
                sql,
                (rs, rowNum) -> {

                    Student student = new Student();

                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setRollNo(rs.getString("roll_no"));
                    student.setEmail(rs.getString("email"));
                    student.setPassword(rs.getString("password"));
                    student.setDepartment(rs.getString("department"));
                    student.setYear(rs.getInt("year"));
                    student.setPhone(rs.getString("phone"));

                    return student;
                },
                rollNo
        );

        if (students.isEmpty()) {
            return null;
        }

        return students.get(0);
    }

    /* =========================
       UPDATE - STUDENT PROFILE
       ========================= */

    public int updateStudent(Student student) {

        String sql = """
                UPDATE students
                SET
                    name = ?,
                    email = ?,
                    department = ?,
                    year = ?,
                    phone = ?
                WHERE roll_no = ?
                """;

        return jdbcTemplate.update(
                sql,
                student.getName(),
                student.getEmail(),
                student.getDepartment(),
                student.getYear(),
                student.getPhone(),
                student.getRollNo()
        );
    }

    /* =========================
       DELETE - STUDENT
       ========================= */

    public int deleteStudent(String rollNo) {

        String sql = """
                DELETE FROM students
                WHERE roll_no = ?
                """;

        return jdbcTemplate.update(sql, rollNo);
    }
}