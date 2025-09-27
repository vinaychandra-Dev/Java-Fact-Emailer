package com.example.controller;

import com.example.service.EmailSenderService;
import com.example.service.FactFetcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactController {
    @Autowired
    private  FactFetcherService factFetcherService;
    @Autowired
    private EmailSenderService emailSenderService;


    @GetMapping("/sendFacts")
    public String sendFacts(@RequestParam String email) {
        try{
            String facts = factFetcherService.FetchJavaFacts();
            emailSenderService.sendEmail(email, "Your Daily Java Facts", facts);
            return "Facts email sent to " + email;
        }catch (Exception e){
            return "Error in sending facts email: " + e.getMessage();
        }
    }
}
