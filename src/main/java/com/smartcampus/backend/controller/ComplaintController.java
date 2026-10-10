
package com.smartcampus.backend.controller;

import com.smartcampus.backend.model.Complaint;
import com.smartcampus.backend.service.ComplaintService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin(origins = "http://localhost:5173")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    // CREATE: Submit complaint
    @PostMapping("/submit")
    public ResponseEntity<?> submitComplaint(
            @RequestBody Complaint complaint) {

        if (complaint.getStudentId() == null
                || complaint.getCategory() == null
                || complaint.getTitle() == null
                || complaint.getDescription() == null
                || complaint.getPriority() == null) {

            return ResponseEntity.badRequest()
                    .body("Required complaint details are missing.");
        }

        int result = complaintService.submitComplaint(complaint);

        if (result > 0) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Complaint submitted successfully.");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Unable to submit complaint.");
    }

    // READ: Get complaints for a student
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Complaint>> getStudentComplaints(
            @PathVariable int studentId) {

        return ResponseEntity.ok(
                complaintService.getStudentComplaints(studentId)
        );
    }

    // READ: Get all complaints for Admin
    @GetMapping("/all")
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        return ResponseEntity.ok(
                complaintService.getAllComplaints()
        );
    }

    // UPDATE: Admin updates complaint
    @PutMapping("/update/{complaintId}")
    public ResponseEntity<?> updateComplaint(
            @PathVariable int complaintId,
            @RequestBody Complaint complaint) {

        int result = complaintService.updateComplaint(
                complaintId,
                complaint.getDepartment(),
                complaint.getStatus(),
                complaint.getResolution()
        );

        if (result > 0) {
            return ResponseEntity.ok(
                    "Complaint updated successfully."
            );
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Complaint not found.");
    }

    // UPDATE: Student edits own Pending complaint
    @PutMapping("/student/update/{complaintId}/{studentId}")
    public ResponseEntity<?> updateStudentComplaint(
            @PathVariable int complaintId,
            @PathVariable int studentId,
            @RequestBody Complaint complaint) {

        int result = complaintService.updateStudentComplaint(
                complaintId,
                studentId,
                complaint.getCategory(),
                complaint.getTitle(),
                complaint.getDescription(),
                complaint.getPriority()
        );

        if (result > 0) {
            return ResponseEntity.ok(
                    "Complaint updated successfully."
            );
        }

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Complaint cannot be edited. Check ownership and status.");
    }

    // DELETE: Student deletes own Pending complaint
    @DeleteMapping("/student/delete/{complaintId}/{studentId}")
    public ResponseEntity<?> deleteStudentComplaint(
            @PathVariable int complaintId,
            @PathVariable int studentId) {

        int result = complaintService.deleteStudentComplaint(
                complaintId, studentId
        );

        if (result > 0) {
            return ResponseEntity.ok(
                    "Complaint deleted successfully."
            );
        }

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Complaint cannot be deleted. Check ownership and status.");
    }

    // READ: Admin statistics
    @GetMapping("/statistics")
    public ResponseEntity<Map<String, Object>> getComplaintStatistics() {
        return ResponseEntity.ok(
                complaintService.getComplaintStatistics()
        );
    }
}
