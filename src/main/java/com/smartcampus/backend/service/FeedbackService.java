
package com.smartcampus.backend.service;

import com.smartcampus.backend.dao.FeedbackDao;
import com.smartcampus.backend.model.Feedback;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    private final FeedbackDao feedbackDao;

    public FeedbackService(FeedbackDao feedbackDao) {
        this.feedbackDao = feedbackDao;
    }

    public int submitFeedback(Feedback feedback) {

        return feedbackDao.saveFeedback(feedback);
    }
}