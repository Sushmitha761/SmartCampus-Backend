package com.smartcampus.backend.model;

public class ComplaintStatistics {

    private Integer totalComplaints;
    private Integer pendingComplaints;
    private Integer inProgressComplaints;
    private Integer resolvedComplaints;
    private Integer rejectedComplaints;

    public ComplaintStatistics() {
    }

    public ComplaintStatistics(
            Integer totalComplaints,
            Integer pendingComplaints,
            Integer inProgressComplaints,
            Integer resolvedComplaints,
            Integer rejectedComplaints) {

        this.totalComplaints = totalComplaints;
        this.pendingComplaints = pendingComplaints;
        this.inProgressComplaints = inProgressComplaints;
        this.resolvedComplaints = resolvedComplaints;
        this.rejectedComplaints = rejectedComplaints;
    }

    public Integer getTotalComplaints() {
        return totalComplaints;
    }

    public void setTotalComplaints(Integer totalComplaints) {
        this.totalComplaints = totalComplaints;
    }

    public Integer getPendingComplaints() {
        return pendingComplaints;
    }

    public void setPendingComplaints(Integer pendingComplaints) {
        this.pendingComplaints = pendingComplaints;
    }

    public Integer getInProgressComplaints() {
        return inProgressComplaints;
    }

    public void setInProgressComplaints(Integer inProgressComplaints) {
        this.inProgressComplaints = inProgressComplaints;
    }

    public Integer getResolvedComplaints() {
        return resolvedComplaints;
    }

    public void setResolvedComplaints(Integer resolvedComplaints) {
        this.resolvedComplaints = resolvedComplaints;
    }

    public Integer getRejectedComplaints() {
        return rejectedComplaints;
    }

    public void setRejectedComplaints(Integer rejectedComplaints) {
        this.rejectedComplaints = rejectedComplaints;
    }
}