
package com.smartcampus.backend.dao;

import com.smartcampus.backend.model.Admin;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {

    private final JdbcTemplate jdbcTemplate;

    public AdminDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean loginAdmin(String email, String password) {
        String sql = """
                SELECT COUNT(*)
                FROM admins
                WHERE email = ? AND password = ?
                """;

        Integer count = jdbcTemplate.queryForObject(
                sql, Integer.class, email, password
        );

        return count != null && count > 0;
    }

    public boolean emailExists(String email) {
        String sql = "SELECT COUNT(*) FROM admins WHERE email = ?";

        Integer count = jdbcTemplate.queryForObject(
                sql, Integer.class, email
        );

        return count != null && count > 0;
    }

    public void registerAdmin(Admin admin) {
        String sql = """
                INSERT INTO admins (name, email, password)
                VALUES (?, ?, ?)
                """;

        jdbcTemplate.update(
                sql,
                admin.getName(),
                admin.getEmail(),
                admin.getPassword()
        );
    }
}
