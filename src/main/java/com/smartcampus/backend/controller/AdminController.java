
package com.smartcampus.backend.controller;

import com.smartcampus.backend.model.Admin;
import com.smartcampus.backend.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginAdmin(
            @RequestBody Admin admin) {

        if (admin.getEmail() == null || admin.getPassword() == null) {
            return ResponseEntity.badRequest()
                    .body("Email and password are required!");
        }

        boolean valid = adminService.loginAdmin(
                admin.getEmail(),
                admin.getPassword()
        );

        if (valid) {
            return ResponseEntity.ok("Admin login successful!");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Invalid admin email or password!");
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerAdmin(
            @RequestBody Admin admin) {

        String result = adminService.registerAdmin(admin);

        if ("Admin registration successful!".equals(result)) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(result);
        }

        return ResponseEntity.badRequest().body(result);
    }
}
