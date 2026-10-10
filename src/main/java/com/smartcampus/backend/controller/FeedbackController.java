

package com.smartcampus.backend.controller;

import com.smartcampus.backend.model.Feedback;
import com.smartcampus.backend.service.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(
            FeedbackService feedbackService) {

        this.feedbackService = feedbackService;
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitFeedback(
            @RequestBody Feedback feedback) {

        try {

            int result =
                    feedbackService.submitFeedback(
                            feedback
                    );

            if (result > 0) {

                return ResponseEntity.ok(
                        "Feedback submitted successfully!"
                );
            }

            return ResponseEntity.badRequest().body(
                    "Feedback submission failed!"
            );

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity.badRequest().body(
                    "Feedback failed: "
                    + e.getMessage()
            );
        }
    }
}