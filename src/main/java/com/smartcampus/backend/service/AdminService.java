
package com.smartcampus.backend.service;

import com.smartcampus.backend.dao.AdminDao;
import com.smartcampus.backend.model.Admin;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminDao adminDao;

    public AdminService(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public boolean loginAdmin(String email, String password) {
        if (email == null || password == null) {
            return false;
        }

        return adminDao.loginAdmin(
                email.trim().toLowerCase(),
                password
        );
    }

    public String registerAdmin(Admin admin) {
        if (admin == null
                || admin.getName() == null
                || admin.getName().isBlank()
                || admin.getEmail() == null
                || admin.getEmail().isBlank()
                || admin.getPassword() == null
                || admin.getPassword().isBlank()) {
            return "Name, email and password are required!";
        }

        String name = admin.getName().trim();
        String email = admin.getEmail().trim().toLowerCase();
        String password = admin.getPassword();

        if (name.length() > 100 || email.length() > 100) {
            return "Name or email is too long!";
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            return "Please enter a valid email!";
        }

        if (password.length() < 8) {
            return "Password must contain at least 8 characters!";
        }

        if (adminDao.emailExists(email)) {
            return "Email already registered!";
        }

        admin.setName(name);
        admin.setEmail(email);

        try {
            adminDao.registerAdmin(admin);
            return "Admin registration successful!";
        } catch (DuplicateKeyException e) {
            return "Email already registered!";
        }
    }
}
