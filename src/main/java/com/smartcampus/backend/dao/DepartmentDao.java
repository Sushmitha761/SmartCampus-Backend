
package com.smartcampus.backend.dao;

import com.smartcampus.backend.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDao {

    private final JdbcTemplate jdbcTemplate;

    public DepartmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // ========================================
    // GET ALL DEPARTMENTS
    // ========================================

    public List<Department> getAllDepartments() {

        String sql = """
                SELECT id,
                       department_name,
                       staff_name,
                       email
                FROM departments
                ORDER BY id
                """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> {

                    Department department =
                            new Department();

                    department.setId(
                            rs.getInt("id")
                    );

                    department.setDepartmentName(
                            rs.getString("department_name")
                    );

                    department.setStaffName(
                            rs.getString("staff_name")
                    );

                    department.setEmail(
                            rs.getString("email")
                    );

                    return department;
                }
        );
    }


    // ========================================
    // ADD DEPARTMENT
    // ========================================

    public int addDepartment(
            String departmentName,
            String staffName,
            String email) {

        String sql = """
                INSERT INTO departments
                (department_name, staff_name, email)
                VALUES (?, ?, ?)
                """;

        return jdbcTemplate.update(
                sql,
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

        String sql = """
                UPDATE departments
                SET department_name = ?,
                    staff_name = ?,
                    email = ?
                WHERE id = ?
                """;

        return jdbcTemplate.update(
                sql,
                departmentName,
                staffName,
                email,
                id
        );
    }


    // ========================================
    // DELETE DEPARTMENT
    // ========================================

    public int deleteDepartment(int id) {

        String sql = """
                DELETE FROM departments
                WHERE id = ?
                """;

        return jdbcTemplate.update(
                sql,
                id
        );
    }
}