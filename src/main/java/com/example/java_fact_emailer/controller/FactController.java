package com.example.java_fact_emailer.controller;

import com.example.java_fact_emailer.service.EmailSenderService;
import com.example.java_fact_emailer.service.FactFetcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactController {
    @Autowired
    private FactFetcherService factService;
    @Autowired
    private EmailSenderService emailService;

    @GetMapping("/send-fact")
    public String sendFact(@RequestParam(value = "email", required = true) String email) {
        if (email == null || email.trim().isEmpty() || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            return "Error: Invalid or missing email address";
        }
        try {
            String formattedFact = factService.fetchAndFormatFact();
            emailService.sendEmail(email, "Your Daily Java Fact", formattedFact);
            return "Fact sent to " + email + ": " + formattedFact;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
    @GetMapping("/")
    public String home() {
        return "Welcome to Java Fact Emailer! Use /send-fact?email=recipient@example.com to send a fact.";
    }
}