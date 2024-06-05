package com.app.web.controller;

import com.app.web.service.EmailRequest;
import com.app.web.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {

    @Autowired
    private SendEmailService sendEmailService;

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        sendEmailService.sendEmail(emailRequest.getRecipient(), emailRequest.getBody(), emailRequest.getSubject());
        return "Email sent successfully";
    }
}
