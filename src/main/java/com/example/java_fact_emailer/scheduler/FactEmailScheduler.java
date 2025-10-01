package com.example.java_fact_emailer.scheduler;

import com.example.java_fact_emailer.service.EmailSenderService;
import com.example.java_fact_emailer.service.FactFetcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FactEmailScheduler {
    @Autowired
    private FactFetcherService factService;
    @Autowired
    private EmailSenderService emailService;
    @Value("${recipient.email:default@example.com}")
    private String recipientEmail;

//    @Scheduled(fixedRate = 60000)
    @Scheduled(cron = "0 30 3 * * ?") // 3:30 AM UTC = 9:00 AM IST
    public void sendDailyFact() {
        if (recipientEmail == null || recipientEmail.trim().isEmpty()) {
            System.err.println("Scheduler error: Recipient email is null or empty");
            return;
        }
        try {
            String formattedFact = factService.fetchAndFormatFact();
            emailService.sendEmail(recipientEmail, "Your Daily Java Fact", formattedFact);
            System.out.println("Email sent to " + recipientEmail + " at: " + new java.util.Date());
        } catch (Exception e) {
            System.err.println("Scheduler error: " + e.getMessage());
        }
    }
}