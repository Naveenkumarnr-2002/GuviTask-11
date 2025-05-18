package com.example.feedbackform.Controller;

import com.example.feedbackform.DAO.feedbackDAO;
import com.example.feedbackform.Entity.feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class feedbackController {

    @Autowired
    private feedbackDAO feedbackDAO;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("feedback", new feedback());
        return "form";
    }

    @PostMapping("/submit")
    public String submitFeedback(@ModelAttribute feedback feedback, Model model) {
        try {
            feedbackDAO.saveFeedback(feedback);
            model.addAttribute("message", "feedback saved");
        } catch (Exception e) {
            model.addAttribute("message", "error saving feedback");
        }
        return "result";
    }
}

