package com.smartcampus.backend.controller;

import com.smartcampus.backend.model.Department;
import com.smartcampus.backend.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(
            DepartmentService departmentService) {

        this.departmentService =
                departmentService;
    }


    // ========================================
    // GET ALL DEPARTMENTS
    // ========================================

    @GetMapping("/all")
    public ResponseEntity<List<Department>>
    getAllDepartments() {

        try {

            List<Department> departments =
                    departmentService
                            .getAllDepartments();

            return ResponseEntity.ok(
                    departments
            );

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .badRequest()
                    .build();
        }
    }


    // ========================================
    // ADD DEPARTMENT
    // ========================================

    @PostMapping("/add")
    public ResponseEntity<String>
    addDepartment(
            @RequestBody Department department) {

        try {

            int result =
                    departmentService.addDepartment(
                            department.getDepartmentName(),
                            department.getStaffName(),
                            department.getEmail()
                    );

            if (result > 0) {

                return ResponseEntity.ok(
                        "Department added successfully!"
                );
            }

            return ResponseEntity.badRequest().body(
                    "Department addition failed!"
            );

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .badRequest()
                    .body(
                        "Department failed: "
                        + e.getMessage()
                    );
        }
    }


    // ========================================
    // UPDATE DEPARTMENT
    // ========================================

    @PutMapping("/update/{id}")
    public ResponseEntity<String>
    updateDepartment(
            @PathVariable int id,
            @RequestBody Department department) {

        try {

            int result =
                    departmentService.updateDepartment(
                            id,
                            department.getDepartmentName(),
                            department.getStaffName(),
                            department.getEmail()
                    );

            if (result > 0) {

                return ResponseEntity.ok(
                        "Department updated successfully!"
                );
            }

            return ResponseEntity.badRequest().body(
                    "Department update failed!"
            );

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .badRequest()
                    .body(
                        "Department update failed: "
                        + e.getMessage()
                    );
        }
    }


    // ========================================
    // DELETE DEPARTMENT
    // ========================================

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>
    deleteDepartment(
            @PathVariable int id) {

        try {

            int result =
                    departmentService
                            .deleteDepartment(id);

            if (result > 0) {

                return ResponseEntity.ok(
                        "Department deleted successfully!"
                );
            }

            return ResponseEntity.badRequest().body(
                    "Department deletion failed!"
            );

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .badRequest()
                    .body(
                        "Department deletion failed: "
                        + e.getMessage()
                    );
        }
    }
}
