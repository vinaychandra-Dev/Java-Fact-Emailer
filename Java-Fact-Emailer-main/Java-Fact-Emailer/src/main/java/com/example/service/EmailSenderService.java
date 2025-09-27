package com.example.service;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String recipientmail, String subject, String text) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(recipientmail);
            helper.setSubject(subject);
            String htmlContent = "<h3" + subject + "</h3>" +
                    "<p>" + text.replace("\n", "<br>") + "</p>";
            helper.setText(htmlContent, true);
            mailSender.send(message);
            System.out.println("Email sent email : " + recipientmail);
        } catch (MailException | jakarta.mail.MessagingException  e) {
            System.out.println("Error sending email: " + e.getMessage());
            throw new RuntimeException("Email sending failed", e);
        }
    }
}


