package com.smartcampus.backend.dao;

import com.smartcampus.backend.model.Feedback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FeedbackDao {

    private final JdbcTemplate jdbcTemplate;

    public FeedbackDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveFeedback(Feedback feedback) {

        String sql = """
                INSERT INTO feedback
                (complaint_id, student_id, rating, comments)
                VALUES (?, ?, ?, ?)
                """;

        return jdbcTemplate.update(
                sql,
                feedback.getComplaintId(),
                feedback.getStudentId(),
                feedback.getRating(),
                feedback.getComments()
        );
    }
}
