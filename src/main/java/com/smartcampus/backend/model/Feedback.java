package com.smartcampus.backend.model;

public class Feedback {

    private Integer id;
    private Integer complaintId;
    private Integer studentId;
    private Integer rating;
    private String comments;

    public Feedback() {
    }

    public Feedback(
            Integer complaintId,
            Integer studentId,
            Integer rating,
            String comments) {

        this.complaintId = complaintId;
        this.studentId = studentId;
        this.rating = rating;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}