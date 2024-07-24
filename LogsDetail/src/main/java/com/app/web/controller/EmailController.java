package com.app.web.controller;

import com.app.web.service.EmailRequest;
import com.app.web.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {

    @Autowired
    private SendEmailService sendEmailService;

    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            sendEmailService.sendEmail(emailRequest.getRecipients(), emailRequest.getBody(), emailRequest.getSubject());
            return ResponseEntity.status(HttpStatus.OK).body("Email enviado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al enviar el correo.");

        }
    }
}
