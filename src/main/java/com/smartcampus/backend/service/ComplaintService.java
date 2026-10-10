
package com.smartcampus.backend.service;

import com.smartcampus.backend.dao.ComplaintDao;
import com.smartcampus.backend.model.Complaint;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ComplaintService {

    private final ComplaintDao complaintDao;

    public ComplaintService(ComplaintDao complaintDao) {
        this.complaintDao = complaintDao;
    }

    public int submitComplaint(Complaint complaint) {
        return complaintDao.submitComplaint(complaint);
    }

    public List<Complaint> getStudentComplaints(int studentId) {
        return complaintDao.getStudentComplaints(studentId);
    }

    public List<Complaint> getAllComplaints() {
        return complaintDao.getAllComplaints();
    }

    public int updateComplaint(
            int complaintId,
            String department,
            String status,
            String resolution) {

        return complaintDao.updateComplaint(
                complaintId, department, status, resolution
        );
    }

    public int updateStudentComplaint(
            int complaintId,
            int studentId,
            String category,
            String title,
            String description,
            String priority) {

        return complaintDao.updateStudentComplaint(
                complaintId,
                studentId,
                category,
                title,
                description,
                priority
        );
    }

    public int deleteStudentComplaint(
            int complaintId,
            int studentId) {

        return complaintDao.deleteStudentComplaint(
                complaintId, studentId
        );
    }

    public Map<String, Object> getComplaintStatistics() {
        return complaintDao.getComplaintStatistics();
    }
}
