
package com.smartcampus.backend.dao;

import com.smartcampus.backend.model.Complaint;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ComplaintDao {

    private final JdbcTemplate jdbcTemplate;

    public ComplaintDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Complaint> complaintRowMapper =
            (rs, rowNum) -> {
                Complaint complaint = new Complaint();

                complaint.setId(rs.getInt("id"));
                complaint.setStudentId(rs.getInt("student_id"));
                complaint.setCategory(rs.getString("category"));
                complaint.setTitle(rs.getString("title"));
                complaint.setDescription(rs.getString("description"));
                complaint.setPriority(rs.getString("priority"));
                complaint.setStatus(rs.getString("status"));
                complaint.setDepartment(rs.getString("department"));
                complaint.setResolution(rs.getString("resolution"));

                return complaint;
            };

    // CREATE: Submit complaint
    public int submitComplaint(Complaint complaint) {
        String sql = """
                INSERT INTO complaints
                (student_id, category, title, description,
                 priority, status, department, resolution)
                VALUES (?, ?, ?, ?, ?, 'Pending', ?, ?)
                """;

        return jdbcTemplate.update(
                sql,
                complaint.getStudentId(),
                complaint.getCategory(),
                complaint.getTitle(),
                complaint.getDescription(),
                complaint.getPriority(),
                complaint.getDepartment(),
                complaint.getResolution()
        );
    }

    // READ: Student complaints
    public List<Complaint> getStudentComplaints(int studentId) {
        String sql = """
                SELECT *
                FROM complaints
                WHERE student_id = ?
                ORDER BY id DESC
                """;

        return jdbcTemplate.query(
                sql, complaintRowMapper, studentId
        );
    }

    // READ: All complaints for Admin
    public List<Complaint> getAllComplaints() {
        String sql = """
                SELECT *
                FROM complaints
                ORDER BY id DESC
                """;

        return jdbcTemplate.query(sql, complaintRowMapper);
    }

    // UPDATE: Admin updates department, status, resolution
    public int updateComplaint(
            int complaintId,
            String department,
            String status,
            String resolution) {

        String sql = """
                UPDATE complaints
                SET department = ?,
                    status = ?,
                    resolution = ?
                WHERE id = ?
                """;

        return jdbcTemplate.update(
                sql, department, status, resolution, complaintId
        );
    }

    // UPDATE: Student edits own Pending complaint
    public int updateStudentComplaint(
            int complaintId,
            int studentId,
            String category,
            String title,
            String description,
            String priority) {

        String sql = """
                UPDATE complaints
                SET category = ?,
                    title = ?,
                    description = ?,
                    priority = ?
                WHERE id = ?
                  AND student_id = ?
                  AND status = 'Pending'
                """;

        return jdbcTemplate.update(
                sql,
                category,
                title,
                description,
                priority,
                complaintId,
                studentId
        );
    }

    // DELETE: Student deletes own Pending complaint
    public int deleteStudentComplaint(
            int complaintId,
            int studentId) {

        String sql = """
                DELETE FROM complaints
                WHERE id = ?
                  AND student_id = ?
                  AND status = 'Pending'
                """;

        return jdbcTemplate.update(
                sql, complaintId, studentId
        );
    }

    // READ: Admin complaint statistics
    public Map<String, Object> getComplaintStatistics() {
        String sql = """
                SELECT
                    COUNT(*) AS totalComplaints,
                    COALESCE(SUM(
                        CASE WHEN status = 'Pending'
                        THEN 1 ELSE 0 END
                    ), 0) AS pendingComplaints,
                    COALESCE(SUM(
                        CASE WHEN status = 'In Progress'
                        THEN 1 ELSE 0 END
                    ), 0) AS inProgressComplaints,
                    COALESCE(SUM(
                        CASE WHEN status = 'Resolved'
                        THEN 1 ELSE 0 END
                    ), 0) AS resolvedComplaints,
                    COALESCE(SUM(
                        CASE WHEN status = 'Rejected'
                        THEN 1 ELSE 0 END
                    ), 0) AS rejectedComplaints
                FROM complaints
                """;

        return jdbcTemplate.queryForMap(sql);
    }
}
