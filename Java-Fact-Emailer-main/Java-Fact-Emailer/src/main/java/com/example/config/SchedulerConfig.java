package com.example.config;

import com.example.service.EmailSenderService;
import com.example.service.FactFetcherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;


@Component
public class SchedulerConfig {
    @Autowired
    private  FactFetcherService factFetcherService;
    @Autowired
    private EmailSenderService emailSenderService;
    @Value("${mail.recipient.to}")
    private  String recipientEmail;

//    @Scheduled(cron = "0 30 3 * * ?") // 3:30 UTC = 9:00 AM IST
    @Scheduled(fixedRate = 600000)
    public  void  sendDailyFacts() {
        try{

            String facts = factFetcherService.FetchJavaFacts();
            emailSenderService.sendEmail(recipientEmail, "Your Daily Java Facts", facts);
            System.out.println("Scheduled email sent successfully."+new java.util.Date());
        }catch (Exception e){
            System.out.println("Error in sending scheduled email: " + e.getMessage());
        }
    }
}

